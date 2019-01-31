
/*
*
* 功能：演示FileInputStream类的使用
*
* 从文件读入数据到内存中
*
*
* */
package com.syh.IODemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStream2 {

    public static void main(String[] args) {

//        得到一个文件对象，f-->指向文件路径
        File f = new File("/Users/macair/Desktop/javaIO/ceshi2.txt");

//        因为File没有读写的能力，所以需要提供InputStream
        FileInputStream fis = null;
        try {
             fis = new FileInputStream(f);

//            定义一个字节数组，相当于缓存
            byte []bytes = new byte[1024];

            int n = 0;//得到实际读取到的字节数
//            循环读取，
//            read(bytes[]),方法表示从此输入流中将最多bytes.length个字节的数据输入一个byte数组中，
//            若到达文件末尾没有数据，则返回-1
            while ((n = fis.read(bytes)) != -1)
            {
//                把字节转为string
                String s = new String(bytes,0,n);
                System.out.println(s);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
//            关闭文件流必须放这
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }


}
