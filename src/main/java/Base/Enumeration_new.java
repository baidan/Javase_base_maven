package Base;

import org.junit.Test;

/**
 * 枚举的作用：需要的数据是在一定的范围类的值，jdk5之前采取的是自定义类去解决这个问题，5.0之后采取的是enumeration
 */
public class Enumeration_new {
    /**
     * 限定传入的参数为A,B,C,D,E
     */
    public void print(Grades grade) {
        System.out.println(grade.getValue());
    }

    @Test
    public void testPrint() {
        print(Grades.E);
    }

}

enum Grades {  //class   A 100-90   B 89-80  C79-70  D69-60  E59-0  传入的值就是构造方法的参数
    A("100 - 90"), B("89 - 80"), C("79 - 70"), D("69 - 60"), E("59 - 0");  //object 对应的实际是对象
    private String value;
    private int value2;

    private Grades() {
    }

    private Grades(String value) {
        this.value = value;
    }

    private Grades(int value2) {
        this.value2 = value2;
    }

    public String getValue() {
        return this.value;
    }

    public int getValue2() {
        return this.value2;
    }
}

enum A{ //class   只有一个对象实例
    A;  //object   单例设计模式
}