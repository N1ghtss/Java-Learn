package cn.tedu;

public class StartHeart {
    public static void main(String[] args) {
        
        for (int i=0;i<50;i++){
            HeartThread heartThread=new HeartThread();
            heartThread.start();
        }
    }
}
