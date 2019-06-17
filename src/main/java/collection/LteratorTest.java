package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class LteratorTest {
    public static void main(String[] args) {
        Collection c = new ArrayList<>();
        c.add("abc1");
        c.add("abc2");
        c.add("abc3");
        for (Iterator it = c.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }

        Collection lt = new LinkedList<>();
        lt.add(c);

        Collection sets = new HashSet<>();
        sets.add(c);

        /*
         * collection treeSet = new TreeSet<>(); treeSet.add(c);
         */

        Map<String, String> map2 = new TreeMap<String, String>();

        Map<String, Integer> map = new TreeMap<String, Integer>();
        String str = "bwaerbctyxbacecrtdcrv";
        char[] strs = str.toCharArray();
        for (int i = 0; i < strs.length; i++) {
            // System.out.println(strs[i]);

            String key = String.valueOf(strs[i]);
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                Integer values = map.get(key);
                // System.out.println("values===" + values);
                map.put(key, ++values);
            }
        }
        System.out.println("map===" + map);
    }
}