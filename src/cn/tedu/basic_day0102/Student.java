package cn.tedu.basic_day0102;

// 学生类
public class Student {
    // 成员变量
    String name;
    int age;
    String address;

    // 方法
    public void Game(){
        System.out.println("在寝室五黑！");
    }
    public void Sleep(){
        System.out.println("睡觉~~~");
    }
    public void sayHi(){
        System.out.println("大家好，我叫"+name+",今年"+age+"岁了，家住"+address);
    }
}
