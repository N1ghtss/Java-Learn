package cn.tedu.basic_day05;

public class Test3_MoreTypeDemo {
    public static void main(String[] args) {
        Animal1 a = new Animal1();
        a.eat();
        Cat1 c=new Cat1();
        c.eat();

        //父类引用指向子类对象
        a=new Cat1();
        a.eat();
        //使用父类的声明
        //a.jump();
    }
}

class Animal1 {
    public void eat() {
        System.out.println("吃啥都行~");
    }
}

class Cat1 extends Animal1 {
    public void eat() {
        System.out.println("小猫爱吃小鱼干~");
    }
    public void jump(){
        System.out.println("you jump!i jump");
    }
}
