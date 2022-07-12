package cn.tedu;

// 学生类的测试类
public class StudentTest {
    public static void main(String[] args) {
        // 创建一个学生对象
        Student s1 = new Student();
        // 给成员变量赋值
        s1.name = "张三";
        s1.age = 28;
        s1.address = "小学课本";
        // 调用方法
        s1.Game();
        s1.Sleep();
        s1.sayHi();
    }
}
