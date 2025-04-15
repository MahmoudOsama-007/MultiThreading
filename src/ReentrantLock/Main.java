package ReentrantLock;
import java.util.concurrent.locks.ReentrantLock;
public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        ReentrantLock lock=new ReentrantLock();
        //lambda Expression
        Thread t1=new Thread(()->{
            sharedResource.producer(lock);
        });
        //Method Reference
        Thread t2=new Thread(()->{
            sharedResource.producer(lock);
        });

        t1.start();
        t2.start();
    }
}
