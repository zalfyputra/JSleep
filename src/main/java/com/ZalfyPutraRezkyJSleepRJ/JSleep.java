package com.ZalfyPutraRezkyJSleepRJ;

import java.util.ArrayList;
import java.util.List;
import com.ZalfyPutraRezkyJSleepRJ.dbjson.JsonDBEngine;
import com.ZalfyPutraRezkyJSleepRJ.dbjson.JsonTable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JSleep
{
    public static void main(String[] args){
        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
        /*
        for(int i = 0; i < 10; i++){
            ThreadingObject thread = new ThreadingObject("Thread " + i);
            thread.start();
        }
        try {
            String filePath = "src/main/java/com/ZalfyPutraRezkyJSleepRJ/json/account.json";
            JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filePath);
            tableAccount.add(new Account("name", "email", "password"));
            JsonTable.writeJson(tableAccount, filePath);
            tableAccount.forEach(account -> System.out.println(account));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        */
    }
    public static Room createRoom(){
        Price price = new Price (100000, 5);
        Room room = new Room(1, "Hotel", 30, price, Facility.AC, City.JAKARTA, "Jl. Margonda Raya");
        return room;
    }
    public static List<Room> filterByPrice(List<Room> list, double minPrice, double maxPrice){
        return Algorithm.<Room>collect(list,room -> room.price.price >= minPrice && room.price.price <= maxPrice);
    }
    public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize){
        return Algorithm.<Room>paginate(list,page,pageSize,room -> room.accountId == accountId);
    }
    public static List<Room> filterByCity(List<Room> list, int accountId, int page, int pageSize){
        return Algorithm.paginate(list, page, pageSize, i -> i.accountId == accountId);
    }
}