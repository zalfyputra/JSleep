package com.ZalfyPutraRezkyJSleepRJ.controller;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.ZalfyPutraRezkyJSleepRJ.*;
import com.ZalfyPutraRezkyJSleepRJ.dbjson.JsonAutowired;
import com.ZalfyPutraRezkyJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment>
{
    @JsonAutowired(value = Payment.class, filepath = "src/json/payment.json")
    public static JsonTable<Payment> paymentTable;
    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }
    @PostMapping("/accept")
    boolean accept(
            @RequestParam int id
    ){
        Payment findPayment = Algorithm.<Payment>find(getJsonTable(), payment -> payment.id == id);
        if(findPayment.status == Invoice.PaymentStatus.WAITING) {
            findPayment.status = Invoice.PaymentStatus.SUCCESS;
            return true;
        }
        return false;
    }
    @PostMapping("/cancel")
    boolean cancel(
            @RequestParam int id
    ){
        Payment findPayment = Algorithm.<Payment>find(getJsonTable(), payment -> payment.id == id);
        if(findPayment.status == Invoice.PaymentStatus.WAITING) {
            Account findAccount = Algorithm.<Account>find(AccountController.accountTable, acc -> acc.id == findPayment.buyerId);
            Room findRoom = Algorithm.<Room>find(RoomController.roomTable, room -> room.id == findPayment.getRoomId());
            findPayment.status = Invoice.PaymentStatus.FAILED;
            findAccount.balance += findRoom.price.price;
            return true;
        }
        return false;
    }
    @PostMapping("/create")
    Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    ) {
        Account findAccount = Algorithm.<Account>find(AccountController.accountTable, acc -> acc.id == buyerId);
        Room findRoom = Algorithm.<Room>find(RoomController.roomTable, room -> room.id == roomId);
        double roomPrice = findRoom.price.price;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate;
        Date toDate;
        try {
            fromDate = sdf.parse(from);
            toDate = sdf.parse(to);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        if (findAccount.balance >= roomPrice && Payment.availability(fromDate, toDate, findRoom)) {
            Payment newPayment = new Payment(buyerId, renterId, roomId, fromDate, toDate);
            findAccount.balance -= roomPrice;
            newPayment.status = Invoice.PaymentStatus.WAITING;
            Payment.makeBooking(fromDate, toDate, findRoom);
            paymentTable.add(newPayment);
            return newPayment;
        }
        return null;
    }
    @PostMapping("/submit")
    public boolean submit(
            @RequestParam int id
    ){
        return false;
    }
}