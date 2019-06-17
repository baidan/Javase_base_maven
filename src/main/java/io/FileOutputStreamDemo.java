package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        // extracted();
        testFileException();
    }

    private static void extracted() throws FileNotFoundException, IOException {
        File dir = new File("testpackage/TempFile");
        if (!dir.exists()) {
            dir.mkdir();
        }
        FileOutputStream fos = new FileOutputStream("testpackage.BBB.TempFile\\fos.txt", true);

        fos.write("abcesdf".getBytes());

        fos.close();
    }

    public static void testFileException() {
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("tempFile111\\fos.txt", true);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) //
                    fos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                throw new RuntimeException("" + e);
            }
        }
    }
}