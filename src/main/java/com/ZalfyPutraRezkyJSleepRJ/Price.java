package com.ZalfyPutraRezkyJSleepRJ;

public class Price{
    public double price;
    public double discount;
    public double rebate;
    
    /*
    public Price(double price){
        
    }
    public Price(double price,double discount){
        
    }
    */
    public String toString(){
        return "price = " + this.price + "\n" + "discount = " + this.discount;
    }
    
    public Price(double price){
        this.price = price;
        this.discount = 0;
        this.rebate = 0;
    }
    public Price(double price, int discount){
        this.price = price;
        this.discount = discount;
        this.rebate = 0;
    }
    public Price(double price, double rebate){
        this.price = price;
        this.rebate = rebate;
        this.discount = 0;
    }
    private double getDiscountedPrice(){
        if(this.discount >= 100.0f)
            return 0.0f;
        else
            return this.price * (100 - discount/100);
    }
    private double getRebatedPrice(){
        if(this.rebate > this.price)
            return this.price;
        else
            return this.price - this.rebate;
    }
}
