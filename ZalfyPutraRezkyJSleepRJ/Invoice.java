package ZalfyPutraRezkyJSleepRJ;

import java.util.Calendar;

public class Invoice extends Serializable
{
    public PaymentStatus status = PaymentStatus.WAITING;
    public RoomRating rating = RoomRating.NONE;
    public int buyerId;
    public int renterId;
    public Calendar time = Calendar.getInstance();
    
    public enum RoomRating{
        NONE, BAD, NEUTRAL, GOOD
    }
    public enum PaymentStatus{
        FAILED, WAITING, SUCCESS
    }
    protected Invoice(int id, int buyerId, int renterId){
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
    }
    public Invoice(int id, Account buyer, Renter renter){
        super(id);
        this.buyerId = buyer. id;
        this.renterId = renter.id;
    }
    public String print(){
        return "buyerId = " + this.buyerId 
                + "\n" + "renterId = " + this.renterId
                + "\n" + "time = " + this.time + "\n";
    }
}
