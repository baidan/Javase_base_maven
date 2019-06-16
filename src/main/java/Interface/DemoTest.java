package Interface;

class A {
    public String show(B obj) {
        return ("Interface.A and Interface.D");
    }

    public String show(A obj) {
        return ("Interface.A and Interface.A");
    }

}

class B extends A {
    public String show(B obj) {
        return ("Interface.B and Interface.B");
    }

    public String show(A obj) {
        return ("Interface.B and Interface.A");
    }
}

class C extends B {
    public String show(B obj) {
        return ("Interface.C and Interface.B");
    }
}

class D extends B {

}

public class DemoTest {
    public static void main(String[] args) {
        A a1 = new A();

        A a2 = new C();

        B b = new B();
        C c = new C();
        D d = new D();

        System.out.println("1--" + a1.show(b));
        System.out.println("2--" + a1.show(c));
        System.out.println("3--" + a1.show(d));

        System.out.println("4--" + a2.show(new B()));
        System.out.println("5--" + a2.show(new C()));

        System.out.println("6--" + a2.show(d));
        System.out.println("7--" + b.show(b));
        System.out.println("8--" + b.show(c));
        System.out.println("9--" + b.show(d));
    }
}