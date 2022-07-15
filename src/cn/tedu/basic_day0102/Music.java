package cn.tedu.basic_day0102;

import javazoom.jl.player.Player;

import java.io.FileInputStream;

public class Music extends Thread {

    public void run() {
        try {
            FileInputStream file = new FileInputStream("Music\\洋艺洋 - 就是爱你 (原唱_ 陶喆) (clip).mp3");
            Player player = new Player(file);
            player.play();
        } catch (Exception e) {

        }
    }

}
