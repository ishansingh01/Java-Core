package Thread.Syncronization;

public class Counter {
    private int count = 0;

//    for method
//    public synchronized void increment(){
//        count++;
//    }


//    for block of code
        public  void increment(){
        synchronized (this){
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
