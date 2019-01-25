/*
* 功能：用户注册界面演示
* 1、复选框组件（JCheckBox）
* 2、单选框组件（JRadioButton）
*
* 特别说明：
* 同一组单选按钮必须先创建ButtonGroup,然后把单选框组件
* 放入到ButtonGroup中
*
* 思路：类似于之前的LoginDemo的思路
* 是一个三行一列的网格布局，
* 网格布局上有3个Jpanel
* 第一个Jpanel上加入 ，喜欢的运动+3个复选框
* 第二个Jpanel上加入 ，你的性别+单选框
* 第三个Jpanel上加入 ，注册用户+取消注册的按钮
* */

package com.syh.swingDemo;

import javax.swing.*;
import java.awt.*;

public class RegistDemo extends JFrame{

//    定义组件
    JPanel jp1,jp2,jp3;
    JLabel jlb1,jlb2;
    JButton jb1,jb2;
    JCheckBox jcb1,jcb2,jcb3;
    JRadioButton jrb1,jrb2;
    ButtonGroup bg;
    public static void main(String[] args) {

        RegistDemo demo = new RegistDemo();
    }

//    构造函数
    public RegistDemo()
    {

//        创建组件
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jlb1 = new JLabel("你喜欢的运动");
        jlb2 = new JLabel("你的性别");
        jb1 = new JButton("注册用户");
        jb2 = new JButton("取消注册");

        jcb1 = new JCheckBox("足球");
        jcb2 = new JCheckBox("篮球");
        jcb3 = new JCheckBox("网球");

        jrb1 = new JRadioButton("男");
        jrb2 = new JRadioButton("女");

//        一定要把jrb1,jrb2放入到ButtonGroup中
        bg = new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);

//        设置布局管理
        this.setLayout(new GridLayout(3,1));

//        添加组件
        jp1.add(jlb1);
        jp1.add(jcb1);
        jp1.add(jcb2);
        jp1.add(jcb3);

        jp2.add(jlb2);
        jp2.add(jrb1);
        jp2.add(jrb2);

        jp3.add(jb1);
        jp3.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setSize(300,150);
        this.setTitle("用户注册界面");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
