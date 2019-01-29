
/*
* 功能：演示如何通过继承Thread来开发线程
*
* 每隔一秒，输出"hello word"
*
* 使用线程
* 一个类要当作线程来使用的两种方法
* 1、继承Thread类，并重写run 函数
* 2、实现Runnable接口，并重写run 函数
*
*
* */


package com.syh.threadDemo;

public class Thread1 {

    public static void main(String[] args) {

//        创建一个cat对象
        Cat cat = new Cat();

//        启动线程，会导致run函数的运行
        cat.start();



    }

}


class Cat extends Thread
{

    int times = 0;
//    重写run函数

    @Override
    public void run() {
        super.run();
        while (true){
//            休眠一秒
//            1000表示1000毫秒，sleep会让线程进入到Blocked阻塞状态，并释放资源
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            times++;
            System.out.println("hello world"+times);

            if (times == 10 ){
//                退出
                break;
            }
        }
    }
}
