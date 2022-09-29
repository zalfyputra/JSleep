package ZalfyPutraRezkyJSleepRJ;

public class JSleep{
    public static void main(String[] args){
        Complaint testComplain = new Complaint(1, "23 August 2022", "Bad Quality");
        Price testPrice = new Price(100000, 20000);
        Room testRoom = new Room(1, "Presidential Suite", 5, testPrice, Facility.FitnessCenter, City.DEPOK, "JL. Margonda Raya");
        Account testAccount = new Account(1, "Bob", "bob@gmail.com", "bob");
        Rating testRating = new Rating();
        System.out.println(testComplain.toString());
        System.out.println(testRoom.toString());
        System.out.println(testAccount.toString());
        System.out.println(testPrice.toString());
        System.out.println(testRating.toString());
        /*
        Payment testRoom = new Payment(1, 1, 1, "", 1, "", "");
        Invoice testInvoice = new Invoice(2,2,2, "");
        System.out.println(testRoom.print());
        System.out.println(testInvoice.print());
        */
    }
    /*
    public static void main(String[] args){
        Room run = createRoom();
        System.out.println(run.name);
        System.out.println(run.size);
        System.out.println(run.price.price);
        System.out.println(run.facility);
    }
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
    public static Room createRoom(){
        Price price = new Price(100000,5);
        Room room = new Room("hotel", 30, price, Facility.AC);
        return room;
    }
    */
}
