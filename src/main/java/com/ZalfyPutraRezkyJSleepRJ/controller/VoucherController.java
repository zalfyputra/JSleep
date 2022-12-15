package com.ZalfyPutraRezkyJSleepRJ.controller;

import java.util.*;
import com.ZalfyPutraRezkyJSleepRJ.*;
import com.ZalfyPutraRezkyJSleepRJ.dbjson.JsonAutowired;
import com.ZalfyPutraRezkyJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

/**
 * Control voucher from the front end to the back end
 * @author Zalfy Putra Rezky
 */

@RestController
@RequestMapping("/voucher")
public class VoucherController implements BasicGetController<Voucher>
{
    @JsonAutowired(value = Voucher.class, filepath = "C:\\KULIAH\\SEMESTER 3\\OOP\\PRAKTIKUM\\JSleep\\src\\main\\java\\com\\ZalfyPutraRezkyJSleepRJ\\json\\voucher.json")
    public static JsonTable<Voucher> voucherTable;

    @Override
    public JsonTable<Voucher> getJsonTable(){
        return voucherTable;
    }

    @GetMapping("/{id}/isUsed")
    boolean isUsed(
            @PathVariable int id
    ){
        Voucher voucher = Algorithm.<Voucher>find(getJsonTable(), predicate -> predicate.id == id);
        return voucher.isUsed();
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
    List<Voucher> getAvailable(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int pageSize
    ){
        List<Voucher> list = new ArrayList<Voucher>();
        for(Voucher i : getJsonTable()){
            if(!i.isUsed()){
                list.add(i);
            }
        }
        return Algorithm.<Voucher>paginate(list, page, pageSize, voucher -> !voucher.isUsed());
    }
}