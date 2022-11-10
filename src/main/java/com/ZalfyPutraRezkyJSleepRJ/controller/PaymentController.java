package com.ZalfyPutraRezkyJSleepRJ.controller;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.ZalfyPutraRezkyJSleepRJ.Account;
import com.ZalfyPutraRezkyJSleepRJ.Payment;
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
    @JsonAutowired(value = Account.class, filepath = "src/json/account.json")
    public static JsonTable<Payment> paymentTable;
    public JsonTable<Payment> getJsonTable(){
        return paymentTable;
    }
    @PostMapping("/accept")
    boolean accept(
            @RequestParam int id
    ){
        if(paymentTable.contains(id)){
            Payment payment = paymentTable.get(id);
            return true;
        }
        else
            return false;
    }
    @PostMapping("/cancel")
    boolean cancel(
            @RequestParam int id
    ){
        if(paymentTable.contains(id)){
            Payment payment = paymentTable.get(id);
            return true;
        }
        else
            return false;
    }
    @PostMapping("/create")
    Payment create(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to
    ) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
        Date fromDate = sdf.parse(from);
        Date toDate = sdf.parse(to);
        return new Payment(buyerId, renterId, roomId, fromDate, toDate);
    }
    @PostMapping("/submit")
    public boolean submit( @RequestParam int id ){
        return false;
    }
}