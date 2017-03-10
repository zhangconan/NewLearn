package com.zkn.newlearn.tester.bytes;

import org.junit.Test;

/**
 * Created by wb-zhangkenan on 2017/2/10.
 */
public class GetBytes {

    @Test
    public void testGetBytes(){
        //00010001 00110100 01010110 01111000
        //17.52.86.120
        //System.out.println(Integer.toBinaryString(0x11345678));
        //10000010 00110010 00001010 11001000 B类地址 16位网络ID
        System.out.println(Integer.toBinaryString(252));
        System.out.println(Integer.toHexString(562+1024*32));
    }
}
