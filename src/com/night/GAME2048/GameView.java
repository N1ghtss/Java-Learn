package com.night.GAME2048;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameView {
    private static final int jframeWidth = 405;
    private static final int jframeHeight = 530;
    private static int score = 0;

    Font topicFont = new Font("微软雅黑", Font.BOLD, 50);
    Font scoreFont = new Font("微软雅黑", Font.BOLD, 28);
    Font explainFont = new Font("宋体", Font.PLAIN, 20); //PLAIN-正常字体

    private JFrame jFrameMain;
    private JLabel JTitle;
    private JLabel JScoreName;
    private JLabel Jscore;
    private JLabel JTips;

    public GameView() {
        init();
    }

    public void showView() {
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
        JTitle = new JLabel("2048", JLabel.CENTER);
        JTitle.setFont(topicFont);
        JTitle.setForeground(Color.BLACK);
        JTitle.setBounds(50, 0, 150, 60);
        jFrameMain.add(JTitle);

        //2.把内容添加到窗口
        //设置字体及其颜色，位置
        JScoreName = new JLabel("得分", JLabel.CENTER);
        JScoreName.setFont(scoreFont);
        JScoreName.setForeground(Color.WHITE);
        JScoreName.setOpaque(true);//显示组件中的每个像素（正常显示）
        JScoreName.setBackground(Color.GRAY);
        JScoreName.setBounds(250, 0, 120, 30);
        jFrameMain.add(JScoreName);

        //3.得分
        Jscore = new JLabel("0", JLabel.CENTER);
        Jscore.setFont(scoreFont);
        Jscore.setForeground(Color.WHITE);
        Jscore.setOpaque(true);//显示组件中的每个像素（正常显示）
        Jscore.setBackground(Color.GRAY);
        Jscore.setBounds(250, 30, 120, 30);
        jFrameMain.add(Jscore);

        //4.显示说明
        JTips = new JLabel("操作：↑ ↓ ← →，按Esc键重新开始", JLabel.CENTER);
        JTips.setFont(explainFont);
        JTips.setForeground(Color.DARK_GRAY);
        JTips.setBounds(0, 60, 400, 40);
        jFrameMain.add(JTips);

        //游戏面板需要对键值实现监听
        //内部类继承JPanel类，实现接口监听KeyListener中的KeyPressed方法
        class GameBoard extends JPanel implements KeyListener {

            private static final int CHECK_GAP = 10;    //  方格之间的间隙
            private static final int CHECK_SIZE = 85;   //  方格的大小
            private static final int CHECK_ARC = 20;    //  方格的弧度

            private Check[][] checks = new Check[4][4];
            private boolean isadd = true;

            public GameBoard() {

            }

            private void initGame() {
                score = 0;
                for (int Row = 0; Row < 4; Row++) {
                    for (int Col = 0; Col < 4; Col++) {
                        checks[Row][Col] = new Check();
                    }
                }
                //  生成两个数
                isadd = true;
                createCheck();
            }

            private void createCheck() {
                List<Check> list = getEmptyChecks();
                if (!list.isEmpty() && isadd) {
                    Random random = new Random();
                    int index = random.nextInt(list.size());
                    Check check = list.get(index);
                    check.value = (random.nextInt(4) % 3 == 0) ? 2 : 4;
                }
            }

            private List<Check> getEmptyChecks() {
                List<Check> list = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (checks[i][j].value == 0) {
                            list.add(checks[i][j]);
                        }
                    }
                }
                return list;
            }

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        }

    }
}
