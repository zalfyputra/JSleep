package ZalfyPutraRezkyJSleepRJ;

public class Invoice extends Serializable
{
    public PaymentStatus status = PaymentStatus.WAITING;
    public RoomRating rating = RoomRating.NONE;
    public int buyerId;
    public int renterId;
    public String time;
    
    public enum RoomRating{
        NONE, BAD, NEUTRAL, GOOD
    }
    public enum PaymentStatus{
        FAILED, WAITING, SUCCESS
    }
    protected Invoice(int id, int buyerId, int renterId, String time){
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = time;
    }
    public Invoice(int id, Account buyer, Renter renter, String time){
        super(id);
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = time;
    }
    public String print(){
        return "buyerId = " + this.buyerId + "\n" + "renterId = " + this.renterId + "\n" + "time = " + this.time + "\n";
    }
}
