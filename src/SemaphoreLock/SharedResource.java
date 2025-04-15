package SemaphoreLock;


import java.util.concurrent.Semaphore;

public class SharedResource {
    boolean isAvailable;
    Semaphore lock = new Semaphore(2);

    public void producer(){
        try{
            lock.acquire();
            System.out.println(Thread.currentThread().getName() + " Acquired Lock");
            isAvailable = true;
            Thread.sleep(4000);
        }
        catch(Exception e){
            System.out.println(e);
        }finally{
            System.out.println(Thread.currentThread().getName() + " Released Lock");
            lock.release();
        }
    }
}
