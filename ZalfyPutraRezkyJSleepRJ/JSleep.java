package ZalfyPutraRezkyJSleepRJ;

public class JSleep{
    public static void main(String[] args){
        Room run = createRoom();
        System.out.println(run.name);
        System.out.println(run.size);
        System.out.println(run.price.price);
        System.out.println(run.facility);
    }
    /*
    public static int getHotelId(){
        return 0;
    }
    public static String getHotelName(){
        return "hotel";
    }
    public static boolean isDiscount(){
        return true;
    }
    public static float getDiscountPercentage(int beforeDiscount, float afterDiscount){
        if(afterDiscount < beforeDiscount)
            return (((beforeDiscount - afterDiscount) / beforeDiscount) * 100);
        else
            return 0;
    }
    public static int getDiscountedPrice(int price, float discountPercentage){
        if(discountPercentage > 100){
            return 0;
        }
        return (((100 - (int) discountPercentage) / 100) * price);
    }
    public static int getOriginalPrice(int discountedPrice, float discountPercentage){
        return (discountedPrice * (100 / (100 - (int) discountPercentage)));
    }
    public static float getAdminFeePercentage(){
        return 0.05f;
    }
    public static int getAdminFee(int price){
        return (int)(price * getAdminFeePercentage());
    }
    public static int getTotalPrice(int price, int numberOfNight){
        int total = price * numberOfNight;
        return (total + getAdminFee(total));
    }
    */
    public static Room createRoom(){
        Price price = new Price(100000,5);
        Room room = new Room("hotel", 30, price, Facility.AC);
        return room;
    }
}
