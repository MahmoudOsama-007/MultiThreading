import java.security.PrivateKey;

public class MyRunnable implements Runnable {
    private String name;
    public MyRunnable(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);
//                System.out.println(Thread.currentThread().getName() + " " + i);
                System.out.println("From: "+name + " " + i);
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted");
            }

        }
    }
}
