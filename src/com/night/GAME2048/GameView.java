package com.night.GAME2048;

import javax.swing.*;

public class GameView {
    private static final int jframeWidth = 405;
    private static final int jframeHeight = 530;
    private JFrame jFrameMain;
    private JLabel JTitle;
    private JLabel JScoreName;
    private JLabel JTips;

    public GameView() {
        init();
    }
    public void showView(){
        jFrameMain.setVisible(true);
    }

    public void init() {
        //1.创建窗口
        jFrameMain = new JFrame("2048小游戏");
        jFrameMain.setSize(jframeWidth, jframeHeight);
        jFrameMain.setLocationRelativeTo(null);//居中
        jFrameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口时，退出程序
        jFrameMain.setResizable(false);//不能任意改变窗口的大小
        jFrameMain.setLayout(null);//设置绝对布局，以便后面可以使用setBounds设置位置
    }
}
