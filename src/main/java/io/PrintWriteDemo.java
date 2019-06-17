package io;

import java.io.*;

public class PrintWriteDemo {
    public static void main(String[] args) throws IOException {
        printscreen();
    }

    private static void printscreen() throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PrintWriter write = new PrintWriter(System.out, true);
        String line = null;
        while ((line = read.readLine()) != null) {
            if (line.equals("over")) {
                return;
            }
            write.println(line.toUpperCase());
            //write.flush();  //autoFlush:true
        }
        write.close();
    }
}
