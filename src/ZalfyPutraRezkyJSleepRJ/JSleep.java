package ZalfyPutraRezkyJSleepRJ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;
import com.google.gson.*;

public class JSleep
{
    /*
    class Country{
        public String name;
        public int population;
        public List<String> listOfStates;
    }
    */
    public static void main(String[] args){
        Gson gson = new Gson();
        try {
            String filepath = "C:\\KULIAH\\SEMESTER 3\\OOP\\PRAKTIKUM\\JSleep\\src\\json\\randomList.json";
            JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
            List<Room> filterTableRoom = filterByCity(tableRoom, "medan", 0, 5);
            filterTableRoom.forEach(room -> System.out.println(room.toString()));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Renter testRegex = new Renter("Netlab_", "081234567890", "Jl Margonda Raya");
        Renter testRegexFail = new Renter("netlab", "081", "Jalan");
        System.out.println(testRegex.validate());
        System.out.println(testRegexFail.validate());
    }
    public static Room createRoom() {
        Price price = new Price (100000, 5);
        Room room = new Room(1, "Hotel", 30, price, Facility.AC, City.JAKARTA, "Jl. Margonda Raya");
        return room;
    }
    public static List<Room> filterByCity(List<Room> list, String search, int page, int pageSize){
        return Algorithm.<Room>paginate(list, page, pageSize, i -> i.city == City.valueOf(search.toUpperCase()));
    }
    public static List<Room> filterByPrice(List<Room> list, double minPrice, double maxPrice){
        return Algorithm.<Room>collect(list, i -> (i.price.price <= maxPrice) && (i.price.price >= minPrice));
    }
    public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize){
        return Algorithm.<Room>paginate(list, page, pageSize, i -> i.accountId == accountId);
    }
}