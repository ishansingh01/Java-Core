package Thread.Syncronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairnessLockExample {
//    private final Lock unfairLock = new ReentrantLock();//(arbitrary manner me chlega) ye order me thread ko run nhi kraega aise jaruri nhi jo thread phle wait kiya tha whi phle lock ho
private final Lock fairnessLock = new ReentrantLock(true); //order guaranteed hai pr aise jaruri nhi ki agar thread1.start() phle likha ho toh phle whi jayega lock krne


    public void accessResource(){
        fairnessLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+" Acquire the lock.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }finally {
            System.out.println(Thread.currentThread().getName()+" Release the lock.");
            fairnessLock.unlock();
        }
    }

    public static void main(String[] args) {
        FairnessLockExample example = new FairnessLockExample();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                example.accessResource();
            }
        };
        Thread thread1 = new Thread(runnable,"Thread 1");
        Thread thread2 = new Thread(runnable,"Thread 2");
        Thread thread3 = new Thread(runnable,"Thread 3");
        thread1.start();
        thread2.start();
        thread3.start();
//        agar start bhi order me chahiye toh sleep lga denge

//        for (int i = 0; i<9; i++){
//            Thread thread1 = new Thread(runnable,"Thread 1");
//            Thread thread2 = new Thread(runnable,"Thread 2");
//            Thread thread3 = new Thread(runnable,"Thread 3");
//            try {
//                thread1.start();
//                Thread.sleep(50);
//                thread2.start();
//                Thread.sleep(50);
//                thread3.start();
//                Thread.sleep(50);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }
}
