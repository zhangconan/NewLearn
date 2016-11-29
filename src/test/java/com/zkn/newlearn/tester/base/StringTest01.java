package com.zkn.newlearn.tester.base;

/**
 * Created by wb-zhangkenan on 2016/8/23.
 */
public class StringTest01 {

    public static void main(String[] args){
        String str = "sssssssz,ddds,";
        str = str.substring(0,str.length()-1);
        System.out.println(str);
    }
}
