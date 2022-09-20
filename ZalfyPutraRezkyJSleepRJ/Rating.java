package ZalfyPutraRezkyJSleepRJ;

public class Rating
{
    private long total;
    private long count;
    
    public Rating(){
        this.total = 0;
        this.count = 0;
    }
    public void insert(int rating){
        this.total += rating;
        this.count++;
    }
    public long getCount(){
        return this.count;
    }
    public long getTotal(){
        return this.total;
    }
    public double getAverage(){
        if(this.count <= 0)
            return this.total;
        else
            return this.total/this.count;
    }
}
