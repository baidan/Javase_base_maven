package otherapi;

import java.util.Random;

class MathDemo {
    public static void main(String[] args) {
        double d1 = Math.ceil(12.34);
        double d2 = Math.floor(12.34);
        double d3 = Math.round(12.34);
        System.out.println("d1===" + d1);
        System.out.println("d2===" + d2);
        System.out.println("d3===" + d3);

        System.out.println(Math.pow(10, 3));

        for (int i = 0; i < 10; i++) {
            int d = (int) Math.ceil(Math.random() * 6);
            System.out.println("d===" + d);
        }

        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int d = r.nextInt(6) + 1;
            System.out.println("random:" + d);
        }
    }
}