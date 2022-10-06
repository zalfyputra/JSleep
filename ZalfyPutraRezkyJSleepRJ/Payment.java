package ZalfyPutraRezkyJSleepRJ;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Payment extends Invoice
{
    public Date to;
    public Date from;
    private int roomId;
    
    public Payment(int id, int buyerId, int renterId, int roomId, Date from, Date to){
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }
    public Payment(int id, Account buyer, Renter renter, int roomId, Date from, Date to){
        super(id, buyer, renter);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
    }
    public static boolean availability(Date from, Date to, Room room){
        if(to.before(from))
            return false;
        if(room.booked.isEmpty())
            return true;
        for(Date i : room.booked){
            if(i.after(from) && i.before(to) || i.equals(from))
                return false;
        }
        return true;
    }
    public static boolean makeBooking(Date from, Date to, Room room){
        SimpleDateFormat sdfrm = new SimpleDateFormat("dd MMMM yyyy");
        String strfrom = sdfrm.format(from.getTime());
        String strto = sdfrm.format(to.getTime());
        Calendar c = Calendar.getInstance();
        
        if(availability(from, to, room)){
            while(from.before(to)){
                room.booked.add(from);
                c.setTime(from);
                c.add(Calendar.DATE, 1);
                from = c.getTime();
            }
            return true;
        }
        else
            return false;
    }
    public String print(){
        return "Room ID: " + this.roomId + "\n"
             + "Payment from: " + this.from + "\n"
             + "Payment to: " + this.to;
    }
    public int getRoomId(){
        return roomId;
    }
    public String getTime(){
        SimpleDateFormat sdfrm = new SimpleDateFormat("dd MMMM yyyy");
        String strfrom = sdfrm.format(from.getTime());
        return "Formatted Date: " + strfrom;
    }
    /*
    public String getDuration(){
        SimpleDateFormat sdfrm = new SimpleDateFormat("dd MMMM yyyy");
        String strfrom = sdfrm.format(this.from.getTime());
        String strto = sdfrm.format(this.to.getTime());
        return strfrom + " - " + strto;
    }
    */
}
