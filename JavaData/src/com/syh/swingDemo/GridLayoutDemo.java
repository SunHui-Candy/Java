/*
* 功能：GridLayout 网格布局演示
*
* GridLayout 网格布局，将容器分割成多行多列，组件被填充到每个网格中，
* 添加到容器中的组件首先放置在左上角的网格中，然后从左到右放置其他的组件，
* 当占满该行的所有网格后，接着继续在下一行从左到右放置组件。
*
* GridLayout 网格布局注意事项：
* 1、组件的相对位置不随容器的缩放而改变，但大小会变化
* 2、所有组件的大小相同
* 3、可以通过GridLayout(int rows, int cols, int hgap, int vgap)来指定网格的行、列，
* 水平间隙、垂直间隙
*
* */



package com.syh.swingDemo;

import javax.swing.*;
import java.awt.*;

public class GridLayoutDemo extends JFrame{

//    定义需要的组件
    int size = 9;
    JButton jbs[] = new JButton[size];

    public static void main(String[] args) {
        GridLayoutDemo demo = new GridLayoutDemo();
    }

//    构造函数
    public GridLayoutDemo()
    {

        for (int i = 0; i < size; i++)
        {
            jbs[i] = new JButton(String.valueOf(i));
        }

//        设置网格布局，
        this.setLayout(new GridLayout(3,3,10,10));

//        添加组件
        for (int i = 0; i < size; i++)
        {
            this.add(jbs[i]);
        }

//        设置窗体属性
        this.setTitle("网格布局案例");
        this.setSize(300,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(200,200);

//        显示窗体
        this.setVisible(true);
    }

}
