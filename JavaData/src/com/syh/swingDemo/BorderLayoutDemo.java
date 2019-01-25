/*
 * 功能：BorderLayout边界布局演示
 *
 * 边界布局(BorderLayout)将容器简单的划分为东南西北中5个区域，中间区域最大。
 * 流程：
 * 1、继承JFrame
 * 2、定义需要的组件
 * 3、创建组件（构造函数）
 * 4、添加组件
 * 5、对窗体设置
 * 6、显示窗体
 *
 *
 * BorderLayout边界布局的注意事项：
 * 1、不是五个部分都必须添加
 * 2、中部组件会自动的调节大小
 * 3、JFrame，JDialog 默认布局管理器就是BorderLayout.
 * */

package com.syh.swingDemo;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo extends JFrame {

    //   定义组件
    JButton jbtn1,jbtn2,jbtn3,jbtn4,jbtn5;

    public static void main(String[] args) {

        BorderLayoutDemo demo = new BorderLayoutDemo();
    }

//    构造函数
    public BorderLayoutDemo()
    {
//        创建组件
        jbtn1 = new JButton("中部");
        jbtn2 = new JButton("北部");
        jbtn3 = new JButton("东部");
        jbtn4 = new JButton("南部");
        jbtn5 = new JButton("西部");

//        添加各个组件
        this.add(jbtn1, BorderLayout.CENTER);
        this.add(jbtn2, BorderLayout.NORTH);
        this.add(jbtn3, BorderLayout.EAST);
        this.add(jbtn4, BorderLayout.SOUTH);
        this.add(jbtn5, BorderLayout.WEST);

//        设置窗体属性
        this.setTitle("边界布局案例");
        this.setSize(300,200);
        this.setLocation(200,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        显示窗体
        this.setVisible(true);

    }
}
