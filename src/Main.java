public class Main {
    public static void main(String[] args) {


//        MyRunnable myRunnable = new MyRunnable();
//        Thread thread = new Thread(myRunnable);

        // you can pass direct to Thread by using Anonymous Object
        Thread thread1 = new Thread(new MyRunnable("ahmed") {});
        Thread thread2 = new Thread(new MyRunnable("ali") {});
        Thread thread3 = new Thread(new MyRunnable("mahmoud") {});
        System.out.println("Call Threads Start");
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println("Call Threads End"); // where do you think will it print ?
    }
}
