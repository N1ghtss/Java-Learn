package cn.tedu.basic_day05;

public class Test2_Extends1 {
    public static void main(String[] args) {
        Son s = new Son();
        s.eat();
    }
}

class Father {
    int count = 0;
    int sum = 300;

    public final void ex() {
    }

}

class Son extends Father {
    int sum = 100;

    public void eat() {
        int sum = 10;
        System.out.println(sum);
        System.out.println(this.sum);
        System.out.println(count);
        System.out.println(super.sum);
    }

}
