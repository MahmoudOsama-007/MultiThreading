package StampedLock.OptimisticLocking;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread writeThread = new Thread(sharedResource::writeLock,"WriteThread");
        Thread readThread = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                sharedResource.readLock();
            }
        },"ReadThread");
        Thread readThread1 = new Thread(()->{

                sharedResource.readLock();

        },"ReadThread###");
        writeThread.start();
        readThread.start();
        readThread1.start();


    }
}
