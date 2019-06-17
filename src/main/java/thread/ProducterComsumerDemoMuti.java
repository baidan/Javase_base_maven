package thread;

//生产者---消费者示例
public class ProducterComsumerDemoMuti {
    public static void main(String[] args) {
        Resource3 res = new Resource3();
        Producter3 t0 = new Producter3(res);
        Producter3 t1 = new Producter3(res);
        Comsumer3 t2 = new Comsumer3(res);
        Comsumer3 t3 = new Comsumer3(res);
        new Thread(t0).start();
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}

// 访问的资源
class Resource3 {
    private String name;
    private int count = 0;
    private Boolean bo = false;

    public synchronized void set(String name) {
        while (true) {
            if (bo)
                try {
                    this.wait(); // 如果已经生产了面包，等待
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            this.name = name;
            count++; // 生产一个
            System.out.println(Thread.currentThread().getName() + "---生产者" + this.name + "-------" + count); // 打印现在面包信息
            bo = true; // 标记能消费了
            this.notifyAll(); // 唤醒所有
        }
    }

    public synchronized void get() {
        while (true) {
            if (!bo)
                try {
                    this.wait();// 如果已经消费了面包，等待
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            System.out.println(Thread.currentThread().getName() + "---消费者" + this.name + "-------" + count);// 打印现在消费面包信息
            bo = false; // 标记已经消费了
            this.notifyAll(); // 唤醒所有
        }
    }

}

// 生产者
class Producter3 implements Runnable {
    private Resource3 res;
    private int num = 0;

    Producter3(Resource3 res) {
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
class Comsumer3 implements Runnable {
    private Resource3 res;
    private int num = 0;

    Comsumer3(Resource3 res) {
        this.res = res;
    }

    public void run() {
        while (num < 10) {
            res.get();
            num++;
        }
    }
}
