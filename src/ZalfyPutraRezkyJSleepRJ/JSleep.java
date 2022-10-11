package ZalfyPutraRezkyJSleepRJ;

import java.util.ArrayList;
public class JSleep
{
    public static void main(String[] args) {
        ArrayList<Room> RoomSerialized = new ArrayList<Room>();
        for (int i = 0; i < 5; i++) {
            RoomSerialized(i, JSleep.createRoom());
            System.out.println(RoomSerialized.get(i).toString());
        }
    }

    private static void RoomSerialized(int i, Room room) {
    }

    public static Room createRoom(){
        Price price = new Price(100000,0.5);
        Room room = new Room("Hotel", 30, price, Facility.AC, City.DEPOK, "Jalan Margonda Raya");
        return room;
    }
}
