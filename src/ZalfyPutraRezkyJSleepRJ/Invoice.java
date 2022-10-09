package ZalfyPutraRezkyJSleepRJ;

import java.util.Date;

public class Invoice extends Serializable
{
    public PaymentStatus status = PaymentStatus.WAITING;
    public RoomRating rating = RoomRating.NONE;
    public int buyerId;
    public int renterId;
    public Date time = new Date();
    
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
        this.time = time;
    }
    public Invoice(int id, Account buyer, Renter renter){
        super(id);
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = time;
    }
    public String print(){
        return "Buyer ID: " + this.buyerId + "\n"
             + "Renter ID: " + this.renterId + "\n"
             + "Time: " + this.time + "\n";
    }
}
