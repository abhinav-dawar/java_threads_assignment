import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class WorkerThread implements Runnable{
    private int id;
    WorkerThread(int id){
        this.id=id;
    }
    @Override
    public void run() {
        System.out.println( "Starting of Number " + id + " Current time : "
                + Calendar.getInstance().get(Calendar.SECOND));



    }
}

public class Question8{

    public static void main(String[] args) throws InterruptedException {
// creating a ScheduledExecutorService object

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        WorkerThread workerThread= new WorkerThread(7);

// Scheduling the tasks
        for (int i = 0; i < 5; i++) {
            scheduledExecutorService.schedule(new WorkerThread(i), i + 10,
                    TimeUnit.SECONDS);
        }
        for (int i = 6; i < 10; i++) {
            Thread.sleep(1000);

// schedule task to execute at fixed rate
            scheduledExecutorService.scheduleAtFixedRate( new WorkerThread(i), 0, 10,
                    TimeUnit.SECONDS);
        }

        for (int i = 20; i < 30; i++) {
            Thread.sleep(1000);
            scheduledExecutorService.scheduleWithFixedDelay(workerThread, 0, 1,
                    TimeUnit.SECONDS);
        }

//add some delay to let some threads spawn by scheduler
        Thread.sleep(30000);
        scheduledExecutorService.shutdown();
        while(!scheduledExecutorService.isTerminated()){
//wait for all tasks to finish
        }
        System.out.println("Finished all threads");
    }
}