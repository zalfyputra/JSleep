package com.ZalfyPutraRezkyJSleepRJ;

/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
