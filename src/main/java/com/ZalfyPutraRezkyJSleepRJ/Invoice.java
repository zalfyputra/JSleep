package com.ZalfyPutraRezkyJSleepRJ;

import com.ZalfyPutraRezkyJSleepRJ.dbjson.Serializable;

/**
 * Invoice object stores invoice / transaction details
 * @author Zalfy Putra Rezky
 */
public class Invoice extends Serializable
{
    public PaymentStatus status = PaymentStatus.WAITING;
    public RoomRating rating = RoomRating.NONE;
    public int buyerId;
    public int renterId;
    
    public enum RoomRating{
        NONE, BAD, NEUTRAL, GOOD
    }
    public enum PaymentStatus{
        FAILED, WAITING, SUCCESS
    }
    protected Invoice(int buyerId, int renterId){
        this.buyerId = buyerId;
        this.renterId = renterId;
    }
    public Invoice(Account buyer, Renter renter){
        this.buyerId = buyer.id;
        this.renterId = renter.id;
    }
    public String print(){
        return "Buyer ID: " + this.buyerId + "\n"
             + "Renter ID: " + this.renterId + "\n";
    }
}
