package com.ZalfyPutraRezkyJSleepRJ.controller;

import java.util.*;
import com.ZalfyPutraRezkyJSleepRJ.*;
import com.ZalfyPutraRezkyJSleepRJ.dbjson.*;
import org.springframework.web.bind.annotation.*;
/**
 * Controller for Room
 * @author Zalfy Putra Rezky
 */
@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room> {
    @JsonAutowired(value = Room.class, filepath = "C:\\KULIAH\\SEMESTER 3\\OOP\\PRAKTIKUM\\JSleep\\src\\main\\java\\com\\ZalfyPutraRezkyJSleepRJ\\json\\room.json")
    public static JsonTable<Room> roomTable;

    @Override
    public JsonTable<Room> getJsonTable() {
        return roomTable;
    }

    @GetMapping("/{id}/renter")
    List<Room> getRoomRenter(
            @PathVariable int id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int pageSize
    ){
        return Algorithm.paginate(getJsonTable(), page, pageSize, predicate -> predicate.id == id);
    }

    @PostMapping("/create")
    public Room create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int size,
            @RequestParam int price,
            @RequestParam ArrayList<Facility> facility,
            @RequestParam City city,
            @RequestParam String address,
            @RequestParam BedType bedType
    ){
        if(Algorithm.<Account>exists(AccountController.accountTable, acc -> acc.id == accountId && acc.renter != null)){
            Room newRoom = new Room(accountId, name, size, new Price(price), facility, city, address, bedType);
            roomTable.add(newRoom);
            return newRoom;
        }
        return null;
    }

    @GetMapping("/getAllRoom")
    List<Room> getAllRoom(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "13") int pageSize
    ){
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> true);
    }

    @GetMapping("/searchRoom")
    List<Room> searchRoom(
            @RequestParam String roomName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int pageSize

    ){
        return Algorithm.paginate(getJsonTable(), page, pageSize, pred -> pred.name.contains(roomName)); //contains biar bisa partial search
    }

    @GetMapping("/getFilteredRoom")
    List<Room> getFilteredRoom(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "12") int pageSize,
            @RequestParam double priceMin,
            @RequestParam double priceMax,
            @RequestParam(required = false) City city,
            @RequestParam(required = false) BedType bed,
            @RequestParam int minSize,
            @RequestParam int maxSize,
            @RequestParam(required = false) ArrayList<Facility> facility
    ){
        List<Room> filteredRoom = null;
        try{
            List<Room> filteredPrice = null;
            if(priceMax != 0 && city == null && bed == null && minSize == 0 && maxSize == 0 && facility == null){
                filteredRoom = Algorithm.<Room>collect(getJsonTable(), pred -> pred.price.price >= priceMin && pred.price.price <= priceMax);
            }else if(priceMin == 0 && priceMax == 0 && city != null && bed == null && minSize == 0 && maxSize == 0){
                filteredRoom = Algorithm.<Room>collect(getJsonTable(), pred -> pred.city == city && facility == null);
            }else if(priceMin == 0 && priceMax == 0 && city == null && bed != null && minSize == 0 && maxSize == 0){
                filteredRoom = Algorithm.<Room>collect(getJsonTable(), pred -> pred.bedType == bed);
            }else if(priceMin == 0 && priceMax == 0 && city == null && bed == null && maxSize != 0 && facility == null){
                filteredRoom = Algorithm.<Room>collect(getJsonTable(), pred -> pred.size >= minSize && pred.size <= maxSize);
            }else if(priceMin == 0 && priceMax == 0 && city == null && bed == null && minSize == 0 && maxSize == 0 && facility != null){
                filteredRoom = Algorithm.<Room>collect(getJsonTable(), pred -> pred.facility.containsAll(facility));
            }
            return  Algorithm.paginate(filteredRoom, page, pageSize, pred -> true);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}