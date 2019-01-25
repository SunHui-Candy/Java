
/*
* 功能：多种布局管理器的使用
*
* Jpanel 面板组件演示
*
* Jpanel 面板组件，非顶层容器
* 一个界面只可以有一个JFrame窗体组件，但可以有多个Jpanel面板组件，而Jpanel上也可使用
* FlowLayout、BorderLayout、GirdLayout等各种布局管理器，这样可以组合使用达到较为
* 复杂的布局效果
*
*Jpanel 面板组件 注意事项：
* 1、Jpanel 是 JComponent 的子类
* 2、属于容器类组件，可以加入别的组件
* 3、默认布局管理器是 流式布局（FlowLayout）
* */
package com.syh.swingDemo;

import javax.swing.*;
import java.awt.*;

public class JpanelDemo extends JFrame {

//    定义组件
    JPanel jp1,jp2;
    JButton jb1,jb2,jb3,jb4,jb5,jb6;

    public static void main(String[] args) {

       JpanelDemo demo = new JpanelDemo();
    }

//    构造函数
    public JpanelDemo()
    {
//        创建组件
//        Jpanel布局默认是FlowLayout

        jp1 = new JPanel();
        jp2 = new JPanel();

        jb1 = new JButton("西瓜");
        jb2 = new JButton("苹果");
        jb3 = new JButton("荔枝");
        jb4 = new JButton("葡萄");
        jb5 = new JButton("橘子");
        jb6 = new JButton("香蕉");

//        设置布局管理器
//        添加Jpanel组件
        jp1.add(jb1);
        jp1.add(jb2);

        jp2.add(jb3);
        jp2.add(jb4);
        jp2.add(jb5);

//        把Jpanel加入到JFrame
        this.add(jp1, BorderLayout.NORTH);
        this.add(jb6,BorderLayout.CENTER);
        this.add(jp2,BorderLayout.SOUTH);

        this.setSize(300,200);
        this.setLocation(200,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }
}
