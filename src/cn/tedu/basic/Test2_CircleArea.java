package cn.tedu.basic;

import java.util.Arrays;
import java.util.Scanner;

public class Test2_CircleArea {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
//        System.out.println("请输入半径");
//        double r=scanner.nextDouble();
//        double area=Math.PI*r*r;
//        System.out.println("圆的面积为："+area);
        //梯形面积
        System.out.println("请输入梯形的上底：");
        double t=scanner.nextDouble();
        System.out.println("请输入梯形的下底：");
        double d=scanner.nextDouble();
        System.out.println("请输入梯形的高：");
        double h=scanner.nextDouble();
        double tarea=(t+d)*h/2;
        System.out.println("梯形的面积为："+tarea);
    }
}
