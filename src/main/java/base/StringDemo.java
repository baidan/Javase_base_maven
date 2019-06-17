package base;

public class StringDemo {
    public static void main(String[] argrs) {
        Integer i = 5;
        int a = i.intValue() + 6;

        Integer x = new Integer(100);
        Integer y = new Integer(100);
        System.out.println(x == y);
        System.out.println(x.equals(y));
        System.out.println("===========================");

        Integer m = 127;
        Integer n = 127;

        System.out.println("3===" + (m == n));
        System.out.println("4===" + (m.equals(n)));

        System.out.println("===========================");

        String s1 = "abcd";
        String s2 = new String("abcd");
        char[] s3 = { 'a', 'b', 'c', 'd' };
        String s4 = new String(s3);
        System.out.println(s1 == s2); // false
        System.out.println(s1.equals(s2)); // true

        System.out.println(s1 == s4);
        System.out.println(s1.equals(s4));

        System.out.println(s2 == s4);
        System.out.println(s2.equals(s4));

        System.out.println();

        Object obj = new Object();
        obj.equals(s3);

        String[] aaa = { "bbb", "iii", "aa3b", "aaa4", "ggf", "hjg", "dik2", "234", "aa" };
        sort(aaa);
        printStr(aaa);

        String str = "anasdfasfnbadnbadasdnbadfg34nba234";
        String key = "nba";

        int count = getKeyCount(str, key);

        System.out.println("count===" + count);

        // 查找两个字符串中，最大的子字符串
        String a1 = "asdfgjasdfchellowordhellowordcatvsdafsadfrtyrrfdss";
        String a2 = "asfccatvshellowordhelloworddfsdartyrrfdss";
        String comMaxStr = getComMaxStr1(a1, a2);

        System.out.println("comMaxStr===" + comMaxStr);
    }

    public static String getComMaxStr1(String a1, String a2) {
        String longStr, shortStr;
        longStr = a1.length() > a2.length() ? a1 : a2;
        shortStr = a1.equals(longStr) ? a2 : a1;
        int len = shortStr.length();
        for (int x = 0; x < len; x++) {
            for (int y = 0, z = len - x; z <= len; y++, z++) {
                String temp = shortStr.substring(y, z);
                // System.out.println("y===" + y + ", z===" + z);
                System.out.println("[" + y + "," + z + "]," + "temp===" + temp);
                if (longStr.contains(temp)) {
                    return temp;
                }
            }
            System.out.println("x==================================================" + x);
        }

        return "";
    }

    public static String getComMaxStr2(String a1, String a2) {
        String longStr, shortStr;
        longStr = a1.length() > a2.length() ? a1 : a2;
        shortStr = a1.equals(longStr) ? a2 : a1;
        int len = shortStr.length();
        String temp = "";
        for (int x = 0; x < len; x++) {
            for (int y = len - x; y < len; y++) {
                temp = shortStr.substring(x, y);
                // System.out.println("y===" + y + ", z===" + z);
                System.out.println("[" + x + "," + y + "]," + "temp===" + temp);

                if (longStr.contains(temp)) {
                    temp = temp.length() > shortStr.substring(x, y).length() ? temp : shortStr.substring(x, y);
                }
            }
            System.out.println("x==================================================" + x);
        }

        return temp;
    }

    public static String getComMaxStr(String a1, String a2) {
        String longStr, shortStr;
        longStr = a1.length() > a2.length() ? a1 : a2;
        shortStr = a1.equals(longStr) ? a2 : a1;
        String temp = "";
        for (int i = 0; i < shortStr.length(); i++) {
            for (int j = shortStr.length(); j > i; j--) {
                System.out.println("shortStr.substring(i, j)===" + shortStr.substring(i, j));
                if (longStr.indexOf(shortStr.substring(i, j)) != -1) {
                    temp = temp.length() > shortStr.substring(i, j).length() ? temp : shortStr.substring(i, j);
                }
            }
            System.out.println("i==================================================" + i);
        }
        return temp;
    }

    public static int getKeyCount(String str, String key) {
        int count = 0;
        int fromIndex = 0;
        while ((fromIndex = str.indexOf(key, fromIndex)) != -1) {
            System.out.println("str.indexOf===" + str.indexOf(key, fromIndex));
            count++;
            fromIndex += key.length();
            System.out.println("fromIndex===" + fromIndex);
        }
        return count;
    }

    public static void sort(String[] s) {
        for (int x = 0; x < s.length - 1; x++) {
            for (int y = x + 1; y <= s.length - 1; y++) {
                if (s[x].compareTo(s[y]) > 0) {
                    String temp = s[x];
                    s[x] = s[y];
                    s[y] = temp;
                }
            }
        }
    }

    public static void printStr(String[] s) {
        String a = "";
        for (int i = 0; i <= s.length - 1; i++) {
            if (i != s.length - 1) {
                a += s[i] + ",";
            } else
                a += s[i];
        }
        System.out.println(a);
    }

}
