package ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable;
    ReentrantLock lock ;
    public SharedResource() {
        isAvailable=false;
        this.lock=new ReentrantLock();
    }
    public void producer(){
        try {
            lock.lock();
            System.out.println("Lock acquired by " + Thread.currentThread().getName());
            isAvailable=true;
            Thread.sleep(4000);
            System.out.println("Wake up "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        finally {
            lock.unlock();
            System.out.println("Lock Released by " + Thread.currentThread().getName());
        }
    }
}
