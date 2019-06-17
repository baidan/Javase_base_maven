package io;

import  java.io.File;
import java.io.IOException;

class FileDemo {
    public static void main(String[] args) throws IOException {
        //FileDemoTest();
        FileDemoTest2();
    }

    private static void FileDemoTest2() {
        File tempFile1 = new File("src"+File.separator+"tempFile1");
        fileDel(tempFile1);
    }

    private static void fileDel(File tempFile1) {
        for(File filez : tempFile1.listFiles()){
            if(filez.isDirectory()){
                fileDel(filez);
            }else{
                filez.delete();
            }
        }
        tempFile1.delete();
    }

    private static void FileDemoTest() throws IOException {
        File tempFile = new File("src"+File.separator+ "testpackage/TempFile");
        File file = new File("abc"+File.separator+"io.txt");
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getParent());

        long len = file.length();
        System.out.println(len);

        File file2 = new File("src"+File.separator+ "testpackage/TempFile" +File.separator+"sio.txt");
        boolean b = file2.createNewFile();
        System.out.println("file2==="+file2);
        System.out.println("getParent==="+file2.getParent());
        System.out.println("getParentFile==="+file2.getParentFile());
        System.out.println(b);


        File file3 = new File("src"+File.separator+ "testpackage/TempFile" +File.separator+"NewFolder"+File.separator+"NewFolderChild");
        if(!file3.exists()){
            boolean f = file3.mkdirs();
            System.out.println("f==="+f);
        }else{
            boolean del = file3.delete();
            System.out.println("del==="+del);
        }

        for(File filez : tempFile.listFiles()){
            System.out.println(filez.getName()+"---"+filez.length());
        }

    }
}

