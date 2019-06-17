package collection;

import org.junit.Test;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map的两种迭代方式，需要转成set去遍历，实际上就是看有没有实现了iterator接口。以及增强for循环
 */
public class HashMap {
    @Test
    public void mapTest() {
        Map map = new LinkedHashMap();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        Set set = map.keySet();
        Iterator lt = set.iterator();
        while (lt.hasNext()) {
            int key = (Integer) lt.next();
            String value = (String) map.get(key);
            System.out.println(key + ":" + value);
        }
    }

    @Test
    public void mapTest2() {
        Map map = new LinkedHashMap();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        Set set = map.entrySet();
        Iterator lt = set.iterator();
        while (lt.hasNext()) {
            Map.Entry a = (Map.Entry) lt.next();
            int key = (Integer) a.getKey();
            String value = (String) a.getValue();
            System.out.println(key + ":" + value);
        }
    }

    /**
     * 新方法，增强for循环迭代
     */
    @Test
    public void mapTest3() {
        Map map = new LinkedHashMap();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        for (Object keyTemp : map.keySet()) {
            int key = (Integer) keyTemp;
            String value = (String) map.get(key);
            System.out.println(key + ":" + value);
        }

        for(Object o : map.entrySet()){
            Map.Entry s = (Map.Entry)o;
            int key = (Integer) s.getKey();
            String value = (String) s.getValue();
            System.out.println(key + ":" + value);
        }
    }
}
