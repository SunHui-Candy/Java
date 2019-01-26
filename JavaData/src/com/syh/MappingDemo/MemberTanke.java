
/*
*
* 功能：单独抽取出的坦克类
*
* */

package com.syh.MappingDemo;

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

    public Hero2(int x, int y) {
        super(x, y);
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
