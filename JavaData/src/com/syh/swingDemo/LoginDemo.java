/*
* 功能：用户登录界面
* 涉及到的组件有：
* 1、文本框（JTextField）
* 2、密码框（JPasswordFiled）
* 3、标签（JLable）
*
* 布局思路：
* 看做是3行一列的网格布局，
* 在网格布局上加入3个Jpanel,
* 第一个Jpanel上加入 ，用户名+文本框
* 第二个Jpanel上加入，密码+密码框
* 第三个Jpanel上加入，登录+取消按钮
*
* */

package com.syh.swingDemo;

import javax.swing.*;
import java.awt.*;

public class LoginDemo extends JFrame {

//    定义组件
    JPanel jp1,jp2,jp3;
    JLabel jlb1,jlb2;
    JButton jb1,jb2;
    JTextField jtf1;
    JPasswordField jpf1;

    public static void main(String[] args) {

        LoginDemo demo = new LoginDemo();
    }

//    构造函数
    public LoginDemo()
    {

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jlb1 = new JLabel("用户名");
        jlb2 = new JLabel("密  码");
        jb1 = new JButton("登录");
        jb2 = new JButton("取消");

        jtf1 = new JTextField(10);
        jpf1 = new JPasswordField(10);

//        设置布局管理，三行一列
        this.setLayout(new GridLayout(3,1));

//        加入各个组件
        jp1.add(jlb1);
        jp1.add(jtf1);

        jp2.add(jlb2);
        jp2.add(jpf1);

        jp3.add(jb1);
        jp3.add(jb2);

//        加入到JFrame
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);


        this.setSize(300,150);
        this.setTitle("用户登录界面");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }

}
