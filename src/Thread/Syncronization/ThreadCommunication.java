package Thread.Syncronization;

class SharedResource{
    private int data;
    private boolean hasData;

    public synchronized void produce(int val){
        while (hasData){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = val;
        hasData = true;
        System.out.println("Produce : " +val);
        notify();
    }
    public synchronized int consume(){
        while (!hasData){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("Consumed: "+data);
        notify();
        return  data;
    }
}

class Producer implements Runnable{
    private SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i<10; i++){
            sharedResource.produce(i);
        }
    }
}


class Consumer implements Runnable{
    private SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i<10; i++){
            sharedResource.consume();
        }
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {

        SharedResource resource = new SharedResource();
        Thread producerThread = new Thread(new Producer(resource));
        Thread consumerThread = new Thread(new Consumer(resource));

        producerThread.start();
        consumerThread.start();

    }
}
