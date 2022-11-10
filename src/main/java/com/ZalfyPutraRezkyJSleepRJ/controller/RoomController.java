package com.ZalfyPutraRezkyJSleepRJ.controller;

import java.util.*;

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
public class RoomController implements BasicGetController<Room>
{
    @JsonAutowired(value = Room.class, filepath = "src/json/account.json")
    public static JsonTable<Room> roomTable;
    @Override
    public JsonTable<Room> getJsonTable(){
        return roomTable;
    }
    @GetMapping("/{id}/renter")
    List<Room> getRoomByRenter(
            @PathVariable int id,
            @RequestParam int page,
            @RequestParam int pageSize
    ){
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, Room -> Room.id == id);
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
    ){
        Room room = new Room(accountId, name, size, new Price(price), facility, city, address);
        roomTable.add(room);
        return room;
    }
}
