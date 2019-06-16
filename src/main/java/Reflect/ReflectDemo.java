package Reflect;


import org.junit.Test;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 以上三个方法使我们可以从类中解剖出构造函数，方法和成员变量。getConstrutor  getMethod  getFiled    getDeclaredComstructor
 * 利用构造函数我们可以实例化对象，执行方法，字段封装数据
 */
public class ReflectDemo {
    @Test
    public void testReflect() throws Exception {
        //1
        Class clazz = Class.forName("Reflect.Person");
        //2
        //Class clazz2 = new Person().getClass();
        //3
        Class clazz3 = Person.class;
    }

    @Test
    public void testConstructor() throws Exception {
        Class clazz = Class.forName("Reflect.Person");
        Constructor c = clazz.getConstructor(String.class);
        Person person = (Person) c.newInstance("户籍人口");
        //System.out.println(person.name);
    }

    @Test
    public void testDeclaredConstructor() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("Reflect.Person");
        Constructor c = clazz.getDeclaredConstructor(List.class);
        c.setAccessible(true);//Declared需要暴利反射    //java.lang.IllegalAccessException: Class Reflect.ReflectDemo can not access a member of class Reflect.Person with modifiers "private"
        Person person = (Person) c.newInstance(new ArrayList<>());
    }

    @Test
    public void testClazzNewInstance() throws Exception {
        //必须要有无参构造方法
        Class clazz = Class.forName("Reflect.Person");
        Person person = (Person) clazz.newInstance(); //调用的是无参构造方法，简洁方式
    }


    @Test
    public void testMethod() throws Exception {
        //Person person =new Person();
        Class clazz = Class.forName("Reflect.Person");
        Method method = clazz.getMethod("setName", String.class);  //第一个为 方法名称。 后面的可变参数为 参数的类型
        //method.setAccessible(true); 如果需要访问私有方法，暴利反射
        Person person = (Person) clazz.newInstance();
        method.invoke(person, "asdfasf");  //调用哪个对象， 传入的参数是什么
        System.out.println(person.getName());
        //Class[] Class = new Class[]{String.class};
    }

    /**
     * 测试静态方法
     *
     * @throws Exception
     */
    @Test
    public void testStaticMethod() throws Exception {
        Class clazz = Class.forName("Reflect.Person");
        Method method = clazz.getMethod("testStatic", int.class);
        method.invoke(null, 243); //静态方法无需传入对象/可选
    }

    /**
     * 反射main方法
     * @throws Exception
     */
    @Test
    public void testMainMethod() throws Exception {
        Class clazz = Class.forName("Reflect.Person");
        Method method = clazz.getMethod("main", String[].class);
        String [] a = {"sdaf","adfasdf"};
        //method.invoke(null, a); //报错
        method.invoke(null, new Object[]{a});  //1，两种方式解决1，转成Object对象，欺骗jvm，2，用object[]再次封装，拆出来就是一个数组
        //sum公司在升级的时候，jdk1.4的时候没有可变参数，传递参数是通过数组拆分成了多个参数;例如main(String s1, String s2)，所以此时传入的不是数组了，所以会报错;
        //jdk1.5之后通过可变参数  method.invoke(Object, Object...args); 1.5需要兼容1.4的写法,会参照1.4的方法去拆成多个参数
    }


    @Test
    public  void  testField() throws Exception{
        Class clazz = Class.forName("Reflect.Person");
       // Field field = clazz.getField("name");
        Field field = clazz.getDeclaredField("name");
        Person person = (Person) clazz.newInstance();
        field.setAccessible(true);//Declared需要暴利反射

        //获取字段的值
        Object name = field.get(person);
        System.out.println("name==="+name);

        //获取字段的类型
        Class f = field.getType();
        System.out.println(f);
    }
}
