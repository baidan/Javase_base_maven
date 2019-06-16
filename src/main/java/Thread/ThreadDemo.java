package Thread;

public class ThreadDemo {
    public static void main(String[] args) {
        Person p1 = new Person("张珊");
        Person p2 = new Person("历史");
        p1.start();
        p2.start();
    }
}

class Person extends Thread {
    String name;

    Person(String name) {
        this.name = name;
    }

    public void show() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "====");
        }
    }

    public void run() {
        show();
    }

    public void start() {
        super.start();
    }
}
