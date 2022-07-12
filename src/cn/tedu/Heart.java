package cn.tedu;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.util.Random;

public class Heart extends Frame {
    public void Start() {
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
        Random random = new Random();
        int x=random.nextInt(1920);
        int index = 0;
        while (true){
            heart.setLocation(x,index);
            index=index+random.nextInt(20)+1;
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
            Random s=new Random();
            int i=s.nextInt(100)+20;
            g.drawImage(image, 0, 0, i, i, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
