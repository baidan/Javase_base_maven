package IO;

import java.io.*;
import java.util.ArrayList;

public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        //fileWrite();
        fileRead();
    }

    private static void fileWrite() throws IOException {
        FileWriter fw  = new FileWriter("src\\tempfile\\fw.txt");
        /*FileOutputStream fos = new FileOutputStream("src\\TestPackage.BBB.TempFile\\GBK.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);*/
        fw.write("测试FileRead方法");
        fw.close();
    }

    private static void fileRead() throws IOException {
        FileReader fr = new FileReader("src\\tempfile\\fw.txt");

        /*FileInputStream fileInputStream = new FileInputStream("src\\tempfile\\fw.txt");
        InputStreamReader inputStreamReader  = new InputStreamReader(fileInputStream);*/

        int b = 0;
        ArrayList<String> alist = new ArrayList<String>();
        String ss = new String();
        while((b=fr.read())!=-1){
            String temp = Character.toString((char)b);
            ss += temp;
        }
        fr.close();
        System.out.println(ss);
    }
}
