package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class SoftwareTrial {
    public static void main(String[] args) throws IOException {
        runSoft();
    }

    private static boolean runSoft() throws IOException {
        int count = 0;
        boolean  lockFlag = true;
        File file = new File("src\\tempfile\\lock.properties");
        if(!file.exists()){
            file.createNewFile();
        }

        Properties ps= new Properties();
        FileInputStream  fis= new FileInputStream(file);
        ps.load(fis);

        String  value = ps.getProperty("count");

        if(value!=null){
            count = Integer.parseInt(value);
            if(count>=5){
                System.out.println("你的试用已用完！请注册");
                lockFlag = false;
            }
        }

        count++;

        ps.setProperty("count",Integer.toString(count));

        FileOutputStream fos=new FileOutputStream(file);

        ps.store(fos,"");

        return lockFlag;
    }
}
