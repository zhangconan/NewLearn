package com.zkn.newlearn.tester.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wb-zhangkenan on 2016/12/23.
 */
public class StringTest02 {

    @Test
    public void test(){
        String str1 = "李四";
        test(str1);
        System.out.println(str1);
        List<String> list = new ArrayList<>();
        list.add("zhang");
        test(list);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public void test(String str){
        System.out.println(str);
    }

    public void test(List<String> str){

        //str = new ArrayList<>();
        str.add("lisi");
    }
}
