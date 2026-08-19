package Thread.Syncronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//DeadLock condition ko htane ke liye ReentrantLock(Deadlock prevention) hai kyuki ye ab innerMethod ko run krega kyuki same thread ne hi lock kiya tha ab who phirse aquire kr lega
public class ReentrantExample {
    private final Lock lock = new ReentrantLock();
    int count=0;
//    jitne lock honge utne hi unlock bhi hone chahiye wrna exception aa jayegi
    public void outerMethod(){
//        lock.lockInterruptibly(); at a given lock is not unlock then interrupted
        lock.lock();
        count++;
        try {
            System.out.println("Outer Method");
            innerMethod();
        }finally {
            lock.unlock();
            System.out.println(count);
        }
    }

    public void innerMethod(){
        lock.lock();
        count++;
        try {
            System.out.println("Inner Method");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        ReentrantExample example = new ReentrantExample();
        example.outerMethod();
    }
}
