package com.ZalfyPutraRezkyJSleepRJ;

import com.ZalfyPutraRezkyJSleepRJ.dbjson.Serializable;

import java.util.ArrayList;
import java.util.Date;
/**
 * Create object of Room
 * @author Zalfy Putra Rezky
 */
public class Room extends Serializable
{
    public int size;
    public int accountId;
    public String name;
    public String address;
    public ArrayList<Facility> facility;
    public Price price;
    public BedType bedType;
    public City city;
    public ArrayList <Date> booked = new ArrayList <Date>();
    
    public Room(int accountId, String name, int size, Price price, ArrayList<Facility> facility, City city, String address, BedType bedType){
        this.accountId = accountId;
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
        this.bedType = bedType;
    }
    public String toString(){
        return "\nName: " + this.name + "\nbedType = " + this.bedType + "\nSize: " + this.size + this.price +
                "\nFacility: " + this.facility + "\nCity: " + this.city + "\nAddress: " + this.address;
    }
    /**
    public Object write(){
        return null;
    }
    public boolean read(String arr){
        return false;
    }
     */
}