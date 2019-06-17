package base;

import java.util.Properties;
import java.util.Set;

class SysInfoDemo {
    public static void main(String[] args) {

        Properties ps = System.getProperties();
        Set<String> sts = ps.stringPropertyNames();

        for (String key : sts) {
            String value = ps.getProperty(key);
            System.out.println(key + "::" + value);
        }

        System.out.println("file.encoding===" + ps.getProperty("file.encoding"));

    }
}