package StampedLock.PessimisticLocking;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    boolean isAvailable=false;
    StampedLock lock = new StampedLock();

    public void readLock() {
        long stamp = lock.readLock();
        try {
            System.out.println("Optimistic Lock by "+Thread.currentThread().getName());
            isAvailable=true;
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }finally {
            lock.unlockRead(stamp);
            System.out.println("Unlocked Read Lock by "+Thread.currentThread().getName());
        }
    }
    public void writeLock() {
        long stamp = lock.writeLock();
        System.out.println(Thread.currentThread().getName() + " Acquired Lock");
        try{
            System.out.println("Writing ...");
            Thread.sleep(100);
            isAvailable=false;
        }catch(Exception e){
            System.out.println(e);
        }
        finally {
            lock.unlockWrite(stamp);
            System.out.println("Released Write Lock");
        }
    }
}
