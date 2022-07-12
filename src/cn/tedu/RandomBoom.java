package cn.tedu;

import java.util.Random;
import java.util.Scanner;

public class RandomBoom {
    public static void main(String[] args) {
        // 创建随机数对象
        Random random = new Random();
        // 定义一个变量用来保存产生的随机数
        int sui = random.nextInt(100) + 1;  // 1-100
        // System.out.println("数字炸弹是：" + sui);
        while (true) {
            System.out.println("请输入猜的数字：");
            // 定义一个变量用来保存用户输入的数
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            if (num > sui) {
                System.out.println("猜大了！！");
            } else if (num < sui) {
                System.out.println("猜小了！！");
            } else {
                System.out.println("请开始你的表演！！");
            }
        }
    }
}
