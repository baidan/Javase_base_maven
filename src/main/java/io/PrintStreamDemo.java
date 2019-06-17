package io;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {
    public static void main(String[] args) throws IOException {
        printDemo();
    }
    private static void printDemo() throws IOException {
        File dir = new File("src\\testpackage.BBB.TempFile");
        if(!dir.exists()){
            dir.mkdir();
        }
        String path = "src\\testpackage.BBB.TempFile\\PrintStreamDemo.txt";
        PrintStream ps = new PrintStream(path);
        ps.write("353".getBytes());
        ps.close();
    }
}
