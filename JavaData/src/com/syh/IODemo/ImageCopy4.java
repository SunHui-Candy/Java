/*
* 功能：图片拷贝，用文件字节流
* 思路：
* 1、先把图片读入到内存，即写入到某个文件
* 2、因为是二进制文件，因此只能用字节流完成
*
*
* */

package com.syh.IODemo;

import java.io.*;

public class ImageCopy4 {

    public static void main(String[] args) {

//        输入流
        FileInputStream fis = null;
//        输出流
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("/Users/macair/Desktop/teset.jpeg");
            fos = new FileOutputStream("/Users/macair/Desktop/javaIO/teset.jpeg");

            byte buf[] = new byte[512];
            int n = 0;//记录实际读取到的字节数
//            循环读取
            while ((n = fis.read(buf)) != -1)
            {
//                输出到指定文件
                fos.write(buf);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

//            关闭打开的文件流必须放这
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
