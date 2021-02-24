class Table {

    synchronized void printTable(int number) {
        for (int i = 0; i < 5; i++) {
            System.out.println(number * i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread1 extends Thread {
    Table table1;

    Thread1(Table table1) {
        this.table1 = table1;
    }

    @Override
    public void run() {
        table1.printTable(1);
    }
}

class Thread2 extends Thread {
    Table table2;

    Thread2(Table table2) {
        this.table2 = table2;
    }

    @Override
    public void run() {
        table2.printTable(20);
    }
}


public class Question10 {

    public static void main(String[] args) throws InterruptedException {
        Table table = new Table();
        Thread1 thread11 = new Thread1(table);
        Thread2 thread22 = new Thread2(table);
        System.out.println("Thread1 is starting");
        thread11.start();
        Thread.sleep(500);
        System.out.println("Thread2 is starting");
        thread22.start();
    }
}