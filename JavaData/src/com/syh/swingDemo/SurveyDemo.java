

/*
* 功能：用户调查界面
* 1、下拉框组件（JComboBox）
* 2、列表框组件（JList）
* 3、滚动窗格组件（JScrollPane）
*
* 特别说明：
* 一般来说，列表组件+滚动窗格组件是结合使用的，目的是
* 让列表框中的选项可以有滚动条支持。
*
* */
package com.syh.swingDemo;

import javax.swing.*;
import java.awt.*;

public class SurveyDemo extends JFrame {


    //    定义组件
    JPanel jp1,jp2;
    JLabel jlb1,jlb2;
    JComboBox jcb1;
    JList jlist;
    JScrollPane jsp;

    public static void main(String[] args) {
        SurveyDemo demo = new SurveyDemo();
    }

//    构造函数
    public SurveyDemo()
    {

        jp1 = new JPanel();
        jp2 = new JPanel();

        jlb1 = new JLabel("你的籍贯");
        jlb2 = new JLabel("旅游地点");

        String []jg = {"北京","上海","河南","山东"};
        jcb1 = new JComboBox(jg);

        String []dd = {"九寨沟","故宫","长城","天安门","西湖","动物园"};
        jlist = new JList(dd);
        //        设置列表框可看见的行数
        jlist.setVisibleRowCount(2);
        jsp = new JScrollPane(jlist);

//        设置布局
        this.setLayout(new GridLayout(2,1));
//        添加组件
        jp1.add(jlb1);
        jp1.add(jcb1);

        jp2.add(jlb2);
        jp2.add(jsp);

        this.add(jp1);
        this.add(jp2);

        this.setSize(300,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("用户调查");
        this.setVisible(true);

    }
}
