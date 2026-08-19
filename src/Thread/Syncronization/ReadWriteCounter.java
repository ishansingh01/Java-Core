package Thread.Syncronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {

    private  int count = 0;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock read = lock.readLock();
    private final Lock write = lock.writeLock();

    public void increment(){
        write.lock();
        try {
            count++;
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            write.unlock();
        }
    }

    public int getCount(){
        read.lock();//multiple thread can acquire readlock if only if write lock can not acquire by any thread
        try {
            return count;
        }finally {
            read.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {


        ReadWriteCounter readWriteCounter = new ReadWriteCounter();
        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<10; i++){
                    System.out.println(Thread.currentThread().getName() + " read:" + readWriteCounter.getCount());
                }
            }
        };
        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<10; i++){
                    readWriteCounter.increment();
                    System.out.println(Thread.currentThread().getName() + " increment");
                }
            }
        };

        Thread writeThread = new Thread(writeTask, "Write Thread");
        Thread readThread = new Thread(readTask, "Read1 Thread");
        Thread readThread1 = new Thread(readThread, "Read2 Thread");

        writeThread.start();
        readThread.start();
        readThread1.start();

        writeThread.join();
        readThread.join();
        readThread1.join();

        System.out.println(readWriteCounter.getCount());

    }
}
