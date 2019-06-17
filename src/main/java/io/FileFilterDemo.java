package io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class FileFilterDemo {
    public static void main(String[] args) {
        fileFilterDemoTest();
        //fileFilterDemoTest2();
        int a = 3, b=0;
        b = a++;
        System.out.println("a===" + a);
        System.out.println("b===" + b);
        System.out.println("b===" + b);
    }

    //只能遍历当前目录
    private static void fileFilterDemoTest2() {
        String path = "src" + File.separator;
        File fiz = new File(path);
        if (fiz.exists()) {
            for (String fileName : fiz.list(new FilterNameBySuffix(".java"))) {
                System.out.println("fileName by .java === " + fileName);
            }
            ;
        }
    }

    //遍历所有目录
    private static void fileFilterDemoTest() {
        List<File> list = new ArrayList<File>();

        File dir = new File("E:" + File.separator + "javaTest2");

        /*getFileList(dir, list, new FileFilter(){
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".java");
            }
        });*/

        getFileList(dir, list, new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".class");
            }
        });
    }

    public static void getFileList(File dir, List<File> list, FilenameFilter filter) {

       /* File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                getFileList(file, list, filter);
            } else {
                if (filter.accept(file))
                    list.add(file);
            }
        }*/

        //File[] files = dir.listFiles(filter); //返回已经是过滤之后的文件对象，意义不大。
        File[] files = dir.listFiles();
        for (File file : files) {
            //System.out.println("fileName==="+file.getName());
            if (file.isDirectory()) {
                getFileList(file, list, filter);
            } else {
                if (filter.accept(dir, file.getName())) {
                    list.add(file);
                }
            }
        }

        for (File file : list) {
            System.out.println(file);
        }
    }
}


class FilterNameBySuffix implements FilenameFilter, FileFilter {


    private String suffix;

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public FilterNameBySuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * Tests if a specified file should be included in a file list.
     *
     * @param dir  the directory in which the file was found.
     * @param name the name of the file.
     * @return <code>true</code> if and only if the name should be
     * included in the file list; <code>false</code> otherwise.
     */
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(suffix);
    }

    /**
     * Tests whether or not the specified abstract pathname should be
     * included in a pathname list.
     *
     * @param file The abstract pathname to be tested
     * @return <code>true</code> if and only if <code>pathname</code>
     * should be included
     */
    @Override
    public boolean accept(File file) {
        return file.getName().endsWith(suffix);
    }
}