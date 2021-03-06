/*
* 功能：二进制、位运算、移位运算
*
* 二进制解析
*  1、二进制的最高位为符号位，0表示正数，1表示负数
*  2、正数的原码、反码、补码都一样
*  3、负数的反码=它的原码符号位不变，其它位取反
*  4、负数的补码=它的反码+1
*  5、计算机都是以补码的方式来运算的
*
*  1-2在计算机中的计算规则如下：
*  1-2 = 1 + (-2)
*
*  0000 0001 --> 1的补码
*  1000 0010 --> -2的原码
*  1111 1101 --> -2的反码
*  1111 1110 --> -2的补码
*
*  将1的补码和-2的补码相加，即
*  0000 0001 --> 1的补码
*  1111 1110 --> -2的补码
*
*  得到
*  1111 1111 --> 得到补码，最高位负数，求得原码得出结果
*  从补码求出原码，方法一：
*  1111 1110 --> 得到反码，(补码-1)
*  1000 0001 --> 得到原码，即-1，（反码符号位不变，其他位取反）
*
*  从补码求出原码，方法二：
*  补码的补码为原码：
*  1111 1111 -->补码
*  1000 0000 -- +1 -> 1000 0001
*
*  所以，1 - 2 = -1
*
 * 位运算符：有4个位运算符
 * 按位与&：两位全为1，结果为1
 * 按位或|：两位有一个为1，结果为1
 * 按位异或^：两位一个为0，一个为1，结果为1
 * 按位取反：0-->1，1-->0
 *
 *
 * 移位运算符：3个移位运算符
 * >> ：算数右移，低位溢出，符号位不变，并用符号位补溢出的高位
 * << ：算数左移，符号位不变，低位补0
 * >>> ：逻辑右移，低位溢出，高位补0
 *
 *
 * */

package com.syh.service;

public class binarySystem {

    public static void main(String[] args) {

        System.out.println("~2="+(~2));  //~2=-3 ,2取反后为-3
        /*
        * 0000 0010 -->2的补码
        * ~ -->取反（0变1，1变0):
        * 1111 1101 -->最高位为1，是负数，为补码
        * 1111 1100 -->得到反码（补码-1）
        * 1000 0011 -->得到原码，即-3（反码除符号位外取反）
        * 或者：
        * 1111 1101 --除符号位外取反---> 1000 0010 ---- +1 -->1000 0011
        * */

        System.out.println("~-5="+(~-5)); //~-5=4
        /*
        * 1000 0101 --> -5的原码
        * 1111 1011 --> -5的补码
        * ~ -->取反 0-->1，1-->0
        * 0000 0100 -->结果为4
        * */


        System.out.println("2&3="+(2&3)); //2&3=2
        /*
        * 0000 0010 -->2的补码
        * 0000 0011 -->3的补码
        * &-->两位全为1，结果为1,得到
        * 0000 0010 -->结果为2
        *
        * */

        System.out.println("2|3="+(2|3));//2|3=3
        /*
        * 0000 0010 -->2的补码
        * 0000 0011 -->3的补码
        * |-->两位有一个为1，结果为1
        * 0000 0011 -->结果为3
        * */

        System.out.println("-3^3="+(-3^3));//-3^3=-2
        /*
        * 1000 0011 --> -3的原码
        * 1111 1101 --> -3的补码
        * 0000 0011 --> 3的补码
        * ^ 两位一个为0，一个为1，结果为1
        * 1111 1110 -->求得的补码，最高位1，为负数，需算出原码
        * 1000 0010 -->结果为 -2
        * */


        System.out.println("1>>2="+(1>>2));//1>>2=0
        /*
        * 1算术右移2位
        *
        * 0000 0001 --> 1的补码
        * 对1的补码，进行算术右移2位，根据算数右移原则：低位溢出，符号位不变，并用符号位补溢出的高位，即，
        * 0  0 0000  01 --> 右边的01移出，对左边空缺的两个高位，用高位的符号位0来补，得出
        * 0000 0000 --> 结果为0
        *
        * */

        System.out.println("-1>>2="+(-1>>2));//-1>>2=-1
        /*
         * -1算术右移2位
         *
         * 1000 0001 --> -1的原码
         * 1111 1111 --> -1的补码
         * 对1的补码，进行算术右移2位，根据算数右移原则：低位溢出，符号位不变，并用符号位补溢出的高位，即，
         * 1  1 1111  11 --> 右边的11移出，对左边空缺的两个高位，用高位的符号位1来补，得出
         * 1111 1111 --> 求得的为补码，最高位为1，负数，需转为原码
         * 1000 0001 --> 结果为-1
         *
         * */


        System.out.println("1<<2="+(1<<2));//1<<2=4
        /*
        * 1算术左移2位，左移1位相当于乘以2
        * 0000 0001 --> 1的补码
        * 对1的补码，进行算术左移2位，根据算数左移原则：符号位不变，低位补0，即，
        * 0000 01   --> 除符号位的左边的00移出，对右边空缺的两个低位，用0来补，得出
        * 0000 0100 --> 结果为4
        *
        * */

        System.out.println("-1<<2="+(-1<<2));//-1<<2=-4
        /*
         * -1算术左移2位
         *
         * 1000 0001 --> -1的原码
         * 1111 1111 --> -1的补码
         * 对1的补码，进行算术左移2位，根据算数左移原则：符号位不变，低位补0，即，
         * 1111 11   --> 除符号位的左边的11移出，对右边空缺的两个低位，用0来补，得出
         * 1111 1100 --> 求得的为补码，最高位为1，负数，需转为原码
         * 1000 0100 --> 结果为-4
         *
         * */

        System.out.println("3>>>2="+(3>>>2));//3>>>2=0
        /*
         * 3逻辑右移2位
         *
         * 0000 0011 --> 3的补码
         * 对3的补码，进行逻辑右移2位，根据逻辑右移原则：低位溢出，高位补0，即，
         * 0  0 0000  11 --> 右边的11移出，对左边空缺的两个高位用0来补，得出
         * 0000 0000 --> 结果为0
         *
         * */


    }

}

