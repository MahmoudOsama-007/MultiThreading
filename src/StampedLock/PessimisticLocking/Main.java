package StampedLock.PessimisticLocking;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread readThread1 = new Thread(sharedResource::readLock,"read1");
        Thread readThread2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                sharedResource.readLock();
            }
        },"Read2");
        Thread writeThread = new Thread(sharedResource::writeLock,"write1");
        Thread writeThread1 = new Thread(sharedResource::writeLock,"write2");
        writeThread.start();
        readThread2.start();
        readThread1.start();
        writeThread1.start();
        writeThread1.setPriority(1);


    }
}
