package Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//生产者---消费者示例
public class ProducterComsumerDemoReentrantLock {
    public static void main(String[] args) {
        Resource res = new Resource();
        Producter t0 = new Producter(res);
        Producter t1 = new Producter(res);
        Comsumer t2 = new Comsumer(res);
        Comsumer t3 = new Comsumer(res);
        new Thread(t0).start();
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}

// 访问的资源
class Resource {
    private String name;
    private int count = 0;
    private Boolean bo = false;

    private Lock lockA = new ReentrantLock();
    // private Lock lockB = new ReentrantLock();

    private Condition condiA = lockA.newCondition();
    // private Condition condiB = lockB.newCondition();

    public void set(String name) {
        try {
            lockA.lock();
            while (true) {
                if (bo)
                    try {
                        condiA.await(); // 如果已经生产了面包，等待
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                this.name = name;
                count++; // 生产一个
                System.out.println(Thread.currentThread().getName() + "---生产者" + this.name + "-------" + count); // 打印现在面包信息
                bo = true; // 标记能消费了
                condiA.signalAll(); // 唤醒所有
            }

        } finally {
            lockA.unlock();
        }

    }

    public void get() {
        try {
            lockA.lock();
            while (true) {
                if (!bo)
                    try {
                        condiA.await();// 如果已经消费了面包，等待
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                System.out.println(Thread.currentThread().getName() + "---消费者" + this.name + "-------" + count);// 打印现在消费面包信息
                bo = false; // 标记已经消费了
                condiA.signalAll();// 唤醒所有
            }
        } finally {
            lockA.unlock();
        }
    }

}

// 生产者
class Producter implements Runnable {
    private Resource res;
    private int num = 0;

    Producter(Resource res) {
        this.res = res;
    }

    public void run() {
        while (num < 10) {
            res.set("面包");
            num++;
        }
    }
}

// 消费者
class Comsumer implements Runnable {
    private Resource res;
    private int num = 0;

    Comsumer(Resource res) {
        this.res = res;
    }

    public void run() {
        while (num < 10) {
            res.get();
            num++;
        }
    }
}
