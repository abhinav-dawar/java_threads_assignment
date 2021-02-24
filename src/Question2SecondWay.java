public class Question2SecondWay {
    private int count = 0;

    public static void main(String[] args) {
        Question2SecondWay app = new Question2SecondWay();
        app.doWork();
    }

    public synchronized void increment(){
        count++;
    }

    public void doWork(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++){
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10000;i++){
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Value of count is: " + count);
    }
}
