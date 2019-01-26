
/*
* 功能：Java的时间处理机制
*
* java事件处理是采取"委派事件模型"，所谓"委派事件模型"是指
* 当事件发生时，产生事件的对象（即事件源），会把此"信息"传递给
* "事件的监听者"处理的一种方式。
* "信息"实际就是java.awt.event 事件类库里某个类所创建的对象，称为"事件的对象"。
*
* 一个类实现监听的步骤：
* 1、实现相应的接口（ActionListener）
* 2、把接口的处理方法根据需要重写
* 3、事件源上注册监听
* 4、时间传递是靠事件对象（ActionEvent对象）
*
*
* */
package com.syh.EventDemo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Event1 extends JFrame implements ActionListener {

    JPanel mp = null;
    JButton jb1,jb2;

    public static void main(String[] args) {

        Event1 demo = new Event1();
    }

    public Event1()
    {
        mp = new JPanel();
        jb1 = new JButton("黑色");
        jb2 = new JButton("红色");

        this.add(jb1, BorderLayout.NORTH);
        mp.setBackground(Color.black);
        this.add(mp);
        this.add(jb2,BorderLayout.SOUTH);

        Cat myCat1 = new Cat();
//        事件源对象是jb1，事件监听对象是myCat1
        jb1.addActionListener(myCat1);

//        注册监听
        jb1.addActionListener(this::actionPerformed);
        jb1.setActionCommand("黑色");
        jb2.addActionListener(this::actionPerformed);
        jb2.setActionCommand("红色");




        this.setSize(200,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }

//   对事件处理的方法
    @Override
    public void actionPerformed(ActionEvent e) {


//        判断哪个按钮被点击
        if (e.getActionCommand().equals("黑色")){
            System.out.println("黑色");
            mp.setBackground(Color.black);

        }else if(e.getActionCommand().equals("红色")){
            System.out.println("红色");
            mp.setBackground(Color.red);


        }
    }
}


// 任何一个类，只要实现了相应的接口，就可以去监听某个事件源

class Cat implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("黑色")){
            System.out.println("猫猫也知道你按下了黑色按钮");
        }else if(e.getActionCommand().equals("红色")){
            System.out.println("猫猫也知道你按下了红色按钮");
        }
    }
}

