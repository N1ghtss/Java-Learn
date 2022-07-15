package cn.tedu.basicday04;

import java.util.Arrays;

public class Test6_BubbleSort {
    public static void main(String[] args) {
        int[] a={27,96,73,25,21};
        for (int i = 1; i <a.length ; i++) {
            for (int j = 0; j < a.length-1; j++) {
                if (a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
            System.out.println(Arrays.toString(a));
        }
    }
}
