package com.ZalfyPutraRezkyJSleepRJ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Serializable
{
    public String name;
    public String email;
    public String password;
    final public static String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z]+([.]?[A-Za-z]+)*\\.[A-Za-z]+$";
    final public static String REGEX_PASSWORD = "^(?=.*a-z)(?=.*A-Z)(?=.*0-9)[a-zA-Z0-9]{8,}$";

    public Account(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public boolean validate(){
        Pattern emailName = Pattern.compile(REGEX_EMAIL);
        Pattern passwordName = Pattern.compile(REGEX_PASSWORD);
        if(email == null || password == null){
            return false;
        }
        Matcher emailMatched = emailName.matcher(email);
        Matcher passwordMatched = passwordName.matcher(password);
        return (emailMatched.matches() && passwordMatched.matches());
    }
    public String toString(){
        return "Account{name='" + this.name + "', email='" + this.email + "', password='" + this.password + "', id=" + this.id + "}";
    }
    public Object write(){
        return null;
    }
    public boolean read(String arr){
        return false;
    }
}
