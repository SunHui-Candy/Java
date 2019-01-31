
/*
*
* 功能：单独抽取出的坦克类
*
* 如果一个类的坐标是变化的，可以考虑做为一个线程
*
* */

package com.syh.MappingDemo;


import java.util.Vector;

// 炸弹类
class Bomb
{
//    定义炸弹类的坐标
    int x,y;

//    炸弹的生命
    int life = 9;
    boolean isLive = true;

    public Bomb(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

//    减少生命值
    public void lifeDown()
    {
        if (life > 0)
        {
            life--;
        }else {
            this.isLive = false;
        }
    }



}

// 子弹类
class Shot implements Runnable
{
    int x,y,direct;
    int speed = 5;
//    是否还活着
    boolean isLive = true;

    public Shot(int x,int y,int direct){
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (true){

            try {
//                休息50毫秒
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (direct){
                case 0:
//                    向上
                    y -= speed;
                    break;
                case 1:
//                    向右
                    x += speed;
                    break;
                case 2:
//                    向下
                    y += speed;
                    break;
                case 3:
//                    向左
                    x -= speed;
                    break;

            }

            //System.out.println("子弹坐标x="+x+" y="+y);
//            子弹何时死亡

//            判断该子弹是否碰到边缘
            if (x < 0 || x > 400 || y < 0 || y > 300){
                this.isLive = false;

                break;
            }

        }
    }
}

//坦克类
class Tanke2
{

    //    坦克的横坐标
    int x = 0;
    //    纵坐标
    int y = 0;
    //    坦克方向 0-->上，1-->右，2-->下，3-->左
    int direct = 0;

    //    坦克的速度
    int speed = 10;

    boolean isLive = true;

// 颜色
    int color;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

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



    public Tanke2(int x,int y)
    {
        this.x = x;
        this.y = y;
    }

}


// 敌人的坦克，把敌人的坦克做成线程类
class EnanyTanke2 extends Tanke2 implements Runnable
{

    int times = 0;

//    定义一个向量，可以存放敌人的子弹
    Vector<Shot> ss = new Vector<Shot>();

//    敌人添加子弹，应当在刚刚创建坦克和敌人的坦克子弹死亡过后



    public EnanyTanke2(int x,int y)
    {
        super(x,y);
    }

    @Override
    public void run() {
        while (true)
        {


            switch (this.direct)
            {
                case 0:
//                    说明坦克正在向上移动

                    for (int i = 0; i < 30; i++)
                    {
//                        保证坦克不出边界
                        if (y > 0)
                        {
                            y -= speed;
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    break;
                case 1:
//                    向右
                    for (int i = 0; i < 30; i++)
                    {
                        if (x < 400-30)
                        {
                            x += speed;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;

                case 2:
//                    向下
                    for (int i = 0; i < 30; i++)
                    {
                        if (y < 300 - 30)
                        {
                            y += speed;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
//                    向左
                    for (int i = 0; i < 30; i++)
                    {
                        if (x > 0)
                        {
                            x -= speed;
                        }

                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;

            }

            this.times++;
            if (times%2 == 0)
            {
                if (isLive)
                {
                    //            判断是否需要给坦克加入新的子弹
                    if (ss.size() < 5)
                    {
//                        没有子弹
                        Shot s = null;
//                        添加
                        switch (direct)
                        {
                            case 0:
//                创建一颗子弹
                                s = new Shot(x+10,y,0);
//               把子弹加入向量
                                ss.add(s);
                                break;
                            case 1:
                                s = new Shot(x+30,y+10,1);
                                ss.add(s);
                                break;
                            case 2:
                                s = new Shot(x+10,y+30,2);
                                ss.add(s);
                                break;
                            case 3:
                                s = new Shot(x,y+10,3);
                                ss.add(s);
                                break;
                        }

//                        启动子弹线程
                        Thread t = new Thread(s);
                        t.start();

                    }
                }
            }



//            让坦克随机产生一个新的方向
            this.direct = (int)(Math.random()*4);

//            判断敌人塔克是否死亡
            if (this.isLive == false)
            {
//                让坦克死亡后，退出线程
                break;
            }



        }
    }
}

//我的坦克
class Hero2 extends Tanke2 {

//    子弹
    Shot s = null;
//    定义存放子弹的集合
    Vector<Shot> ss = new Vector<Shot>();


    public Hero2(int x, int y) {
        super(x, y);

    }

//    坦克开火
    public void shotEneny(){
//        根据坦克的方向设置子弹的坐标
        switch (this.direct){
            case 0:
//                创建一颗子弹
               s = new Shot(x+10,y,0);
//               把子弹加入向量
               ss.add(s);
               break;
            case 1:
                s = new Shot(x+30,y+10,1);
                ss.add(s);
                break;
            case 2:
                s = new Shot(x+10,y+30,2);
                ss.add(s);
                break;
            case 3:
                s = new Shot(x,y+10,3);
                ss.add(s);
                break;
        }

//        启动子弹线程
        Thread t = new Thread(s);
        t.start();
    }

    //    坦克向上移动
    public void moveUp() {
        y -= speed;
    }

    //    坦克向右移动
    public void moveRight() {
        x += speed;
    }


    //    坦克向下移动
    public void moveDown() {
        y += speed;
    }


    //    坦克向左移动
    public void moveLeft() {
        x -= speed;
    }
}
