package com.ZalfyPutraRezkyJSleepRJ.controller;

import com.ZalfyPutraRezkyJSleepRJ.Algorithm;
import com.ZalfyPutraRezkyJSleepRJ.Price;
import com.ZalfyPutraRezkyJSleepRJ.Voucher;
import com.ZalfyPutraRezkyJSleepRJ.dbjson.JsonAutowired;
import com.ZalfyPutraRezkyJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher>
{
    @JsonAutowired(value = Voucher.class, filepath = "src/json/voucher.json")
    public static JsonTable<Voucher> voucherTable;

    @Override
    public JsonTable<Voucher> getJsonTable(){
        return voucherTable;
    }

    @GetMapping("/{id}/isUsed")
    boolean isUsed(
            @PathVariable int id
    ){
        return false;
    }

    @GetMapping("/{id}/canApply")
    boolean canApply(
            @PathVariable int id,
            @RequestParam double price
    ){
        Voucher voucher = Algorithm.<Voucher>find(getJsonTable(), pred -> pred.id == id);
        return voucher.canApply(new Price(price));
    }

    @GetMapping("/getAvailable")
    Voucher getAvailable(
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<Voucher>paginate(getJsonTable(), page, pageSize, pred -> true).get(0);
    }
}