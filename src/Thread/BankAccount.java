package Thread;

public class BankAccount {
    private int balance = 100;

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" Attempting to withdraw "+amount);
        if (balance>=amount){
            System.out.println(Thread.currentThread().getName()+" proceeding with withdrawal");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            balance-=amount;
            System.out.println(Thread.currentThread().getName()+" completed withdrawal. Remaining balance is : ₹"+balance);
        }else {
            System.out.println(Thread.currentThread().getName()+" insufficent balance.");
        }
    }
}
