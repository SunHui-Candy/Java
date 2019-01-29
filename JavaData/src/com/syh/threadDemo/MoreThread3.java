/*
* 功能：两个线程同时运行的案例
*
*
* */

package com.syh.threadDemo;

public class MoreThread3 {
    public static void main(String[] args) {
       Pig pig = new Pig(10);

       Bird bird = new Bird(10);

       Thread t1 = new Thread(pig);

       Thread t2 = new Thread(bird);

       t1.start();
       t2.start();
    }


}

//打印
class Pig implements Runnable
{
    int n = 0;
    int times = 0;

    public Pig(int n)
    {
        this.n = n;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            times++;
            System.out.println("我是一个线程，正在输入第 "+ times + "helloWord");
            if (times == n){
                break;
            }
        }
    }
}
// 算术题
class Bird implements Runnable
{
    int n = 0;
    int res = 0;
    int times = 0;
    public Bird(int n)
    {
        this.n = n;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);

            }catch (Exception e){

            }

            res += (++times);
            System.out.println("当前结果是："+res);
            if (times == n){
                System.out.println("最后结果是："+res);
                break;
            }

        }
    }
}

