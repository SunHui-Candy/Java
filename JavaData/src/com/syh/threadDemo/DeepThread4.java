/*
* 功能：演示使用线程的注意事项
*
* 1、一个对象，只能启动一次，即start()一次
* 2、
* */

package com.syh.threadDemo;

public class DeepThread4 {

    public static void main(String[] args) {

        Cat4 cat1 = new Cat4();
        cat1.start();

        Dog4 dog1 = new Dog4();
        Thread t = new Thread(dog1);
        t.start();

    }


}


// 猫类
class Cat4 extends Thread
{
    @Override
    public void run() {
        super.run();

        System.out.println("11");
    }
}

class Dog4 implements Runnable
{
    @Override
    public void run() {
        System.out.println("22");
    }
}