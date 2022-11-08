package com.ZalfyPutraRezkyJSleepRJ.controller;

import com.ZalfyPutraRezkyJSleepRJ.dbjson.*;
import com.ZalfyPutraRezkyJSleepRJ.dbjson.JsonTable;
import com.ZalfyPutraRezkyJSleepRJ.*;
import org.springframework.web.bind.annotation.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController{
    /*
    @JsonAutowired(filepath = "C:\\KULIAH\\SEMESTER 3\\OOP\\PRAKTIKUM\\JSleep\\src\\main\\java\\com\\ZalfyPutraRezkyJSleepRJ\\json\\account.json", value = Account.class)

    final public static String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z]+([.]?[A-Za-z]+)*\\.[A-Za-z]+$";
    final public static String REGEX_PASSWORD = "^(?=.*a-z)(?=.*A-Z)(?=.*0-9)[a-zA-Z0-9]{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    public static JsonTable<Account> accountTable;

    @GetMapping
    String index() {return "Account Page";}
    public JsonTable<Account> getJsonTable(){
        return accountTable;
    }
    @PostMapping("/login")
    Account login(@RequestParam String email, @RequestParam String password){
        return Algorithm.<Account>find(accountTable, account -> account.email.equals(email));
    }
    @PostMapping("/register")
    Account register(@RequestParam String name, @RequestParam String email, @RequestParam String password){
        Matcher emailMatch = REGEX_PATTERN_EMAIL.matcher(email);
        Matcher passwordMatch = REGEX_PATTERN_PASSWORD.matcher(password);
    }

    @PostMapping("/{id}/registerRenter")
    Renter registerRenter(@PathVariable int id, @RequestParam String username, @RequestParam String address, @RequestParam String phoneNumber){
        return null;
    }

    @PostMapping("/{id}/topUp")
    boolean topUp(@PathVariable int id, @RequestParam double balance){
        return false;
    }
    */
}