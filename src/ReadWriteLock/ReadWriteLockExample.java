package ReadWriteLock;

import java.util.*;
import java.util.concurrent.locks.*;

public class ReadWriteLockExample {
    private final List<String> data = new ArrayList<>();
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    public void write(String value) {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " writing: " + value);
            data.add(value);
            Thread.sleep(500); // Simulate write delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " Released lock");
            writeLock.unlock();
        }
    }

    public void read() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " reading: " + data);
            Thread.sleep(50); // Simulate read delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            readLock.unlock();
        }
    }


}
