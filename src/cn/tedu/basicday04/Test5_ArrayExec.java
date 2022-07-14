package cn.tedu.basicday04;

public class Test5_ArrayExec {
    public static void main(String[] args) {
        int[] s={31,28,31,30,31,30,31,31,30,31,30,31};
        for (int i=0;i<s.length;i++){
            System.out.println((i+1)+"月有"+s[i]+"天");
        }
    }
}
