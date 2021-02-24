class Runner1 extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hellooo" + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Runner2 implements Runnable {
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Hellooo" + i);
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

public class Question1 {
    public static void main(String[] args) {
        Runner1 run1 = new Runner1();
        run1.start();

        Thread t1 = new Thread(new Runner2());
        t1.start();
    }
}
