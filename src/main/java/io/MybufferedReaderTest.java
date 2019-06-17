package io;

import java.io.*;

public class MybufferedReaderTest {
    public static void main(String[] args) throws IOException {
        Reader rd = new FileReader("src\\testpackage.BBB.TempFile\\fileTest.txt");
        //BufferedReader bfr = new BufferedReader(rd);
        //MybufferedReader mbr = new MybufferedReader(rd);
        //mbr = new MylineNumberReader(rd);
        MylineNumberReader mbr = new MylineNumberReader(rd);
        try {
            System.out.println(97);
            String line = null;
            while ((line = mbr.myReadLine()) != null) {
                System.out.println(mbr.getLineNumber() + ":" + line);
            }
        } finally {
            mbr.myClose();
        }
    }
}
