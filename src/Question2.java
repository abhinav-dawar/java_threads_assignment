public class Question2 extends Thread {
    public void run(){
        for(int i=1;i<4;i++){
            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args){
        Question2 t1 = new Question2();
        Question2 t2 = new Question2();
        Question2 t3 = new Question2();

        t1.start();
        try{
            t1.join();
        }catch (Exception e){
            System.out.println(e);
        }

        t2.start();
        t3.start();
    }
}
