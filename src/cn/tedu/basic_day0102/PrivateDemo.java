package cn.tedu.basic_day0102;

public class PrivateDemo {
    public static void main(String[] args) {
        // 4.创建学生类对象 -- 通过new关键字
        Student1 s1 = new Student1();
        // 5.初步测试Student1对象 -- 属性和方法 -- 通过.调用
        System.out.println(s1.name);
        System.out.println(s1.sno);
        s1.Study();
        // System.out.println(s1.subject);
        System.out.println(s1.getSubject());
    }
}

// 1.通过class关键字创建学生类  -- 用来描述学生这一类型 -- 属性 + 行为
class Student1 {
    // 2.定义属性 -- 成员变量
    String name;
    int sno;

    // 3.定义行为 -- 方法
    public void Study(){
        System.out.println("正在学Java...");
    }

    // 6.对成员变量进行封装
    private String subject;  // 科目
    // 对外提供公共的属性值访问方式
    public String getSubject(){
        return subject;
    }
}


