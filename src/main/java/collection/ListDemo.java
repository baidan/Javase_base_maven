package collection;

import java.util.LinkedList;

public class ListDemo {
    public static void main(String[] args) {
        Persons p1 = new Persons(11, "张三");

        LinkedList link = new LinkedList();

        link.addFirst(p1);
        link.addFirst(p1);
        link.addFirst(p1);

        System.out.println(link);
    }
}

class Persons {
    int age;
    String name;

    Persons(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return this.name + "===" + this.age;
    }
}