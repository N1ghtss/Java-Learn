package cn.tedu.basic_day05;

public class Test1_ExtendsDemo {
    public static void main(String[] args) {
        Cat c = new Cat();
        c.eat();

        DingDang d = new DingDang();
        d.eat();
        d.print();

    }
}

//父类
class Animal {
    public void eat() {
        System.out.println("吃啥都行~");
    }
}

//子类
class Cat extends Animal {
    int a = 10;
    private int sum = 100;

}

//Cat类的子类
class DingDang extends Cat {
    public void print() {
        System.out.println(a);
        //System.out.println(sum);
    }
}
