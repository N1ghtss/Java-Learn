package cn.tedu.basic_day0102;

public class HeartThread extends Thread{
    public void run(){
        Heart heart=new Heart();
        heart.Start();
    }
}
