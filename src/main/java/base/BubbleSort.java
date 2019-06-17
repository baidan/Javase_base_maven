package base;

import org.junit.Test;

public class BubbleSort {
    public static void main(String args[]){

        //int z = 5;
        for(int x=0; x<5;x++){
            for(int y=x; y<5; y++){
                System.out.print("*");
            }
            //z--;
            System.out.println();
        }

        System.out.println("\"Hello,World\"");

        int[] arrrs = {11,2,44,223,4,90};
        //printArr(arrrs);
        //bubbleSort(arrrs);
        //printArr(arrrs);

    }

    @Test
    public  void bubbleSort(int[] arrs){
        for(int x = 0; x<arrs.length-1; x++){
            for(int y = 0; y<arrs.length -1 -x; y++){
                if(arrs[y]>arrs[y+1]){
                    int temp = arrs[y];
                    arrs[y] = arrs[y+1];
                    arrs[y+1] = temp;
                }
            }
        }
    }
    @Test
    public  void printArr(int[] arrs){
        String res = "";
        for(int i =0; i<arrs.length; i++){
            if(i != arrs.length-1)
                res += arrs[i]+",";
            else
                res += arrs[i]+"";
        }
        System.out.println("res==="+res);
    }
}