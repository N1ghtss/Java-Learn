package cn.tedu.basic;

import java.util.Scanner;

public class Test7_switch {
    public static void main(String[] args) {
        System.out.println("请输入成绩：");
        double s = new Scanner(System.in).nextDouble();
        String level = null;
        if (s >= 90) {
            level = "1";
        } else if (s >= 80 && s <= 89) {
            level = "2";
        } else if (s >= 70 && s <= 79) {
            level = "3";
        } else if (s >= 60 && s <= 69) {
            level = "4";
        } else {
            level = "5";

        }
        switch (level) {
            case "1":
                System.out.println("优秀");
                break;
            case "2":
                System.out.println("良好");
                break;
            case "3":
                System.out.println("中等");
                break;
            case "4":
                System.out.println("及格");
                break;
            case "5":
                System.out.println("不及格");
                break;
        }

    }
}
