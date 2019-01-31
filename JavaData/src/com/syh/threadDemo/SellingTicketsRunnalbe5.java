
/*
* 功能：卖票系统
*3个售票窗口共卖2000张票
*
* 线程并发造成的线程安全：
* 解决问题的关键是要保证容易出问题的代码的原子性，
* 原子性：
* 当a线程在执行某段代码的时候，别的线程必须等到a线程执行完后，它才能执行这段代码
*
* Java线程同步-解决方法：
* 只需要在同步的代码段用synchronized(Object){ 你要同步的代码 }即可
*
* 同步机制的解释：
* Java任意类型的对象都有一个标志位（对象锁/文件锁），该标志位具有0、1两种状态，其开始状态为1，当某个线程执行了
* synchronized (Object)语句后，object对象的标志位变为0的状态，直到执行完整个synchronized
* 语句中的代码块后，该对象的标志位又回到1状态。
*
*
* 当一个线程执行到synchronized (Object)语句的时候，先检查object对象的标志位，如果为
* 0状态，表明已经有另外的线程正在执行synchronized包括的代码，那么这个线程将暂时阻塞，
* 让出cpu资源，直到另外的线程执行完相关的同步代码，并将object对象的标志位变为1状态，
* 这个线程的阻塞就被取消，线程能继续运行，该线程有将object的标志位变为0状态，防止
* 其他的线程再进入相关的同步代码块中。
*
*
* */

package com.syh.threadDemo;

public class SellingTicketsRunnalbe5 {
    public static void main(String[] args) {

//        定义三个售票窗口
        TicketWindow tw1 = new TicketWindow();
//        TicketWindow tw2 = new TicketWindow();
//        TicketWindow tw3 = new TicketWindow();

        Thread t1 = new Thread(tw1);
        Thread t2 = new Thread(tw1);
        Thread t3 = new Thread(tw1);

        t1.start();
        t2.start();
        t3.start();

    }


}


// 售票窗口类
class TicketWindow implements Runnable
{
//    一共2000张票
    private int num = 2000;


    @Override
    public void run() {
        while (true)
        {

//            认为if else要保证其原子性[同步代码块]，this为对象锁，代表对象本身

            synchronized (this)
            {
                //            先判断是否还有票
                if(num > 0)
                {
//                显示售票信息
//                Thread.currentThread().getName()，得到当前线程的名字
                    System.out.println(Thread.currentThread().getName()+"正在售出第 "+num+" 张票");
                    //            出票速度是1秒出一种
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    num--;
                }else {
//                售票结束
                    break;
                }
            }

        }
    }
}

