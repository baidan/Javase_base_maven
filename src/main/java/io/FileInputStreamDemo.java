package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {

    private static final int DEAULT_SIZE = 1024;
    private static File file = new File("testpackage.BBB.TempFile\\fos.txt");

    public static void main(String[] args) throws IOException {
        // extracted();
        readByteFn1();
        readByteFn2();
        readByteFn3();
    }

    private static void readByteFn3() {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);
            byte[] buf = new byte[fis.available()];
            fis.read(buf);
            System.out.println(new String(buf, "utf-8"));
        } catch (IOException e) {
            // TODO: handle exception
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    private static void readByteFn2() {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);
            byte[] buf = new byte[DEAULT_SIZE];
            int len = 0;
            while ((len = fis.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len, "utf-8"));
            }

        } catch (IOException e) {
            // TODO: handle exception
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public static void readByteFn1() throws IOException {
        if (!file.exists())
            throw new FileNotFoundException();

        FileInputStream fis = new FileInputStream(file);
        int by1 = 0;

        while ((by1 = fis.read()) != -1) {
            System.out.println("by1===" + by1);

        }

        fis.close();
    }
}