
/*
* 功能：另一种方式实现Thread1的案例
*
*
* */

package com.syh.threadDemo;

public class Runalbe2 {

    public static void main(String[] args) {
        Dog dog = new Dog();
//        注意启动，先创建一个Thread对象
        Thread t = new Thread(dog);
        t.start();

    }
}

class Dog implements Runnable
{

    int times = 0;
    @Override
    public void run() {
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
