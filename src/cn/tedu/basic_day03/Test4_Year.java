package cn.tedu.basic_day03;

import java.util.Scanner;

public class Test4_Year {
    public static void main(String[] args) {
        System.out.println("请输入年份");
        int year = new Scanner(System.in).nextInt();
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println("闰年");
        } else {
            System.out.println("平年");

        }
    }
}

