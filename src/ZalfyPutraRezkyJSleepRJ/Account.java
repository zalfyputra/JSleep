package ZalfyPutraRezkyJSleepRJ;

public class Account extends Serializable implements FileParser
{
    public String name;
    public String email;
    public String password;
    
    public Account(int id, String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public String toString(){
        return "name = " + this.name + "\n" + "email = " + this.email + "\n" + "password = " + this.password;
    }
    public Object write(){
        return null;
    }
    public boolean read(String arr){
        return false;
    }
}
