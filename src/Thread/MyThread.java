package Thread;

public class MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
//        for (int i = 0; i<5; i++){
//            String a = "";
//            for (int j = 0; j<10000; j++){
//                a+="a";
//            }
//            System.out.println(Thread.currentThread().getName()+" -Priority: "+ Thread.currentThread().getPriority()+" count-"+i);
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//
//            }
//        }
        //interrupted
//        try {
//            Thread.sleep(1000);
//            System.out.println("Thread is running");
//        } catch (InterruptedException e) {
//            System.out.println(e+"Interrupted occur");
//        }

//        for (int i = 0; i< 5; i++){
//            System.out.println(Thread.currentThread().getName()+" Thread is running");
//            Thread.yield();
//        }

        while (true){
            System.out.println("Hello world");
        }
    }


    public static void main(String[] args) throws InterruptedException {
//        MyThread l = new MyThread("Low Priortry Thread");
//        MyThread m = new MyThread("Medium Priortry Thread");
//        MyThread h = new MyThread("High Priortry Thread");
//        l.setPriority(Thread.MIN_PRIORITY);
//        m.setPriority(Thread.NORM_PRIORITY);
//        h.setPriority(Thread.MAX_PRIORITY);
//        l.start();
//        m.start();
//        h.start();
//        System.out.println(thread.getState());
//        thread.start();
//        System.out.println(thread.getState());
////        System.out.println(Thread.currentThread().getName());
//        Thread.sleep(100);
//        System.out.println(thread.getState());
//        thread.join();
//        System.out.println(thread.getState());

        MyThread thread = new MyThread("T1");
//        MyThread thread2 = new MyThread("T2");
        thread.setDaemon(true);
        thread.start();
//        thread2.start();
        System.out.println("Main done.");
//        thread.interrupt();
    }
}
