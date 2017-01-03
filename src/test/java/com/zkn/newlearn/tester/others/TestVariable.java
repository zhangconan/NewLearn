package com.zkn.newlearn.tester.others;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wb-zhangkenan on 2016/12/27.
 */
public class TestVariable {

    public static void main(String[] args){
        test();
    }

    public static void test(String ...str){

        System.out.println("zhangsan");
    }
    @Test
    public void testBasic(){

        byte[] bytes = new byte[20];
        System.out.println(Arrays.toString(bytes));
    }
}

