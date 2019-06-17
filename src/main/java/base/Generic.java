package base;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 泛型是约束参数类型的一种手段，当做一个变量即可
 * 在编译时有效，编译后后移除
 * 泛型指定的是引用类型，非基本类型
 */
public class Generic {
    @Test
    public void testGeneric(){
        Map<String,Integer> map = new HashMap<>();
        map.put("asdf",111);
    }

    @Test
    public void testGeneric1(){
        Map<Integer,String> map = new HashMap<Integer, String>();  //引用类型有指定，右边如果没有指定/称为参数化泛型类型，为了兼容
        map.put(111,"aaa");
        map.put(222,"bbb");
        map.put(333,"ccc");
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        Iterator<Map.Entry<Integer,String>> it = set.iterator();
        while (it.hasNext()){
            Map.Entry<Integer,String> entry = it.next();
            int key = entry.getKey();
            String value = entry.getValue();

           // System.out.println(key+"="+value);

            //增强for
            for(Map.Entry<Integer,String> ent : map.entrySet()){
                int key1 = entry.getKey();
                String value1 = entry.getValue();
                System.out.println(key+"==="+value);
            }
        }

    }
}
