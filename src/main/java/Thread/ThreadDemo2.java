package Thread;

class SaleTickets implements Runnable {
    private int tickets = 100;
    Object obj = new Object();

    public void show() {
        while (true) {

            synchronized (obj) {
                if (tickets > 0) {

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "......" + tickets--);
                }

            }
        }
    }

    public void run() {
        show();
    }

}

public class ThreadDemo2 {
    public static void main(String[] args) {
        SaleTickets st = new SaleTickets();
        Thread t1 = new Thread(st);
        Thread t2 = new Thread(st);
        Thread t3 = new Thread(st);
        Thread t4 = new Thread(st);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}