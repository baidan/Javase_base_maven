package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//生产者---消费者示例
public class ProducterComsumerDemoReentrantLockII {
    public static void main(String[] args) {
        Resource_b res = new Resource_b();
        Producter_b t0 = new Producter_b(res);
        Producter_b t1 = new Producter_b(res);
        Comsumer_b t2 = new Comsumer_b(res);
        Comsumer_b t3 = new Comsumer_b(res);
        new Thread(t0).start();
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}

// 访问的资源
class Resource_b {
    private String name;
    private int count = 0;
    private Boolean bo = false;

    private Lock lockA = new ReentrantLock();

    private Condition condiA = lockA.newCondition();
    private Condition condiB = lockA.newCondition();

    public void set(String name) {
        lockA.lock();
        try {
            while (bo)
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
            condiB.signal(); // 唤醒一个消费者

        } finally {
            lockA.unlock();
        }

    }

    public void get() {
        lockA.lock();
        try {
            while (!bo)
                try {
                    condiB.await();// 如果已经消费了面包，等待
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            System.out.println(Thread.currentThread().getName() + "---消费者" + this.name + "-------" + count);// 打印现在消费面包信息
            bo = false; // 标记已经消费了
            condiA.signal(); // 唤醒一个生产者
        } finally {
            lockA.unlock();
        }
    }

}

// 生产者
class Producter_b implements Runnable {
    private Resource_b res;
    private int num = 0;

    Producter_b(Resource_b res) {
        this.res = res;
    }

    public void run() {
        while (num < 10) {
            res.set("面包");
        }
    }
}

// 消费者
class Comsumer_b implements Runnable {
    private Resource_b res;
    private int num = 0;

    Comsumer_b(Resource_b res) {
        this.res = res;
    }

    public void run() {
        while (num < 10) {
            res.get();
        }
    }
}



