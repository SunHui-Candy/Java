/*
* 功能：Java绘图原理
*
* 绘图原理说明：
* Component 类提供了两个和绘图相关最重要的方法，
* 1、paint(Graphics g)绘制组件的外观
* 2、repaint()刷新组件的外观
* 当组件第一次在屏幕显示的时候，程序会自动的调用paint()方法来绘制组件。
*
* paint()方法调用时机：
* 1、窗口最小化，再最大化
* 2、窗口的大小发生变化
* 3、repaint函数被调用
* 4、组件第一次在屏幕上显示的时候
*
*
 * 像素介绍：
 * 计算机在屏幕上显示的内容都是由屏幕上的每一个像素组成的，例如
 * 计算机显示器的分辨率是800x600，表示计算机屏幕上的每一行由
 * 800个点组成，共有600行，整个计算机屏幕共有48000个像素，
 * 屏幕上可以显示更多的像素。
 *
 * 像素是一个密度单位
* */

package com.syh.MappingDemo;

import javax.swing.*;
import java.awt.*;

public class Mapping1 extends JFrame{

    MyMappingPanel mp = null;
    public static void main(String[] args) {
        Mapping1 demo = new  Mapping1();

    }

    public Mapping1()
    {
        mp = new MyMappingPanel();

        this.add(mp);

        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }
}

//定义一个继承Jpanel的MyPanel（自己的面板），用于绘图和显示绘图的区域
class MyMappingPanel extends JPanel
{
//    覆盖JPanel 的 paint 方法
//   Graphics 是绘图的重要类，可以理解成一支笔
    @Override
    public void paint(Graphics g) {
//        1、调用父类函数，完成初始化,不能少
        super.paint(g);

//        System.out.println("paint被调用");
//        先画一个圆
        g.drawOval(10,10,30,30);
//        画直线
        g.drawLine(50,30,40,40);
//        画矩形边框
        g.drawRect(30,80,40,60);
//        设置颜色
        g.setColor(Color.red);
        //       画填充矩形
        g.fillRect(100,80,40,50);

//        画图片
        Image im = Toolkit.getDefaultToolkit().getImage("src/com/syh/images/mapping1.jpg");

//        Toolkit kit = Toolkit.getDefaultToolkit();
//        Image im = kit.getImage("src/com/syh/images/mapping1.jpg");

        //        显示出来
        g.drawImage(im,150,20,180,220,this);

//        如何划出字
        g.setColor(Color.red);
        g.setFont(new Font("华文彩云",Font.BOLD,50));
        g.drawString("慧慧",40,240);


//        弧形
        g.drawArc(110,250,120,300,50,100);

    }
}