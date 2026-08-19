package Thread.Syncronization;



class Pen {

    public synchronized void writeWithPenAndPaper(Paper paper){
        System.out.println(Thread.currentThread().getName()+" is using pen "+ this + " and trying to write"+ this);
        paper.finishWriting();
    }

    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName()+" finishing using pen "+ this);
    }
}
class Paper{

    public synchronized void writeWithPaperAndPen(Pen pen){
        System.out.println(Thread.currentThread().getName()+" is using paper "+ this + " and trying to write"+this);
        pen.finishWriting();
    }

    public synchronized void finishWriting(){
        System.out.println(Thread.currentThread().getName()+" finishing using paper "+ this);
    }
}

class Task1 implements Runnable{
    Paper paper;
    Pen pen;


    public Task1(Paper paper, Pen pen) {
        this.paper = paper;
        this.pen = pen;
    }

    @Override
    public void run() {
        pen.writeWithPenAndPaper(paper);
    }
}

class Task2 implements Runnable{
    Paper paper;
    Pen pen;


    public Task2(Paper paper, Pen pen) {
        this.paper = paper;
        this.pen = pen;
    }

    @Override
    public void run() {
//        paper.writeWithPaperAndPen(pen); deadlock
        synchronized (pen){
            paper.writeWithPaperAndPen(pen);//ab deadlock ht gya h ye tb hi call hoga jb pen unlock hoga
        }

    }
}

public class DeadLock {
    public static void main(String[] args) {

        Pen pen = new Pen();
        Paper paper = new Paper();
        Thread thread1 = new Thread(new Task1(paper, pen), "Thread1");
        Thread thread2 = new Thread(new Task2(paper, pen), "Thread2");
        thread2.start();
        thread1.start();
    }
}
