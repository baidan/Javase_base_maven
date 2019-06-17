package io;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

public  class InputStreamReaderDemo {
    public static void main(String[] args) throws  IOException {
        //readCnText();

        writeCnText();
    }

    @Test
    private static void writeCnText() throws IOException {
        FileOutputStream fos = new FileOutputStream("src\\testpackage.BBB.TempFile\\GBK.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        osw.write("撒地方阿斯顿发货");
        osw.close();
    }

    // 通过字符流读取中文数据
    private static void readCnText() throws IOException {
        FileInputStream fis = new FileInputStream("testpackage.BBB.TempFile\\cn.txt");
        InputStreamReader isr = new InputStreamReader(fis);

        /*
         * int b = isr.read(); System.out.println((char) b);
         */

        int b = 0;

        ArrayList<String> list = new ArrayList<String>();

        while ((b = isr.read()) != -1) {
            String s = Character.toString((char) b);
            list.add(s);
        }
        System.out.println("list===" + list.toString());
        isr.close();
    }
}
