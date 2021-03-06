/*
* 功能：坦克游戏的1.0版
* 1、画出坦克
*
* */

package com.syh.MappingDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.font.TextHitInfo;


public class MyTankeGame1 extends JFrame {

    MyPanel1 mp = null;
    public static void main(String[] args) {
        MyTankeGame1 demo = new MyTankeGame1();
    }

    public MyTankeGame1()
    {
        mp = new MyPanel1();

        this.add(mp);

        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
}

//我的面板
class MyPanel1 extends JPanel
{

//    定义一个我的坦克
    Hero1 hero = null;
    public MyPanel1()
    {
        hero = new Hero1(10,10);

    }

//    重写paint
    @Override
    public void paint(Graphics g) {
        super.paint(g);

//        定义了活动区域
        g.fillRect(0,0,400,300);
//        画出我的坦克
        this.drawTank(hero.getX(),hero.getY(),g,0,0);

    }

//    画出坦克的函数
   public void drawTank(int x,int y,Graphics g,int direct,int type)
   {
//       判断是什么类型的坦克
        switch (type)
        {
            //        设置坦克的颜色
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }
    
//        判断方向
       switch (direct){
           case 0:
//        1、画出左边的矩形
               g.fill3DRect(x,y,5,30,false);
//        2、画出右边的矩形
               g.fill3DRect(x+15,y,5,30,false);
//        3、画出中间矩形
               g.fill3DRect(x+5,y+5,10,20,false);
//        4、画出圆形
               g.fillOval(x+5,y+10,10,10);
//        5、画出线
               g.drawLine(x+10,y+15,x+10,y);
               break;
       }
        
        
   }


}


//坦克类
class Tanke1
{

    //    坦克的横坐标
    int x = 0;
    //    纵坐标
    int y = 0;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    public Tanke1(int x,int y)
    {
        this.x = x;
        this.y = y;
    }

}

//我的坦克
class Hero1 extends Tanke1
{
    public Hero1(int x,int y)
    {
        super(x, y);
    }
}