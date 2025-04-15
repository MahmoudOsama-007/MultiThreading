package ReadWriteLock;

public class Main {
    public static void main(String[] args) {
        ReadWriteLockExample example = new ReadWriteLockExample();

        Runnable writer = () -> {
            for (int i = 0; i < 3; i++) {
                example.write("Data-" + i);
            }
        };

        Runnable reader = () -> {
            for (int i = 0; i < 3; i++) {
                example.read();
            }
        };

        Thread writerThread = new Thread(writer, "WriterThread");
        Thread readerThread1 = new Thread(reader, "ReaderThread-1");
        Thread readerThread2 = new Thread(reader, "ReaderThread-2");

        writerThread.start();
        readerThread1.start();
        readerThread2.start();
    }
}
