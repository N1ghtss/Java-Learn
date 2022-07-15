package cn.tedu.basic_day0102;

public class StartHeart {
    public static void main(String[] args) {
        
        for (int i=0;i<50;i++){
            HeartThread heartThread=new HeartThread();
            heartThread.start();
        }
    }
}
