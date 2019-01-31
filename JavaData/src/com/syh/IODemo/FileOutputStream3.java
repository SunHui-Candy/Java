/*
* 功能：演示FileOutputStream类的使用
*
* */

package com.syh.IODemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream3 {
    public static void main(String[] args) {

        File f = new File("/Users/macair/Desktop/javaIO/ceshi3.txt");

        //            字节输入流
        FileOutputStream fos = null;
        try {

             fos = new FileOutputStream(f);

             String s = "测试了\r\n";
            String s1 = "哈哈哈";

            try {
                fos.write(s.getBytes());
                fos.write(s1.getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
