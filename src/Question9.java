import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Task9 implements Runnable {
    private String name;

    public Task9(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void run() {
        try {
            Long duration = (long) (Math.random() * 10);
            System.out.println("Executing : " + name);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



public class Question9 {
    public static void main(String[] args)
    {
        ExecutorService fixedService= Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 5; i++)
        {
            Task9 task = new Task9("Task of fixedThread " + i);
            System.out.println("Created of fixedThread: " + task.getName());

            fixedService.execute(task);
        }
        fixedService.shutdown();

        ExecutorService catchedService = Executors.newCachedThreadPool();
        for (int i = 1; i <= 5; i++)
        {
            Task9 task = new Task9("Task of catchedThread" + i);
            System.out.println("Created of catchedThread : " + task.getName());

            catchedService.execute(task);
        }
        catchedService.shutdown();
    }
}