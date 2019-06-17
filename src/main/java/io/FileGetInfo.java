package io;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
aa,23,34,23
ffsd,89,33,1
io,9,34,34
ui,21,79,33
over
 */
public class FileGetInfo {
    public static void main(String[] args) throws IOException {
        Comparator<Studentz> compz = Collections.reverseOrder();
        Set<Studentz> set = GetInfoToolz.getStudentz(compz);
        File dest = new File("src\\testpackage.BBB.TempFile\\fileTest.txt");
        GetInfoToolz.write2File(set, dest);
    }
}


class GetInfoToolz {
    public static Set<Studentz> getStudentz() throws IOException {
        return getStudentz(null);
    }

    public static Set<Studentz> getStudentz(Comparator<Studentz> comp) throws IOException {
        BufferedReader bur = new BufferedReader(new InputStreamReader(System.in));

        Set<Studentz> set = new TreeSet<Studentz>();

        if (comp != null) {
            set = new TreeSet<Studentz>(comp);
        } else {
            set = new TreeSet<Studentz>();
        }

        String line = null;
        while ((line = bur.readLine()) != null) {
            if ("over".equals(line)) {
                break;
            }
            String[] strs = line.split(",");
            Studentz stuz = new Studentz(strs[0], Integer.parseInt(strs[1]), Integer.parseInt(strs[2]), Integer.parseInt(strs[3]));
            set.add(stuz);
        }
        return set;
    }

    public static void write2File(Set<Studentz> set, File desFile) throws IOException {
        BufferedWriter bufr = null;
        try {
            bufr = new BufferedWriter(new FileWriter(desFile));

            for (Studentz stuz : set) {
                bufr.write(stuz.getName() + "\t" + stuz.getSum());
                bufr.newLine();
                bufr.flush();
            }
        } finally {
            if (bufr != null) {
                try {
                    bufr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


class Studentz implements Comparable<Studentz> {
    private String name;
    private int ma, cn, en, sum;

    public Studentz() {
        super();
    }

    public Studentz(String name, int ma, int cn, int en) {
        super();
        this.name = name;
        this.ma = ma;
        this.cn = cn;
        this.en = en;
        this.sum = ma + cn + en;
    }

    public int getCn() {
        return cn;
    }

    public void setCn(int cn) {
        this.cn = cn;
    }

    public int getEn() {
        return en;
    }

    public void setEn(int en) {
        this.en = en;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Studentz o) {
        int temp = this.sum - o.sum;
        return temp == 0 ? this.name.compareTo(o.name) : temp;
    }
}
