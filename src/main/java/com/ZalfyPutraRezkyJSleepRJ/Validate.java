package com.ZalfyPutraRezkyJSleepRJ;

import java.util.ArrayList;
/**
 * Constructor for objects of class Validate
 * @author Zalfy Putra Rezky
 */
public class Validate
{
    public static ArrayList filter(Price[] list, int value, boolean less)
    {
        ArrayList <Double> result = new ArrayList<Double>();
        if(less){
            for(Price i : list){
                if(i.price <= value){
                    result.add(i.price);
                }
            }
        }else{
            for(Price i : list){
                if(i.price > value){
                    result.add(i.price);
                }
            }
        }
        return result;
    }
}
