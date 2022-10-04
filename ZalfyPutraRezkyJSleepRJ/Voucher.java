package ZalfyPutraRezkyJSleepRJ;

public class Voucher extends Serializable implements FileParser
{
    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;
    
    public Voucher(int id, String name, int code, Type type, boolean used, double minimum, double cut){
        super(id);
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
    }
    /*
    public Voucher(String name, int code, Type type, double minimum, double cut){
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
    }
    */
    public boolean canApply(Price price){
        if(price.price > this.minimum && this.used == false)
            return true;
        else
            return false;
    }
    public double apply(Price price){
        this.used = true;
        if(this.type == Type.DISCOUNT){
            if(this.cut >= 100.0f)
                return 0.0f;
            else
                return price.price * ((100 - this.cut)/100);
        }
        if(this.type == Type.REBATE){
            if(this.cut >= price.price)
                return price.price;
            else
                return price.price - this.cut;
        }
        return 0;
    }
    public boolean isUsed(){
        return this.used;
    }
    public Object write(){
        return null;
    }
    public boolean read(String parse){
        return false;
}