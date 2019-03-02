
/*
* 功能：加深对事件处理机制的理解
* 1、通过上下左右键，来控制一个小球的位置
*
* 111111111111111111111LN测试创建分支
*
*
* 测试打标签1，发现UBG后，在标签1上改好BUG发布版本
* */

package com.syh.EventDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.TextHitInfo;

public class BallEvent2 extends JFrame {

    MyEventPanel mp = null;
    public static void main(String[] args) {
        BallEvent2 demo = new BallEvent2();
    }

    public BallEvent2()
    {
        mp = new MyEventPanel();

//        加入到JFrame
        this.add(mp);

//        监听事件
        this.addKeyListener(mp);

        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
}

//定义自己的面板
class MyEventPanel extends JPanel implements KeyListener
{
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,10,10);
    }

//    某一个键被按下
    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println("键被按下"+e.getKeyChar());
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            y+=10;
        }else if(e.getKeyCode() == KeyEvent.VK_UP){
            y-=10;
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            x-=10;
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            x+=10;
        }

//        调用repaint()函数，来重绘界面
        this.repaint();

    }

//    键被松开
    @Override
    public void keyReleased(KeyEvent e) {

    }

//    键的一个值被输出
    @Override
    public void keyTyped(KeyEvent e) {

    }
}
