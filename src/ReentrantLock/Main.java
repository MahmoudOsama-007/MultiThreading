package ReentrantLock;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        //lambda Expression
        Thread t1=new Thread(()->{
            sharedResource.producer();
        });
        //Method Reference
        Thread t2=new Thread(sharedResource::producer);

        t1.start();
        t2.start();
    }
}
