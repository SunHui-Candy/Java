
/*
*
* 功能：单独抽取出的坦克类
*
* */

package com.syh.MappingDemo;


// 子弹类
class Shot implements Runnable
{
    int x,y,direct;
    int speed = 1;

    public Shot(int x,int y,int direct){
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (true){

            try {
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
//                    向
                    x += speed;
                    break;
                case 2:
//                    向
                    y += speed;
                    break;
                case 3:
//                    向上
                    x -= speed;
                    break;

            }

            System.out.println("子弹坐标x="+x+"y="+y);
//            子弹何时死亡
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


// 敌人的坦克
class EnanyTanke2 extends Tanke2
{

    public EnanyTanke2(int x,int y)
    {
        super(x,y);
    }

}

//我的坦克
class Hero2 extends Tanke2 {

//    子弹
    Shot s = null;

    public Hero2(int x, int y) {
        super(x, y);

    }

//    坦克开火
    public void shotEneny(){
//        根据坦克的方向设置子弹的坐标
        switch (this.direct){
            case 0:
               s = new Shot(x+10,y,0);
               break;
            case 1:
                s = new Shot(x+30,y+10,1);
                break;
            case 2:
                s = new Shot(x+10,y+30,2);
                break;
            case 3:
                s = new Shot(x,y+10,3);
                break;
        }

//        启动子弹
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
