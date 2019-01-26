/*
* 功能：事件监听
*
* 事件编程步骤：
* 1、编写事件处理类（事件监听者）
* 2、根据需求给事件处理类实现监听器接口
* 3、在事件处理类中重写其事件处理的函数
* 4、在事件源类中指定该事件的监听器（响应者）是谁，即注册监听
*
*Java事件处理机制  注意事项"
* 1、Java采用 委托机制 处理事件
* 2、Java中的事件是分类的，如对窗体事件，鼠标事件，按键事件，操作事件（按按钮）
* 3、Java中一个类要监听某个事件，则必须实现相应的事件监听接口
* 4、事件监听接口有多种，如监听鼠标事件当实现MouseListener、监听键盘事件当实现KeyListener
* 5、在实现监听接口的类（事件监听者/类）中，需要重写处理函数，如实现了ActionListener接口，
* 就应当重写actionPerformed(ActionEvent c).
* 6、在事件源中需 注册 事件监听类，否则事件监听类接收不到事件源发生的事件
* */

package com.syh.EventDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MonitorEvent3 extends JFrame{

    MyMonitorPanel mp = null;

    public static void main(String[] args) {
        MonitorEvent3 demo = new MonitorEvent3();
    }

    public MonitorEvent3()
    {
        mp = new MyMonitorPanel();

        this.add(mp);

//        注册监听
        this.addMouseListener(mp);
        this.addKeyListener(mp);
        this.addMouseMotionListener(mp);
        this.addWindowListener(mp);

        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }
}

// 1、让MyMonitorPanel 知道鼠标按下的消息，并知道点击的位置（x,y）
// 2、让MyMonitorPanel知道哪个键按下
// 3、让MyMonitorPanel知道鼠标移动，拖拽
// 4、让 知道窗口的变化，关闭，最小化，最大化

class MyMonitorPanel extends JPanel implements MouseListener, KeyListener, MouseMotionListener,WindowListener
{

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

//    鼠标点击
    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println("鼠标点击了"+"x="+e.getX()+"，y="+e.getY());
    }

//    鼠标移动到panel
    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("鼠标来了");

    }

//    鼠标离开panel
    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("鼠标离开");

    }

//    鼠标按下
    @Override
    public void mousePressed(MouseEvent e) {

    }

//    鼠标松开
    @Override
    public void mouseReleased(MouseEvent e) {

    }

//    鼠标拖拽
    @Override
    public void mouseDragged(MouseEvent e) {

    }
//   鼠标移动
    @Override
    public void mouseMoved(MouseEvent e) {
//        System.out.println("鼠标当前坐标"+"x="+e.getX());
    }

    //    键按下
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyChar()+"键被按下");
    }
//    键松开
    @Override
    public void keyReleased(KeyEvent e) {

    }

//    键输入字符
    @Override
    public void keyTyped(KeyEvent e) {

    }

//    窗口正在关闭
    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("窗口正在关闭");

    }

//    窗口关闭
    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("窗口关闭windowClosed");

    }

//    窗口失去活性时调用的方法
    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("窗口失去活性时调用的方法windowDeactivated");

    }

//   窗口激活了
    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("窗口激活了windowActivated");
    }

    //    窗口打开
    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("窗口打开windowOpened");

    }

//      窗口被最小化时调用的方法
    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("窗口windowIconified");

    }

//    窗口被从最小化还原时调用的方法
    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("窗口dd windowDeiconified");

    }
}