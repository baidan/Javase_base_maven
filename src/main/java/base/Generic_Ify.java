package base;

/**
 * 泛型是约束参数类型的一种手段，当做一个变量即可
 * 在编译时有效，编译后后移除
 * 泛型指定的是引用类型，非基本类型
 * <p>
 * 自定义泛型类型的时候，返回的值编译器检查的时候就可以确定是具体类型
 */
public class Generic_Ify {

    public void testa() {
        a("aaa");
    }

    private <T> T a(T t) {
        return null;
    }

}
