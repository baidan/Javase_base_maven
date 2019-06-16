package OtherAPI;

import Reflect.Person;
import org.junit.Test;

import java.beans.*;
import java.lang.reflect.Method;

public class BeanInfoDemo {
    public static void main(String[] args) {

    }

    /*
     *  根据get set 有几个 就有几个属性
     * */
    @Test
    public void testBeanInfo() throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class); //第二个参数可以排除从父类继承过来的属性  Object.class
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor ps : pds) {
            Method md = ps.getWriteMethod();
            System.out.println(md.getName());
            System.out.println("md===" + md);
        }
    }


    //操作bean指定的属性：age
    @Test
    public void testPropDescription() throws Exception {
        PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
        Method md = pd.getWriteMethod(); //获取写方法
        Person p = (Person) Class.forName("Reflect.Person").newInstance();
        md.invoke(p, 45);
        System.out.println(p.getAge());

        //获取属性的值
        md = pd.getReadMethod();
        System.out.println(md.invoke(p, null));
    }

    //获取当前属性的类型
    @Test
    public void testType() throws Exception {
        PropertyDescriptor pd = new PropertyDescriptor("age", Person.class);
        Class cs = pd.getPropertyType();
        System.out.println(cs);
    }
}
