package ZalfyPutraRezkyJSleepRJ;

public class Renter extends Serializable
{
    public String phoneNumber;
    public String address;
    public String username;
    final public static String REGEX_NAME = "^[A-Z][a-zA-Z0-9_]{4,20}$";
    final public static String REGEX_PHONE = "[0-9]{9,12}";
    
    public Renter(String username, String phoneNumber, String address){
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public boolean validate() {
        return this.username.matches(REGEX_NAME) && this.phoneNumber.matches(REGEX_PHONE);
    }
}
