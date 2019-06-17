package thread;

class DeadLock implements Runnable {
    private Boolean flag;

    DeadLock(Boolean flag) {
        this.flag = flag;
    }

    public void show() {

        if (flag) {
            synchronized (MyLock.lockA) {
                System.out.println("if-------A");
                synchronized (MyLock.lockB) {
                    System.out.println("if-------B");
                }
            }
        } else {
            synchronized (MyLock.lockB) {
                System.out.println("else-------B");
                synchronized (MyLock.lockA) {
                    System.out.println("else-------A");
                }
            }

        }
    }

    public void run() {
        show();
    }

}

class MyLock {
    static final Object lockA = new Object();
    static final Object lockB = new Object();
}

public class DeadLockDemo {
    public static void main(String[] args) {
        DeadLock d1 = new DeadLock(false);
        DeadLock d2 = new DeadLock(true);
        new Thread(d1).start();
        new Thread(d2).start();
    }
}