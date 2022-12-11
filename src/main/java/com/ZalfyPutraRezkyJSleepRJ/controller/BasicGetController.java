package com.ZalfyPutraRezkyJSleepRJ.controller;

import java.util.List;
import com.ZalfyPutraRezkyJSleepRJ.*;
import com.ZalfyPutraRezkyJSleepRJ.dbjson.Serializable;
import com.ZalfyPutraRezkyJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

/**
 * A public interface for GetController. Other controller inherits from this class.
 * @param <T> generic
 * @author Zalfy Putra Rezky 2106731453
 */

@RestController
@RequestMapping()
public interface BasicGetController <T extends Serializable> {
    public abstract JsonTable<T> getJsonTable();

    @GetMapping("/{id}")
    public default T getById(@PathVariable int id) {
        Predicate<T> predicate = obj -> obj.id == id;
        return Algorithm.find(getJsonTable(), predicate);
    }

    @GetMapping("/page")
    public default List<T> getPage(
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.paginate(getJsonTable(), page, pageSize, predicate -> true);
    }
}