import java.util.Scanner;

class Processor6 {
    public void produce1() throws InterruptedException{
        synchronized (this){
            System.out.println("Producer produce1 thread is running...");
            wait();
            System.out.println("Resumed....");
        }
    }
    public void produce2() throws InterruptedException{
        synchronized (this){
            System.out.println("Producer produce2 thread is running...");
            wait();
            System.out.println("Resumed....");
        }
    }

    public void consume() throws InterruptedException{
        Scanner s = new Scanner(System.in);
        Thread.sleep(2000);

        synchronized (this){
            System.out.println("Waiting for some key...");
            s.nextLine();
            System.out.println("Key is pressed");
            notifyAll();
        }
    }
}
public class Question14 {
    public static void main(String[] args) throws InterruptedException {
        final Processor6 processor6 = new Processor6();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    processor6.produce1();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    processor6.produce2();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    processor6.consume();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t3.start();
        t2.start();

        t1.join();
        t3.join();
        t2.join();
    }
}

