package com.ZalfyPutraRezkyJSleepRJ.controller;

import com.ZalfyPutraRezkyJSleepRJ.*;
import com.ZalfyPutraRezkyJSleepRJ.dbjson.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
public interface BasicGetController <T extends Serializable>
{
    @GetMapping("/page")
    public default List<T> getPage (
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<T>paginate(getJsonTable(), page, pageSize, pred -> true);
    }

    @GetMapping("/{id}")
    default T getbyId(@PathVariable int id) {
        return null;
    }
    public JsonTable<T> getJsonTable();
}
