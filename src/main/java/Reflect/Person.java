package Reflect;

import java.util.List;

public class Person {
    private  String name = "张三";
    int age;
    Long idCard;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
        System.out.println("无参构造");
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name, int age, Long idCard) {
        this.name = name;
        this.age = age;
        this.idCard = idCard;
        System.out.println(name + "," + age + "," + idCard);
    }

    private Person(List list) {
        System.out.println("List" + list);
    }

    public static void  testStatic(int d){
        System.out.println("testStatic==="+d);
    }

    public void getA(){
        System.out.println("getA");
    }

    public String getName() {
        System.out.println("getName");
        return name;
    }

    public void setName(String name) {
        System.out.println("setName");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
        this.idCard = idCard;
    }

    public static void main(String[] args) {
        System.out.println("main"+args[0]);
    }

}
