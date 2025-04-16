package StampedLock.PessimisticLocking;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    boolean isAvailable=false;
    StampedLock lock = new StampedLock();

    public void readLock() {
        long stamp = lock.readLock();
        System.out.println("Read Lock by "+Thread.currentThread().getName());
        try {
            System.out.println("Reading... ");
            isAvailable=true;
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }finally {
            System.out.println("Unlocked Read Lock by "+Thread.currentThread().getName());
            lock.unlockRead(stamp);
        }
    }
    public void writeLock() {
        long stamp = lock.writeLock();
        System.out.println(Thread.currentThread().getName() + " Acquired Lock");
        try{
            System.out.println("Writing ...");
            Thread.sleep(6000);
            isAvailable=false;
        }catch(Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("Released Write Lock");
            lock.unlockWrite(stamp);
        }
    }
}
