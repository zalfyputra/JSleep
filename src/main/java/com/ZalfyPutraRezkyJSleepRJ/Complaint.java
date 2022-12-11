package com.ZalfyPutraRezkyJSleepRJ;

import com.ZalfyPutraRezkyJSleepRJ.dbjson.Serializable;

/**
 * An object to store complaint data.
 * It has date and description field.
 * @author Zalfy Putra Rezky
 */
public class Complaint extends Serializable
{
    public String desc;
    public String date;
    
    public Complaint(int id, String date, String desc){
        this.desc = desc;
        this.date = date;
    }
    public String toString(){
        return "desc = " + this.desc + "\n" + "date = " + this.date;
    }
}
