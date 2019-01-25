
/*
* 功能：gui界面开发，swing的介绍
*
* ide：集成开发环境，如jcreator、vs2005等开发工具都是ide
*
* */
package com.syh.service;

//引入包
import javax.swing.*;

public class SwingDemo extends JFrame{

//把需要的swing组件，定义到这里
    JButton jbtn1 = null;

    public static void main(String[] args) {
     SwingDemo demo = new SwingDemo();

    }

//   构造方法，注意名字应和类名相同
    public SwingDemo(){

//        创建一个btn按钮
        jbtn1 = new JButton("我是按钮");

//      添加JButton组件
        this.add(jbtn1);

        //给窗体设置标题
        this.setTitle("hello world");

        //设置大小，按像素（像素是一个密度单位）
        this.setSize(200,200);

//        设置初始位置
        this.setLocation(100,200);

//        设置当关闭窗口的时候，保证jvm也退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //显示
        this.setVisible(true);
    }

}
