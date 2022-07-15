package cn.tedu.basic_day03;

import java.util.Scanner;

public class Test5_Discount {
    public static void main(String[] args) {
        System.out.println("请输入价格：");
        double price = new Scanner(System.in).nextFloat();
        double nprice = price;
        if (price >= 1000) {
            nprice = price * 0.9;
            if (price >= 2000) {
                nprice = price * 0.8;
                if (price >= 5000) {
                    nprice = price * 0.5;
                }
            }
        }
        System.out.println("最终价格为：" + nprice);
    }
}
