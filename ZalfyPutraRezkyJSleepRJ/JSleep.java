package ZalfyPutraRezkyJSleepRJ;

public class JSleep{
    public void main(String[] args){

    }
    public int getHotelId(){
        return 0;
    }
    public String getHotelName(){
        return "hotel";
    }
    public boolean isDiscount(){
        return true;
    }
    public float getDiscountPercentage(int beforeDiscount, float afterDiscount){
        if(afterDiscount < beforeDiscount)
            return (((beforeDiscount - afterDiscount) / beforeDiscount) * 100);
        else
            return 0;
    }
    public int getDiscountedPrice(int price, float discountPercentage){
        if(discountPercentage > 100){
            return 0;
        }
        return (((100 - (int) discountPercentage) / 100) * price);
    }
    public int getOriginalPrice(int discountedPrice, float discountPercentage){
        return (discountedPrice * (100 / (100 - (int) discountPercentage)));
    }
    public float getAdminFeePercentage(){
        return 0.05f;
    }
    public int getAdminFee(int price){
        return price * (int) getAdminFeePercentage();
    }
    public int getTotalPrice(int price, int numberOfNight){
        int total = numberOfNight * price;
        return (total + (total + (int) getAdminFeePercentage()));
    }
   
}
