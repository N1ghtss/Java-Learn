package cn.tedu.basicday04;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Test5_ArrayExec {
    public static void main(String[] args) {
//        int[] s = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//        for (int i = 0; i < s.length; i++) {
//            System.out.println((i + 1) + "月有" + s[i] + "天");
//        }
        int[] b = new int[10];
        for (int i = 0; i < 10; i++) {
            b[i]=i+1;
        }
        //Arrays -- 数组工具类
        //Arrays.toString(数组) -- 把数组里的数据用逗号连接成一个字符串[值·······]
        System.out.println(Arrays.toString(b));
        for (int i = 0; i <b.length ; i++) {
            System.out.println(b[i]);

        }
    }
}
