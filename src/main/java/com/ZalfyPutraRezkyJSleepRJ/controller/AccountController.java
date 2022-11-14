package com.ZalfyPutraRezkyJSleepRJ.controller;

import com.ZalfyPutraRezkyJSleepRJ.Account;
import com.ZalfyPutraRezkyJSleepRJ.Algorithm;
import com.ZalfyPutraRezkyJSleepRJ.Renter;
import com.ZalfyPutraRezkyJSleepRJ.dbjson.JsonAutowired;
import com.ZalfyPutraRezkyJSleepRJ.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    public final static String REGEX_EMAIL = "^[a-zA-Z0-9 ][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";
    public final static String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    @JsonAutowired(value = Account.class, filepath = "src/json/account.json")
    public static JsonTable<Account> accountTable;
    public final static Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public final static Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

    public JsonTable<Account> getJsonTable() {
        return accountTable;
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
        return Algorithm.<Account>find(accountTable, pred -> email.equals(pred.email) && pred.password.equals(hashFinal));
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
    boolean topUp(@PathVariable int id,
                  @RequestParam double balance
    ){
        Account account = Algorithm.<Account>find(accountTable, acc -> id == acc.id);
        if (account != null){
            account.balance += balance;
            return true;
        }else{
            return false;
        }
    }
}