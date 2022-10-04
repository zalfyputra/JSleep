package ZalfyPutraRezkyJSleepRJ;

public class Room extends Serializable implements FileParser
{
    public int size;
    public String name;
    public Facility facility;
    public Price price;
    public BedType bedType;
    public City city;
    
    public Room(int id, String name, int size, Price price, Facility facility, City city, String address){
        super(id);
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.bedType = BedType.SINGLE;
        this.city = city;
    }
    public String toString(){
        return "id = " + this.id + "\n" + "name = " + this.name + "\n" + "size = " + this.size + "\n" + this.price + "\n" +
        "facility = " + this.facility + "\n" + "bedType = " + this.bedType + "\n" + "city = " + this.city;
    }
    public Object write(){
        return null;
    }
    public boolean read(String arr){
        return false;
    }
}
