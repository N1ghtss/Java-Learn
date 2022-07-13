package cn.tedu.basic;

import java.util.Scanner;

public class Test6_ScoreLevel {
    public static void main(String[] args) {
        System.out.println("请输入分数：");
        int s = new Scanner(System.in).nextInt();
        while (true) {
            if (s<0|s>100){
                System.out.println("分数异常，请重新输入");
                s = new Scanner(System.in).nextInt();
            }else {
                break;
            }
        }
        if (s >= 90) {
            System.out.println("优秀");
        } else if (s >= 80 && s <= 89) {
            System.out.println("良好");
        } else if (s >= 70 && s <= 79) {
            System.out.println("中等");
        } else if (s >= 60 && s <= 69) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }

    }
}
