package com.ZalfyPutraRezkyJSleepRJ;

import com.ZalfyPutraRezkyJSleepRJ.dbjson.Serializable;

import java.util.ArrayList;
import java.util.Date;
/**
 * Class Room digunakan untuk membuat objek room
 *
 * @author (Zalfy)
 * @version (14-11-2022)
 */
public class Room extends Serializable
{
    public int size;
    public int accountId;
    public String name;
    public String address;
    public Facility facility;
    public Price price;
    public BedType bedType;
    public City city;
    public ArrayList <Date> booked = new ArrayList <Date>();
    
    public Room(int accountId, String name, int size, Price price, Facility facility, City city, String address){
        this.accountId = accountId;
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
        bedType = BedType.SINGLE;
    }
    public String toString(){
        return "id = " + this.id + "\n" + "name = " + this.name + "\n" + "size = " + this.size + "\n" + this.price + "\n" +
        "facility = " + this.facility + "\n" + "bedType = " + this.bedType + "\n" + "city = " + this.city;
    }
    public Object write(){
        return null;
    }
    public boolean read(String arr){
        return false;
    }
}