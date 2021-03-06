package com.zkn.newlearn.tester.bytes;

import org.junit.Test;

/**
 * Created by zkn on 2016/11/19.
 */
public class ByteMoveTest01 {

    @Test
    public void testByteRightMove() {
        int a = 3;
        System.out.println(a >> 36);
    }

    @Test
    public void testByteLeftMove() {
        int a = 3;
        System.out.println(a << 29);
    }

    @Test
    public void testByteCaculate() {
        int a = 3;
        int b = 4;
        System.out.println(a ^ b);
    }

    @Test
    public void test() {
        Integer a = 12, b = 12, c = 521, d = 521;
        System.out.println(a == b);
        System.out.println(c == d);
    }

    @Test
    public void test01() {
        String s1 = "v1.1.1";
        String s2 = "v2.2.9";
        if(s1.compareTo(s2) < 0 ){
            System.out.println("ssss");
        }
    }

    @Test
    public void test7(){
        //永远是8的倍数
        System.out.println((1+7) & (~7));
    }
    @Test
    public void test2(){
        char[] c = new char[15];
        c[0] ='a';
        c[1] ='b';
        c[2] ='c';
        c[8] ='g';
        System.out.println(new String(c));
        System.out.println(new String(c).replace('\0',' '));
    }
}
