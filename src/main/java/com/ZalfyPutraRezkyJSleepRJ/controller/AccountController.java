package com.ZalfyPutraRezkyJSleepRJ.controller;

import com.ZalfyPutraRezkyJSleepRJ.*;
import com.ZalfyPutraRezkyJSleepRJ.dbjson.JsonAutowired;
import com.ZalfyPutraRezkyJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Controller for Account
 * @author Zalfy Putra Rezky
 */

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    @JsonAutowired(value = Account.class, filepath = "C:\\KULIAH\\SEMESTER 3\\OOP\\PRAKTIKUM\\JSleep\\src\\main\\java\\com\\ZalfyPutraRezkyJSleepRJ\\json\\account.json")
    public static JsonTable<Account> accountTable;
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z]+([.]?[a-zA-Z]+)*\\.[a-zA-Z]+(?!\\s)$";
    public static final String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[a-zA-Z\\d]{8,}(?!\\s)$";
    public final static Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public final static Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

    @GetMapping
    String index(){
        return "Account Controller";
    }

    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    ){
        String hashedPassword = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        final String hashFinal = hashedPassword;
        return Algorithm.<Account>find(accountTable, pred -> pred.email.equals(email) && pred.password.equals(hashFinal));
    }

    @PostMapping("/register")
    Account register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ){
        Matcher emailMatcher = REGEX_PATTERN_EMAIL.matcher(email);
        boolean emailStatus = emailMatcher.find();
        Matcher passwordMatcher = REGEX_PATTERN_PASSWORD.matcher(password);
        boolean passwordStatus = passwordMatcher.find();

        if(passwordStatus && emailStatus && !name.isBlank()){
            String hashedPassword = null;
            try{
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(password.getBytes());
                byte[] bytes = md.digest();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < bytes.length; i++) {
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                }
                hashedPassword = sb.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            final String hashFinal = hashedPassword;
            accountTable.add(new Account(name,email,hashFinal));
            return new Account(name, email, hashFinal);
        }
        else {
            return null;
        }
    }

    @PostMapping("/{id}/registerRenter")
    Renter registerRenter(@PathVariable int id,
                          @RequestParam String username,
                          @RequestParam String address,
                          @RequestParam String phoneNumber
    ){
        Account findAcc = Algorithm.<Account>find(getJsonTable(), obj -> obj.id == id);
        if (findAcc.renter == null) {
            Renter newRenter = new Renter(username, address, phoneNumber);
            findAcc.renter = newRenter;
            return newRenter;
        }
        return null;
    }
    @PostMapping("/{id}/topUp")
    boolean topUp(
            @PathVariable int id,
            @RequestParam double balance
    ){
        Account account = Algorithm.<Account>find(accountTable, acc -> id == acc.id);
        if (account != null){
            account.balance += balance;
            return true;
        }
        return false;
    }

    @GetMapping("/{id}/getById")
    public Account getById(@PathVariable int id){
        return Algorithm.<Account>find(getJsonTable(), pred->pred.id == id);
    }

    @GetMapping("/getAllAccount")
    public List<Account> getAllAccount(){
        return Algorithm.collect(getJsonTable(), (Predicate<Account>) pred -> true);
    }

    @Override
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }
}