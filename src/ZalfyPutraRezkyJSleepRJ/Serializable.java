package ZalfyPutraRezkyJSleepRJ;

import java.util.HashMap;

public class Serializable
{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();
    protected Serializable(){
        Integer temp = mapCounter.get(this.getClass());
        if(temp == null)
            temp = 0;
        else
            temp++;
        this.id = temp;
        System.out.println("ID: " + id);
        mapCounter.put(this.getClass(), temp);
    }
    public int compareTo(Serializable serial){
        Integer serialId = this.id;
        return serialId.compareTo(serial.id);
    }
    public boolean equals(Object obj){
        return obj instanceof Serializable && this.id == mapCounter.get(getClass());
    }

    public boolean equals(Serializable serial) {
        return this.id == serial.id;
    }

    public static <T> Integer getClosingId(Class<T> tClass){
        return mapCounter.get(tClass);
    }

    public static <T> Integer setClosingId(Class<T> tClass, int id){
        return mapCounter.put(tClass, id);
    }
}