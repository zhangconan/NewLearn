package com.zkn.newlearn.tester;

import org.junit.Test;

/**
 * Created by zkn on 2016/11/19.
 */
public class ByteMoveTest01 {

    @Test
    public void testByteRightMove(){
        int a = 3;
        System.out.println(a >> 36);
    }

    @Test
    public void testByteLeftMove(){
        int a = 3;
        System.out.println(a << 29);
    }
    @Test
    public void testByteCaculate(){
        int a = 3;
        int b = 4;
        System.out.println(a ^ b);
    }
}
