
/*
* 功能：演示Java集合的用法
*
* */



package com.syh.service;


// 先引入一个包
import java.util.*;

public class listDemo {

    public static void main(String[] args) {

        //定义ArrayList对象
        ArrayList al = new ArrayList(); //在内存中解析：al分配在栈中，指向一块没有大小的地址空间
        //显示大小
        System.out.println("al大小："+al.size()); //al大小：0
        //向al中加入数据，（类型是object）
        //创建一个职员
        Clerk clerk1 = new Clerk("宋江",40,1000);
        Clerk clerk2 = new Clerk("小黑",42,1600);
        Clerk clerk3 = new Clerk("洪荒",10,100);

        //将clerk1加入到al中，
        al.add(clerk1); //加入到尾部
        al.add(clerk2);
        al.add(clerk3);
        al.add(clerk1);
        //显示大小
        System.out.println("al大小："+al.size()); //al大小：1

        //如何访问al中的对象（数据）
        //访问第一个对象
        Clerk temp = (Clerk) al.get(0);
        System.out.println("第一个人的名字是："+temp.getName());

        al.remove(1);


        for (int i=0; i<al.size();i++){
            Clerk clerk = (Clerk)al.get(i);
            System.out.println("第"+i+"个名字是"+clerk.getName());
        }

    }

}

//定义一个员工类
class Clerk
{


    private String name;
    private int age;
    private float sal;

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void setSal(float sal) {
        this.sal = sal;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getSal() {
        return sal;
    }


    public Clerk(String name,int age,float sal)
    {
        this.name = name;
        this.age = age;
        this.sal = sal;
    }


}