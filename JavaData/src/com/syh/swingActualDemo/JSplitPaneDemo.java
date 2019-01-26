
/*
* 功能：JSplitPane 拆分窗格组件
*
* JSplitPane 拆分窗格，属于容器类组件
*
* 重点：
* 1、拆分窗格，可移动
* 2、JLable上可以添加图片
* */

package com.syh.swingActualDemo;

import javax.swing.*;

public class JSplitPaneDemo extends JFrame {

//  定义组件
    JSplitPane jsp;
    JList jList;
    JLabel jlb;

    public static void main(String[] args) {

        JSplitPaneDemo demo = new JSplitPaneDemo();

    }

    public JSplitPaneDemo()
    {

//        创建组件
        String []words = {"boy","girl","bird"};
        jList = new JList(words);

// JLable是可以放图片的
        jlb = new JLabel(new ImageIcon("src/com/syh/images/JSplitPaneDemoImg.jpg"));

//        拆分窗格
        jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jList,jlb);

//        可以变化
        jsp.setOneTouchExpandable(true);


//        设置布局管理器
//        添加组件
        this.add(jsp);

//        设置大小
        this.setSize(500,500);
        this.setLocation(200,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setVisible(true);

    }
}
