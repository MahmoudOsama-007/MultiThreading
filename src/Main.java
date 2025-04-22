import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(2,4,1, TimeUnit.MINUTES,new ArrayBlockingQueue<>(2),
                new MyThreadFactory(),new CustomRejectedExecutionHandler());
        poolExecutor.allowCoreThreadTimeOut(true);
        for (int i = 1; i <= 12; i++) {
            poolExecutor.submit(()->{
                try {
                    Thread.sleep(50);
                    System.out.println("Task Done by: "+Thread.currentThread().getName());
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            });
        }
        poolExecutor.shutdown();
    }

}
class MyThreadFactory implements ThreadFactory {
    private int count = 1;
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r,"Thread-"+count++);
    }
}
class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        //logging
        System.out.println("Task denied "+r.toString());
    }
}