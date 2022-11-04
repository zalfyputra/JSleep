package ZalfyPutraRezkyJSleepRJ;

public class ThreadingObject extends Thread{
    public ThreadingObject(String name){
        super(name);
    }
    public void run(){
        System.out.println("Thread " + this.getName() + " is running");
        System.out.println("Id Thread " + Thread.currentThread().getId());
    }
}
