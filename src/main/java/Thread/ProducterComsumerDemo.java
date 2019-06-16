package Thread;

//生产者---消费者示例
public class ProducterComsumerDemo {
    public static void main(String[] args) {
        Resource_a res = new Resource_a();
        Comsumer_a t1 = new Comsumer_a(res);
        Comsumer_a t2 = new Comsumer_a(res);
        new Thread(t1).start();
        new Thread(t2).start();
    }
}

// 访问的资源
class Resource_a {
    private String name;
    private int count = 0;
    private Boolean bo = false;

    public synchronized void set(String name) {
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
        this.notify(); // 唤醒消费者，线程池只有一个等待中的线程
    }

    public synchronized void get() {
        if (!bo)
            try {
                this.wait();// 如果已经消费了面包，等待
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        System.out.println(Thread.currentThread().getName() + "---消费者" + this.name + "-------" + count);// 打印现在消费面包信息
        bo = false; // 标记已经消费了
        this.notify(); // 唤醒生产者，线程池只有一个等待中的线程
    }

}

// 生产者
class Comsumer_a implements Runnable {
    private Resource_a res;
    private int num = 0;

    Comsumer_a(Resource_a res) {
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
class Comsumer1 implements Runnable {
    private Resource_a res;
    private int num = 0;

    Comsumer1(Resource_a res) {
        this.res = res;
    }

    public void run() {
        while (num < 10) {
            res.get();
            num++;
        }
    }
}
