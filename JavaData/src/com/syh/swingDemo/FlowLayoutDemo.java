
/*
* 功能：FlowLayoutDemo流式布局演示
*
* FlowLayout流式布局，按照组件的添加次序将按钮组件（或别的组件）
* 从左到右放置在容器中，当到达容器的边界时，组件将放置在下一行中。
*
* FlowLayout 可以以左对齐、居中对齐，右对齐的方式排列组件
*
* FlowLayout流式布局的注意事项：
* 1、不限制他所管理的组件大小，允许他们有最佳大小
* 2、当容器被缩放时，组件的位置可能变化，但组件的大小不不变
* 3、默认组件是居中对齐
*
* */
package com.syh.swingDemo;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutDemo extends  JFrame{

//    定义需要的组件
    JButton jbtn1,jbtn2,jbtn3,jbtn4,jbtn5,jbtn6;

    public static void main(String[] args) {
        FlowLayoutDemo dmeo = new FlowLayoutDemo();
    }

//    构造函数
    public  FlowLayoutDemo()
    {
//        创建组件
        jbtn1 = new JButton("小红");
        jbtn2 = new JButton("小橙");
        jbtn3 = new JButton("小黄");
        jbtn4 = new JButton("小绿");
        jbtn5 = new JButton("小青");
        jbtn6 = new JButton("小蓝");

//      添加组件
        this.add(jbtn1);
        this.add(jbtn2);
        this.add(jbtn3);
        this.add(jbtn4);
        this.add(jbtn5);
        this.add(jbtn6);

//       设置布局管理器
        this.setLayout(new FlowLayout(FlowLayout.LEFT));


//        设置窗体属性
        this.setTitle("流式布局案例");
        this.setSize(300,200);
        this.setLocation(200,200);
//        禁止用户改变窗体大小
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        显示窗体
        this.setVisible(true);


    }

}
