class Table1{

    void printTable(int number){
        synchronized (this){
            for(int i = 0;i< 5;i++){
                System.out.println( number * i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }}
    }
}

class MyThread1 extends Thread{
    Table1 table3;
    MyThread1(Table1 table3){
        this.table3 =table3;
    }

    @Override
    public void run() {
        table3.printTable(1);
    }
}
class MyThread2 extends Thread{
    Table1 table4;
    MyThread2(Table1 table4){
        this.table4=table4;
    }

    @Override
    public void run() {
        table4.printTable(20);
    }
}


public class Question11{

    public static void main(String[] args) throws InterruptedException {
        Table1 table11 =new Table1();
        MyThread1 myThread1 = new MyThread1(table11);
        MyThread2 myThread2 = new MyThread2(table11);
        System.out.println("Thread1 is starting");
        myThread1.start();
        Thread.sleep(500);
        System.out.println("Thread2 is starting" );
        myThread2.start();
    }
}