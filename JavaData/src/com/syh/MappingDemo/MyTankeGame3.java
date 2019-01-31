
/*
* 功能：
* 我的坦克可以发射子弹
*
* 1、让敌人的坦克也能够发射字段
* 2、当我方坦克击中敌人的坦克时，敌人的坦克就消失
* 3、让敌人的坦克也可以自由随机的上下左右移动
* 4、控制我方的坦克和敌人的坦克在规定范围移动
* */

package com.syh.MappingDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;


public class MyTankeGame3 extends JFrame {

    MyPanel3 mp = null;
    public static void main(String[] args) {
        MyTankeGame3 demo = new MyTankeGame3();
    }

    public MyTankeGame3()
    {
        mp = new MyPanel3();

        this.add(mp);

//        注册监听
        this.addKeyListener(mp);

//       启动mp线程
        Thread t = new Thread(mp);
        t.start();

        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);
    }
}

//我的面板
class MyPanel3 extends JPanel implements KeyListener,Runnable
{

    //    定义一个我的坦克
    Hero2 hero = null;
    //    定义集合，存放敌人的坦克
    Vector<EnanyTanke2> ets = new Vector<EnanyTanke2>();
    //    定义敌人坦克的数量
    int ecSize = 3;

    public MyPanel3()
    {
        hero = new Hero2(100,100);

//        初始化敌人的坦克
        for (int i = 0 ; i < ecSize; i++)
        {
//            创建一辆敌人的坦克对象
            EnanyTanke2 et = new EnanyTanke2((i+1)*50,0);
//            加入到集合中
            et.setColor(0);
//            敌人坦克的方向
            et.setDirect(2);
            ets.add(et);

        }

    }

    //    重写paint
    @Override
    public void paint(Graphics g) {
        super.paint(g);

//        定义了活动区域
        g.fillRect(0,0,400,300);
//        画出我的坦克
        this.drawTank2(hero.getX(),hero.getY(),g,this.hero.direct,1);

//        画出子弹
        if (hero.s != null && hero.s.isLive == true){
            g.draw3DRect(hero.s.x,hero.s.y,1,1,false);
        }


//        画出敌人的坦克
        for (int i = 0; i<ets.size();i++){
            this.drawTank2(ets.get(i).getX(),ets.get(i).getY(),g,ets.get(i).getDirect(),0);
        }

    }

    //    画出坦克的函数
    public void drawTank2(int x,int y,Graphics g,int direct,int type)
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
            case 1:
//                炮筒向右
//                1、画出上面矩形
                g.fill3DRect(x,y,30,5,false);

                //                2、画出下面矩形
                g.fill3DRect(x,y+15,30,5,false);

                //                3、画出中间的矩形
                g.fill3DRect(x+5,y+5,20,10,false);
//                4、画出圆形
                g.fillOval(x+10,y+5,10,10);
//                5、画出线
                g.drawLine(x+15,y+10,x+30,y+10);
                break;
            case 2:
//                向下
                //        1、画出左边的矩形
                g.fill3DRect(x,y,5,30,false);
//        2、画出右边的矩形
                g.fill3DRect(x+15,y,5,30,false);
//        3、画出中间矩形
                g.fill3DRect(x+5,y+5,10,20,false);
//        4、画出圆形
                g.fillOval(x+5,y+10,10,10);
//        5、画出线
                g.drawLine(x+10,y+15,x+10,y+30);
                break;
            case 3:
//                向左
//                1、画出上面矩形
                g.fill3DRect(x,y,30,5,false);

                //                2、画出下面矩形
                g.fill3DRect(x,y+15,30,5,false);

                //                3、画出中间的矩形
                g.fill3DRect(x+5,y+5,20,10,false);
//                4、画出圆形
                g.fillOval(x+10,y+5,10,10);
//                5、画出线
                g.drawLine(x+15,y+10,x,y+10);

                break;

        }


    }


    //    键按下处理，a-->左，s-->下，w-->上，d-->右
    @Override
    public void keyPressed(KeyEvent e) {

        System.out.println("按下了键"+e.getKeyCode());

        if (e.getKeyCode() == KeyEvent.VK_W){
//            设置我的坦克的方向
            this.hero.setDirect(0);
            this.hero.moveUp();
        }else if(e.getKeyCode() == KeyEvent.VK_D){
//            向右
            this.hero.setDirect(1);
            this.hero.moveRight();
        }else if(e.getKeyCode() == KeyEvent.VK_S){
//            向下
            this.hero.setDirect(2);
            this.hero.moveDown();
        }else if(e.getKeyCode() == KeyEvent.VK_A){
//            向左
            this.hero.setDirect(3);
            this.hero.moveLeft();
        }


        if(e.getKeyCode() == KeyEvent.VK_J){
//            玩家是否按j键
//            开火
            this.hero.shotEneny();
        }

//        必须重新绘制panel
        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void run() {
//        每隔100毫秒重绘字段
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            重绘
            this.repaint();
        }
    }
}



