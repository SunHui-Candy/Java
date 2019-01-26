/*
* 功能：qq聊天界面
*
*问题：
* 设置标题旁边的图片没有成功，暂时没找到原因
*
* 思路：
* 输入框+Jpanel
* Jpanel中包含 下拉框组件（JComboBox）+输入框+按钮
*
*
*
*
* */

package com.syh.swingActualDemo;

import javax.swing.*;
import java.awt.*;

public class QQDemo extends JFrame {

//    定义组件
    JTextArea jta = null;
    JScrollPane jsp = null;
    JPanel jp1 = null;
    JComboBox jcb = null;
    JTextField jtf = null;
    JButton jb = null;
    public static void main(String[] args) {
        QQDemo demo = new QQDemo();

    }


    public QQDemo()
    {
        jta = new JTextArea();
        jsp = new JScrollPane(jta);
        jp1 = new JPanel();
        String []chatter = {"慧慧","楠楠"};
        jcb = new JComboBox(chatter);
        jtf = new JTextField(10);
        jb = new JButton("发送");

//        设置布局
//        添加组件
        jp1.add(jcb);
        jp1.add(jtf);
        jp1.add(jb);

//        加入到JFrame
        this.add(jsp);
        this.add(jp1, BorderLayout.SOUTH);

        this.setSize(400,200);
        this.setLocation(200,200);
//        设置图片
        this.setIconImage((new ImageIcon("src/com/syh/images/QQ.jpeg")).getImage());
        this.setTitle("QQ聊天界面");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }
}
