package com.ZalfyPutraRezkyJSleepRJ.controller;

import java.util.*;
import com.ZalfyPutraRezkyJSleepRJ.Account;
import com.ZalfyPutraRezkyJSleepRJ.Algorithm;
import com.ZalfyPutraRezkyJSleepRJ.City;
import com.ZalfyPutraRezkyJSleepRJ.Facility;
import com.ZalfyPutraRezkyJSleepRJ.Price;
import com.ZalfyPutraRezkyJSleepRJ.Room;
import com.ZalfyPutraRezkyJSleepRJ.dbjson.JsonAutowired;
import com.ZalfyPutraRezkyJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room> {

    @JsonAutowired(value = Room.class, filepath = "src/json/room.json")
    public static JsonTable<Room> roomTable;
    @Override
    public JsonTable<Room> getJsonTable() {
        return roomTable;
    }

    @GetMapping("/{id}/renter")
    List<Room> getRoomRenter
            (
                    @PathVariable int id,
                    @RequestParam(defaultValue = "0") int page,
                    @RequestParam(defaultValue = "5") int pageSize
            )
    {
        return Algorithm.paginate(getJsonTable(), page, pageSize, room -> room.accountId == id);
    }

    @PostMapping("/create")
    public Room create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam int price,
            @RequestParam Facility facility,
            @RequestParam City city,
            @RequestParam String address
    )
    {
        if (Algorithm.<Account>exists(AccountController.accountTable, acc -> acc.id == accountId && acc.renter != null)) {
            Room newRoom = new Room(accountId, name, size, new Price(price), facility, city, address);
            roomTable.add(newRoom);
            return newRoom;
        }
        return null;
    }
}