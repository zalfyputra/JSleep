package com.ZalfyPutraRezkyJSleepRJ;

import com.ZalfyPutraRezkyJSleepRJ.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Store data about Renter (people who rent the room)
 * @author Zalfy Putra Rezky
 */
public class Renter extends Serializable
{
    public String phoneNumber;
    public String address;
    public String name;
    final public static String REGEX_NAME = "^[A-Z][a-zA-Z0-9_]{4,20}$";
    final public static String REGEX_PHONE = "^[0-9]{9,12}$";
    
    public Renter(String name, String address, String phoneNumber){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public boolean validate(){
        Pattern patternPhone = Pattern.compile(REGEX_PHONE);
        Matcher matcherPhone = patternPhone.matcher(phoneNumber);
        boolean matchPhone = matcherPhone.find();
        Pattern patternName = Pattern.compile(REGEX_NAME);
        Matcher matcherName = patternName.matcher(name);
        boolean matchName = matcherName.find();
        return matchName && matchPhone;
    }
}
