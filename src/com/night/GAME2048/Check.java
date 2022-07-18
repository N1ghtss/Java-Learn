package com.night.GAME2048;

import java.awt.*;

//方格类
public class Check {
    public int value;

    Font font1 = new Font("宋体", Font.BOLD, 46);
    Font font2 = new Font("宋体", Font.BOLD, 40);
    Font font3 = new Font("宋体", Font.BOLD, 34);
    Font font4 = new Font("宋体", Font.BOLD, 28);
    Font font5 = new Font("宋体", Font.BOLD, 22);

    public Check() {
        value = 0;  //value为方格中的数字
    }

    //字体颜色
    public Color getFontGround() {
        switch (value) {
            case 0:
                return new Color(0xcdc1b4);
            case 2:
                
            case 4:
                return Color.BLACK;
            default:
                return Color.WHITE;
        }
    }

    public Color getBackground() {
        switch (value) {
            case 0:
                return new Color(0xCDC1B4);
            case 2:
                return new Color(0xeee4da);
            case 4:
                return new Color(0xede0c8);
            case 8:
                return new Color(0xf2b179);
            case 16:
                return new Color(0xf59563);
            case 32:
                return new Color(0xf67c5f);
            case 64:
                return new Color(0xf65e3b);
            case 128:
                return new Color(0xedcf72);
            case 256:
                return new Color(0xedcc61);
            case 512:
                return new Color(0xedc850);
            case 1024:
                return new Color(0xedc53f);
            case 2048:
                return new Color(0xedc22e);
            case 4096:
                return new Color(0x65da92);
            case 8192:
                return new Color(0x5abc65);
            case 16384:
                return new Color(0x248c51);
            default:
                return new Color(0x248c51);
        }
    }

    public Font getFont() {
        if (value < 10) {
            return font1;
        }
        if (value < 100) {
            return font2;
        }
        if (value < 1000) {
            return font3;
        }
        if (value < 10000) {
            return font4;
        }
        return font5;
    }

}
