import java.util.Scanner;

class Processor5 {
    public void produce() throws InterruptedException{
        synchronized (this){
            System.out.println("Producer thread is running...");
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
            notify();
        }
    }
}
public class Question13 {
    public static void main(String[] args) throws InterruptedException {
        final Processor5 processor5 = new Processor5();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    processor5.produce();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    processor5.consume();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
