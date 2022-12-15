package com.ZalfyPutraRezkyJSleepRJ;

import com.ZalfyPutraRezkyJSleepRJ.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Account object is an object to store account of JSleep users
 * @author Zalfy Putra Rezky
 */
public class Account extends Serializable
{
    public String name;
    public String email;
    public String password;
    public double balance;
    public Renter renter;
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9 ][a-zA-Z0-9]+@[a-zA-Z.]+?\\.[a-zA-Z]+?$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    public Account(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = 0;
    }

    public String toString(){
        return "Account{ + \nname='" + this.name + "', \nemail='" + this.email + "', \npassword='" + this.password + "', \nid=" + this.id + "}";
    }

    public Object write(){
        return null;
    }

    public Boolean read(String a){
        return true;
    }

    public boolean validate(){
        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(email);
        boolean matchEmail = matcherEmail.find();
        Pattern patternPassword = Pattern.compile(REGEX_PASSWORD);
        Matcher matcherPassword = patternPassword.matcher(password);
        boolean matchPassword = matcherPassword.find();
        return matchEmail && matchPassword;
    }
}
