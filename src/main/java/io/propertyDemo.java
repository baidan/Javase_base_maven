package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class propertyDemo {
    public static void main(String[] args) throws IOException {
        printProperty();
    }

    private static void printProperty() throws IOException {
        Properties ps = new Properties();
        ps.setProperty("name", "baidan");
        ps.setProperty("sex", "man");
        ps.setProperty("age", "20");
        ps.list(System.out);
        Set<String> keys = ps.stringPropertyNames();
        for (String key : keys) {
            String value = ps.getProperty(key);
            System.out.println(key + "..." + value);
        }

        FileOutputStream fos = new FileOutputStream("src\\testpackage.BBB.TempFile\\info.properties");
        ps.store(fos, "set");
        fos.close();
    }

}
