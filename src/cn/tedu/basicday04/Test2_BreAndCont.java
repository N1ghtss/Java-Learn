package cn.tedu.basicday04;

import java.util.Scanner;

public class Test2_BreAndCont {
    public static void main(String[] args) {
        System.out.println("请输入数字：");
        for (int i = 0; i <= 100; i++) {
            int t = new Scanner(System.in).nextInt();
            if (t != 88) continue;
            if (t == 88) break;

        }
    }
}
