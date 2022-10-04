package ZalfyPutraRezkyJSleepRJ;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Payment extends Invoice
{
    public Calendar to;
    public Calendar from;
    private int roomId;
    
    public Payment(int id, int buyerId, int renterId, int roomId){
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
    }
    public Payment(int id, Account buyer, Renter renter, int roomId){
        super(id, buyer, renter);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        this.to.add(Calendar.DATE, 2);
    }
    public String print(){
        return "roomId = " + this.roomId + "\n" + "from = " + this.from + "\n" + "to = " + this.to;
    }
    public int getRoomId(){
        return roomId;
    }
    public String getTime(){
        SimpleDateFormat sdfrm = new SimpleDateFormat("dd MMMM yyyy");
        String strfrom = sdfrm.format(this.from.getTime());
        return "Formatted Date: " + strfrom;
    }
    public String getDuration(){
        SimpleDateFormat sdfrm = new SimpleDateFormat("dd MMMM yyyy");
        String strfrom = sdfrm.format(this.from.getTime());
        String strto = sdfrm.format(this.to.getTime());
        return strfrom + " - " + strto;
    }
}
