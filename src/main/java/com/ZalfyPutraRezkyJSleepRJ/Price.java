package com.ZalfyPutraRezkyJSleepRJ;

/**
 * Class price to store price details
 * @author Zalfy Putra Rezky
 */

public class Price{
    public double price;
    public double discount;

    public String toString(){
        return "price = " + this.price + "\n" + "discount = " + this.discount;
    }
    
    public Price(double price){
        this.price = price;
        this.discount = 0;
    }

    public Price(double price, double discount){
        this.price = price;
        this.discount = discount;
    }
}
