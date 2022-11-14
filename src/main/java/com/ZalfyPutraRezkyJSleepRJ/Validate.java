package com.ZalfyPutraRezkyJSleepRJ;

import java.util.ArrayList;
/**
 * Class to filter the price
 *
 * @author (Zalfy)
 * @version (14-11-2022)
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
