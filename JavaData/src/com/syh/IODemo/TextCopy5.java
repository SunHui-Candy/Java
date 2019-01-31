/*
* 功能：演示文件字符流的案例
*
* 一个文件copy到另一个文件中
*
* */

package com.syh.IODemo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextCopy5 {
    public static void main(String[] args) {

//        文件取出字符流对象，输入流
        FileReader fr = null;
//        写入到文件，输出流
        FileWriter fw = null;

        try {
            //        创建fr对象
            fr = new FileReader("/Users/macair/Desktop/read.txt");

//            创建输出对象
            try {
                fw = new FileWriter("/Users/macair/Desktop/javaIO/read5.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }

//            读入到内存
            char c[] = new char[1024];
            int n = 0;//记录实际读取到的字符数

            try {
// 读取字符数，如果已经达到流的末尾，则返回-1
                while ((n = fr.read(c)) != -1)
                {
                    String s = new String(c,0,n);
                    System.out.println(s);

                    fw.write(c);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
