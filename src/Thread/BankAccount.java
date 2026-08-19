package Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;

    private final Lock lock = new ReentrantLock();

//    public synchronized void withdraw(int amount){ ye tb use krenge jb lock na use ho sirf lock.lock() syncronized jaisa hi h
        public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" Attempting to withdraw "+amount);
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                if (balance>=amount){
                    try {
                        System.out.println(Thread.currentThread().getName()+" proceeding with withdrawal");
                        Thread.sleep(3000);//time to take withdrawal
                        balance-=amount;
                        System.out.println(Thread.currentThread().getName()+" completed withdrawal. Remaining balance is : ₹"+balance);
                    } catch (Exception e) {
                        Thread.currentThread().interrupt();
                    }finally {
                        lock.unlock();
                    }
                }else {
                    System.out.println(Thread.currentThread().getName()+" insufficient balance.");
                }
            }
            else {
                System.out.println(Thread.currentThread().getName()+" We could not acquire the lock, will try later.");}
            }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
