package StampedLock.OptimisticLocking;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    int a = 10;
    StampedLock lock = new StampedLock();
    public void readLock() {
        long stamp = lock.tryOptimisticRead();
        try {
            System.out.println("Optimistic Lock by "+Thread.currentThread().getName());
            a+=1;
            Thread.sleep(500);
            if(lock.validate(stamp)){
                System.out.println(Thread.currentThread().getName() + " Updated a value successfully");
            }
            else {
                System.out.println("Rollback by: "+Thread.currentThread().getName());
                a=10;
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
    public void writeLock() {
        long stamp = lock.writeLock();
        System.out.println(Thread.currentThread().getName() + " Acquired Lock");
        try{
            System.out.println("Writing ...");
            Thread.sleep(100);
            a=9;
        }catch(Exception e){
            System.out.println(e);
        }
        finally {
            lock.unlockWrite(stamp);
            System.out.println("Released Write Lock");
        }
    }
}
