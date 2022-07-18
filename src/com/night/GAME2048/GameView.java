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

    private JFrame jFrameMain;  //主框架定义名字
    private JLabel JTitle;  //窗口在最上面显示
    private JLabel JScoreName;
    private JLabel Jscore;
    private JLabel JTips;
    private GameBoard gameBoard;

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

        //5.游戏面板
        gameBoard = new GameBoard();
        gameBoard.setBounds(0, 100, 400, 400);
        gameBoard.setBackground(Color.GRAY);
        gameBoard.setFocusable(true);   //  焦点即当前正在操作的组件，也就是移动的数字
        gameBoard.setLayout(new FlowLayout());
        jFrameMain.add(gameBoard);
    }

    //游戏面板需要对键值实现监听
    //内部类继承JPanel类，实现接口监听KeyListener中的KeyPressed方法
    class GameBoard extends JPanel implements KeyListener {

        private static final int CHECK_GAP = 10;    //  方格之间的间隙
        private static final int CHECK_SIZE = 85;   //  方格的大小
        private static final int CHECK_ARC = 20;    //  方格的弧度

        private Check[][] checks = new Check[4][4];
        private boolean isadd = true;

        public GameBoard() {
            initGame();
            addKeyListener(this);
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

        //  获取空白方格
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
        public void paint(Graphics g) {
            super.paint(g);
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dramCheck(g, i, j);
                }
            }
            if (GameOver()) {
                g.setColor(new Color(64, 64, 64, 150));
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.WHITE);
                g.setFont(topicFont);
                FontMetrics fms = getFontMetrics(topicFont);
                String value = "Game Over!";
                g.drawString(value,
                        (getWidth() - fms.stringWidth(value)) / 2,
                        getHeight() / 2);
            }
        }

        //绘制方格
        //Graphics2D 类拓展了Graphics类
        //提供了对几何形状、坐标转换、颜色管理和文本布局更为复杂的控制
        private void dramCheck(Graphics g, int i, int j) {
            Graphics2D g1 = (Graphics2D) g;
            //是图形去除锯齿状，可以得到细腻的图形
            g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g1.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
            Check check = checks[i][j];
            g1.setColor(check.getBackground());
            //绘制圆角
            //  x - 要填充矩形的X坐标
            //  y - 要填充矩形的Y坐标
            // width - 要填充矩形的宽度
            // height - 要填充矩形的高度
            // ARC-width -- 4个角弧度的水平直径
            // ARC-height -- 4个角弧度的垂直直径
            g1.fillRoundRect(CHECK_GAP + (CHECK_GAP + CHECK_SIZE) * j, CHECK_GAP + (CHECK_GAP + CHECK_SIZE) * i, CHECK_SIZE, CHECK_SIZE, CHECK_ARC, CHECK_ARC);
            g1.setColor(check.getFontGround());
            g1.setFont(check.getFont());

            //  对文字的长宽高测量
            FontMetrics fms = getFontMetrics(check.getFont());
            String value = String.valueOf(check.value);

            // 使用此图形上下文的当前颜色绘制由指定迭代器给定的文本
            // getAscent() -- 它返回某字体的基线(baseline)到该字体中大多数字符的升部之间的距离
            // getDescent() -- 为降部
            g1.drawString(value,
                    CHECK_GAP + (CHECK_GAP + CHECK_SIZE) * j +
                            (CHECK_SIZE - fms.stringWidth(value)) / 2,
                    CHECK_GAP + (CHECK_GAP + CHECK_SIZE) * i +
                            (CHECK_SIZE - fms.getAscent() - fms.getDescent()) / 2 + fms.getAscent());
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_ESCAPE:
                    initGame();
                    break;
                case KeyEvent.VK_LEFT:
                    moveLeft();
                    createCheck();
                    GameOver();
                    break;
                case KeyEvent.VK_RIGHT:
                    moveRight();
                    createCheck();
                    GameOver();
                    break;
                case KeyEvent.VK_UP:
                    moveUp();
                    createCheck();
                    GameOver();
                    break;
                case KeyEvent.VK_DOWN:
                    moveDown();
                    createCheck();
                    GameOver();
                    break;
                default:
                    break;
            }
            repaint();//刷新，会自动调用paint（）方法，重新绘制移动后的图
        }

        public boolean GameOver() {
            Jscore.setText(score + "");
            if (!getEmptyChecks().isEmpty()) {
                return false;
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (checks[i][j].value == checks[i][j + 1].value || checks[i][j].value == checks[i + 1][j].value) {
                        return false;
                    }
                }
            }
            return true;
        }

        /**
         * 重难点 -- 数字移动 -- 以moveLeft()为例
         * 1） 按左键，若最左边是相同的，则合并
         * 2） 若左边是空格，则直接移动到最左即可
         * 3） 若最最左边不为空格且不相等，则看它右边是否由空格，是则移动到其旁边
         */

        private boolean moveLeft() {
            for (int i = 0; i < 4; i++) {
                for (int j = 1, index = 0; j < 4; j++) {
                    if (checks[i][j].value > 0) {
                        if (checks[i][j].value == checks[i][index].value) {
                            score += checks[i][index++].value *= 2;
                            checks[i][j].value = 0;
                            isadd = true;
                        } else if (checks[i][index].value == 0) {
                            checks[i][index].value = checks[i][j].value;
                            checks[i][j].value = 0;
                            isadd = true;
                        } else if (checks[i][++index].value == 0) {
                            checks[i][index].value = checks[i][j].value;
                            checks[i][j].value = 0;
                            isadd = true;
                        }
                    }
                }
            }
            return isadd;
        }

        private boolean moveRight() {
            for (int i = 0; i < 4; i++) {
                for (int j = 2, index = 3; j >= 0; j--) {
                    if (checks[i][j].value > 0) {
                        if (checks[i][j].value == checks[i][index].value) {
                            score += checks[i][index].value *= 2;
                            checks[i][j].value = 0;
                            isadd = true;
                        } else if (checks[i][index].value == 0) {
                            checks[i][index].value = checks[i][j].value;
                            checks[i][j].value = 0;
                            isadd = true;
                        } else if (checks[i][--index].value == 0) {
                            checks[i][index].value = checks[i][j].value;
                            checks[i][j].value = 0;
                            isadd = true;
                        }
                    }
                }
            }
            return isadd;
        }

        private boolean moveDown() {
            for (int i = 0; i < 4; i++) {
                for (int j = 2, index = 3; j >= 0; j--) {
                    if (checks[j][i].value > 0) {
                        if (checks[j][i].value == checks[index][i].value) {
                            score += checks[index][i].value *= 2;
                            checks[j][i].value = 0;
                            isadd = true;
                        } else if (checks[index][i].value == 0) {
                            checks[index][i].value = checks[j][i].value;
                            checks[j][i].value = 0;
                            isadd = true;
                        } else if (checks[--index][i].value == 0) {
                            checks[index][i].value = checks[j][i].value;
                            checks[j][i].value = 0;
                            isadd = true;
                        }
                    }
                }
            }
            return isadd;
        }

        private boolean moveUp() {
            for (int i = 0; i < 4; i++) {
                for (int j = 1, index = 0; j < 4; j++) {
                    if (checks[j][i].value > 0) {
                        if (checks[j][i].value == checks[index][i].value) {
                            score += checks[index][i].value *= 2;
                            checks[j][i].value = 0;
                            isadd = true;
                        } else if (checks[index][i].value == 0) {
                            checks[index][i].value = checks[j][i].value;
                            checks[j][i].value = 0;
                            isadd = true;
                        } else if (checks[++index][i].value == 0) {
                            checks[index][i].value = checks[j][i].value;
                            checks[j][i].value = 0;
                            isadd = true;
                        }
                    }
                }
            }
            return isadd;
        }


        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}

