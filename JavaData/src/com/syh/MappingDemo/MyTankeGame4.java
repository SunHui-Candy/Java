
/*
 * 功能：
 * 1、画出坦克
 * 2、我的坦克可以上下左右移动
 * 3、子弹可以连发，最多可以发5颗子弹
 * 4、当我方坦克击中敌人的坦克时，敌人的坦克就消失
 * 5、消失子弹的爆照效果
 * 思路：
 * a、定义了三张图片
 * b、定义Bomb炸弹类
 * c、在击中敌人坦克时，把炸弹放入向量
 * d、绘制出来
 *
 * 6、让敌人的坦克也能够发射字段
 * 7、让敌人的坦克也可以自由随机的上下左右移动
 * 8、控制我方的坦克和敌人的坦克在规定范围移动
 * 9、当敌人的坦克击中我的坦克时，我的坦克爆炸
 * 10、如何控制敌人的坦克不重叠运动
 * */

package com.syh.MappingDemo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;


public class MyTankeGame4 extends JFrame {

    MyPanel4 mp = null;
    public static void main(String[] args) {
        MyTankeGame4 demo = new MyTankeGame4();
    }

    public MyTankeGame4()
    {
        mp = new MyPanel4();

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
class MyPanel4 extends JPanel implements KeyListener,Runnable
{

    //    定义一个我的坦克
    Hero2 hero = null;
    //    定义集合，存放敌人的坦克
    Vector<EnanyTanke2> ets = new Vector<EnanyTanke2>();

//    定义炸弹集合
    Vector<Bomb> bombs = new Vector<Bomb>();

    //    定义敌人坦克的数量
    int ecSize = 3;

//    定义三张图片,三张图片才能组成一颗炸弹
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;


    public MyPanel4()
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

//            启动敌人的坦克
            Thread t = new Thread(et);
            t.start();

//            给敌人的坦克添加一颗子弹
            Shot s = new Shot(et.getX() + 10,et.getY() + 30,2);
//            子弹加入给敌人坦克
            et.ss.add(s);

            Thread t2 = new Thread(s);
            t2.start();

//            加入
            ets.add(et);
        }


        try {
            image1 = ImageIO.read(new File("src/com/syh/images/tanke1.png"));
            image2 = ImageIO.read(new File("src/com/syh/images/tanke2.png"));
            image3 = ImageIO.read(new File("src/com/syh/images/tanke3.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

//        初始化图片
//        image1 = Toolkit.getDefaultToolkit().getImage("src/com/syh/images/tanke1.png");
//        image2 = Toolkit.getDefaultToolkit().getImage("src/com/syh/images/tanke2.png");
//        image3 = Toolkit.getDefaultToolkit().getImage("src/com/syh/images/tanke3.png");


    }

    //    重写paint
    @Override
    public void paint(Graphics g) {
        super.paint(g);

//        定义了活动区域
        g.fillRect(0,0,400,300);



        if (hero.isLive){
            //        画出我的坦克
            this.drawTank2(hero.getX(),hero.getY(),g,this.hero.direct,1);
        }



//        从ss中取出每科子弹
        for (int i = 0; i < hero.ss.size(); i++){
//            取出一颗子弹
            Shot myShot = hero.ss.get(i);

            //        画出一颗子弹
            if (myShot != null && myShot.isLive == true){
                g.draw3DRect(myShot.x,myShot.y,1,1,false);
            }

            if (myShot.isLive == false){
//                从ss中删除掉该子弹
                hero.ss.remove(myShot);
            }
        }


//       画出炸弹
        for (int i = 0; i < bombs.size(); i++)
        {
//            取出炸弹
            Bomb b = bombs.get(i);

            if (b.life > 6)
            {
                g.drawImage(image1,b.x,b.y,30,30,this);
            }else if(b.life > 3){
                g.drawImage(image2,b.x,b.y,30,30,this);
            }else {
                g.drawImage(image3,b.x,b.y,30,30,this);
            }
//            让b的生命值减小
            b.lifeDown();

//            如果炸弹生命值为0，就把该炸弹从bombs向量去掉
            if (b.life == 0)
            {
                bombs.remove(b);
            }

        }

//        画出敌人的坦克
        for (int i = 0; i<ets.size();i++){
            EnanyTanke2 et = ets.get(i);
            if (et.isLive)
            {
                this.drawTank2(et.getX(),et.getY(),g,et.getDirect(),0);
//                画出敌人的子弹
                for (int j = 0; j < et.ss.size();j++)
                {
//                    取出子弹
                    Shot enanyShot = et.ss.get(j);
                    if (enanyShot.isLive)
                    {
                       System.out.println("第"+i+"颗子弹的坐标x= "+enanyShot.x+"y=" +enanyShot.y);
//                        画出子弹
                        g.draw3DRect(enanyShot.x,enanyShot.y,1,1,false);

                    }else {
//                        如果敌人的坦克死亡了，就从Vector中去掉
                        et.ss.remove(enanyShot);
                    }
                }
            }

        }

    }


//    我的子弹是否击中敌人
    public void hitMe()
    {
//        取出每一个敌人的坦克
        for (int i =0; i<this.ets.size();i++)
        {
//            取出坦克
            EnanyTanke2 et = ets.get(i);
//            取出每一颗子弹
            for (int j = 0; j < et.ss.size(); j++)
            {
//                取出子弹
                Shot enanyShot = et.ss.get(j);
                this.hitTank(enanyShot,hero);

            }
        }
    }

//    判断我的子弹是否击中敌人的坦克
    public void hitEnanyTank()
    {
        //            判断子弹是否击中敌人的坦克
        for (int i = 0; i< hero.ss.size(); i++)
        {
//                取出子弹
            Shot myShot = hero.ss.get(i);
//                判断子弹是否有效
            if (myShot.isLive)
            {
//                    取出每个坦克，与子弹判断
                for (int j = 0; j < ets.size(); j++)
                {
//                        取出坦克
                    EnanyTanke2 et = ets.get(j);
                    if (et.isLive)
                    {
                        this.hitTank(myShot,et);
                    }
                }
            }

        }
    }

//    写一个函数，判断子弹是否击中敌人坦克
    public void hitTank(Shot s,Tanke2 et)
    {
//        判断该坦克的方向
        switch (et.direct)
        {
//            如何敌人坦克的方向是上或下
            case 0:
            case 2:
                if (s.x > et.x && s.x < et.x + 20 && s.y > et.y && s.y < et.y + 30)
                {
//                    击中,子弹死亡，敌人的坦克死亡
                    s.isLive = false;
                    et.isLive = false;

//                    创建一颗炸弹，放入Vector
                    Bomb b = new Bomb(et.getX(),et.getY());
//                    放入Vector
                    bombs.add(b);


                }
            case 1:
            case 3:
                if (s.x > et.x && s.x < et.x + 30 && s.y > et.y && s.y < et.y + 20)
                {
//                    击中
                    s.isLive = false;
                    et.isLive = false;

//                    创建一颗炸弹，放入Vector
                    Bomb b = new Bomb(et.getX(),et.getY());
//                    放入Vector
                    bombs.add(b);

                }

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

//            最多发5颗子弹
            if (this.hero.ss.size() < 5){
                //            开火
                this.hero.shotEneny();
            }

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
//        每隔100毫秒重绘子弹
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



            this.hitEnanyTank();

//            判断敌人的字段是否击中我了
            this.hitMe();

//            重绘
            this.repaint();
        }
    }
}




