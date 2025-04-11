public class Main {
    public static void main(String[] args) {


//        MyRunnable myRunnable = new MyRunnable();
//        Thread thread = new Thread(myRunnable);

        // you can pass direct to Thread by using Anonymous Object
        Thread thread1 = new Thread(new MyRunnable() {});
        Thread thread2 = new Thread(new MyRunnable() {});
        Thread thread3 = new Thread(new MyRunnable() {});
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
