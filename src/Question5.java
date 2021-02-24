import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor3 implements Runnable {
    private int id;

    public Processor3(int id){
        this.id = id;
    }

    public void run(){
        System.out.println("Starting: " + id);

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
        }

        System.out.println("Completed: " + id);
    }
}
public class Question5 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for(int i=0;i<5;i++){
            executor.submit(new Processor3(i));
        }
        executor.shutdownNow();

        System.out.println("Result for isshutdown: " + executor.isShutdown());
        System.out.println("Result for isterminated: " + executor.isTerminated());
    }
}

