package OtherAPI;

import Reflect.Person;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * beanUtils Apache出品  未添加jar包，后期
 */
public class BeanUtilsDemo {

    @Test
    public void test() throws Exception{
       // Person p = (Person) Class.forName("Reflect.Person").newInstance();
        Person p = new Person();
        BeanUtils.setProperty(p,"name","afd");
        System.out.println(p.getName());
    }

    /**
     * 基础类型转换成bean对象
     * @throws Exception
     */
    @Test
    public void testProductBean() throws  Exception{
        String name = "asdf";
        int age = 23;
        Long idCard = 124545645645645L;

        //Person p= (Person) Class.forName("Reflect.Person").newInstance();
        Person p = new Person();
        BeanUtils.setProperty(p,"name",name);
        BeanUtils.setProperty(p,"age",age);
        BeanUtils.setProperty(p,"idCard",idCard);

        System.out.println(p.getName());
        System.out.println(p.getAge());
        System.out.println(p.getIdCard());
    }

    @Test
    public void  testMapToBean()throws  Exception{
        Map map=new HashMap();
        map.put("name","asdfasdf");
        map.put("age",1);

        ConvertUtils.register(new DateLocaleConverter(), Date.class);
        Person p= (Person) Class.forName("Reflect.Person").newInstance();
        BeanUtils.populate(p,map);

        System.out.println(p.toString());
    }

}
