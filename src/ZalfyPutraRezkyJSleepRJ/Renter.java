package ZalfyPutraRezkyJSleepRJ;

public class Renter extends Serializable
{
    public int phoneNumber = 0;
    public String address = "";
    public String username;
    
    public Renter(int id, String username){
        this.username = username;
    }
    public Renter(int id, String username, String address){
        this.username = username;
        this.address = address;
    }
    public Renter(int id, String username, int phoneNumber){
        this.username = username;
        this.phoneNumber = phoneNumber;
    }
    public Renter(int id, String username, int phoneNumber, String address){
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
