package cn.tedu.basic_day05;

public class Test4_ExtendsDesignCar {
    public static void main(String[] args) {
        Car c = new Car();
        c.start();
        c = new BMW();
        c.start();
        c = new Audi();
        c.start();
    }
}

class Car {
    String color = "White";
    String bround = null;

    public void start() {
        System.out.println(color + " " + bround + " start!!");
    }

    public void stop() {
        System.out.println("Stop");
    }
}

class BMW extends Car {
    String color = "Black";
    String bround = "BMW";

    public void start() {
        System.out.println(color + " " + bround + " start!!");
    }

}

class Audi extends Car {
    String color = "Red";
    String bround = "Audi";

    public void start() {
        System.out.println(color + " " + bround + " start!!");
    }

}
