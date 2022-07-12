package cn.tedu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

public class Heart extends Frame {
    public static void main(String[] args) {
        Heart heart = new Heart();
        //窗口大小
        heart.setSize(400, 400);
        //置顶
        heart.setAlwaysOnTop(true);
        //边框
        heart.setUndecorated(true);
        //背景色
        Color color = new Color(255, 255, 255, 0);
        heart.setBackground(color);
        //可见性
        heart.setVisible(true);
        //移动
        int index = 0;
        while (true){
            heart.setLocation(0,index);
            index=index+1;
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (index>1000){
                index=0;
            }
        }


    }

    public void paint(Graphics g) {
        try {
            FileInputStream file = new FileInputStream("image\\公子的心.png");
            BufferedImage image = ImageIO.read(file);
            g.drawImage(image, 0, 0, 400, 400, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
