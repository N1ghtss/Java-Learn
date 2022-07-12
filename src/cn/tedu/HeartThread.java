package cn.tedu;

public class HeartThread extends Thread{
    public void run(){
        Heart heart=new Heart();
        heart.Start();
    }
}
