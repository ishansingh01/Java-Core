package Thread.Syncronization;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThread myThread = new MyThread(counter);
        MyThread myThread1 = new MyThread(counter);
        myThread.start();
        myThread1.start();
        try {
            myThread.join();
            myThread1.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(counter.getCount());
    }
}
