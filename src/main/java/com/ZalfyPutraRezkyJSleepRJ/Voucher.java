package com.ZalfyPutraRezkyJSleepRJ;

import com.ZalfyPutraRezkyJSleepRJ.dbjson.Serializable;
/**
 * Kelas untuk voucher
 * @author (Zalfy)
 * @version (14-11-2022)
 */
public class Voucher extends Serializable
{
    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;

    public Voucher(int id, String name, int code, Type type, boolean used, double minimum, double cut){
        this.name = name;
        this.code = code;
        this.type = type;
        this.used = used;
        this.minimum = minimum;
        this.cut = cut;
    }

    public boolean canApply(Price price){
        if(price.price > this.minimum && this.used == false)
            return true;
        else
            return false;
    }

    public double apply(Price price){
        this.used = true;
        if(this.type == Type.DISCOUNT){
            if(this.cut > 100){
                return 0;
            }else{
                return (100 - this.cut)/100 * price.price;
            }
        }else if(this.type == Type.REBATE){
            if(this.cut > price.price){
                this.cut = price.price;
            }
            return price.price - this.cut;
        }else{
            System.out.println("Type invalid!");
            return 0;
        }
    }

    public boolean isUsed(){
        return this.used;
    }
    public Object write(){
        return null;
    }
    public boolean read(String parse){
        return false;
    }
}