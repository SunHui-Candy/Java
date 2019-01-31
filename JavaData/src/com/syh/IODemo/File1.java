
/*
* 功能：文件数据源File类的基本用法
*
*
* 文件：
* 数据源（保存数据的地方）的一种，如word文件、txt文件、excel文件，
* 既可以保存图片，也可以保存视频、声音等
*
* 文件流：
* 文件在程序中是以 流 的形式来操作的
*
* 流：数据在数据源（文件）和程序（内存）之间经历的路径
* 输入流：数据从数据源（文件）到程序（内存）的路径
* 输出流：数据从程序（内存）到数据源（文件）的路径
*
* 如何判断是输入流，还是输出流：
* 以内存为参照，如果数据是向内存流动，则是输入流，反之，是输出流。
*
* 文件流分类：
* 1、字节流：可以用于读写二进制文件及任何类型文件，（byte形式）
* 2、字符流：可以用于读写文本文件，不能操作二进制文件
*
*           字节流             字符流
* 输入    InputStream          Reader
* 输出    OutputStream         Writer
*
*
* */

package com.syh.IODemo;

import java.io.File;
import java.io.IOException;

public class File1 {
    public static void main(String[] args) {

//        创建一个文件对象
        File file = new File("/Users/macair/Desktop/ceshi.rtf");

//        得到文件的路径
        System.out.println("文件路径"+file.getAbsolutePath());
//        得到文件的大小,字节数
        System.out.println("文件大小"+file.length()+"字节");

        System.out.println("可读"+ file.canRead());



//        创建文件和文件夹
        File f = new File("/Users/macair/Desktop/javaIO/ceshi2.txt");
        if (!f.exists()){
//            可以创建
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else {
            System.out.println("有文件，不能创建");
        }


//        创建文件夹
        File file2 = new File("/Users/macair/Desktop/javaIO");

//        如果是一个文件夹
        if (file2.isDirectory()){
            System.out.println("改文件夹已存在");
        }else {
//            创建文件夹
            file2.mkdir();
        }

//        列出一个文件夹下的所有文件
        File file3 = new File("/Users/macair/Desktop/javaIO");
        if (file3.isDirectory()){
            File lists[] = file3.listFiles();
            for (int i = 0; i < lists.length; i++)
            {
                System.out.println("文件名是："+lists[i].getName());
            }
        }

    }
}



















