package base;

import org.junit.Test;

/**
 * 枚举的作用：需要的数据是在一定的范围类的值，jdk5之前采取的是自定义类去解决这个问题，5.0之后采取的是enumeration
 */
public class Enumeration_old {
    /**
     * 限定传入的参数为A,B,C,D,E
     */
    public void print(Grade grade) {
        System.out.println(grade.getGrade());
    }

    @Test
    public void testPrint() {
        print(Grade.D);
    }

}

class Grade {
    private String grade;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public static Grade getA() {
        return A;
    }

    public static Grade getB() {
        return B;
    }

    public static Grade getC() {
        return C;
    }

    public static Grade getD() {
        return D;
    }

    public static Grade getE() {
        return E;
    }

    private Grade(String grade) {
        this.grade = grade;
    }

    public static final Grade A = new Grade("A");
    public static final Grade B = new Grade("B");
    public static final Grade C = new Grade("C");
    public static final Grade D = new Grade("D");
    public static final Grade E = new Grade("E");
}