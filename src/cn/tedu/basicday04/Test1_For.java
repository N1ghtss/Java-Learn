package cn.tedu.basicday04;

import java.text.Format;

public class Test1_For {
    public static void main(String[] args) {
        int s;
        for (s=0;s<=10;s++){
            System.out.println(s);
        }
        for (s=10;s>=0;s--){
            System.out.println(s);
        }
        for (s=8;s<=10000;s=s*10+8){
            System.out.println(s);
        }

    }
}
