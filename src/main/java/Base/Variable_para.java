package Base;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 可变参数，类似一个数组
 */
public class Variable_para {

    public void testSum(String a, int... nums) {
    }

    @Test
    public void testSum2() {
        testSum("sdaf", 1, 2, 4, 34);
    }

    /*
        将对象作为可变参数传入，利用jdk api中的Arrays.asList(<T...>), 细节：基础类型的数组就是一个对象。  数组对象的数组
     */
    @Test
    public void testSum3(){
        int [] ins1= {1,2,3,5}; //整个是一个对象
        int [] ins2 = {1,2,3,5}; //整个是一个对象
        Integer [] ins3 = {1,2,3,5};//多个对象
        List list = Arrays.asList(ins1,ins2,ins3);
        List list2 = Arrays.asList(ins2);
        List list3 = Arrays.asList(ins3);
        System.out.println(list);
        System.out.println(list2);
        System.out.println(list3);
    }
}
