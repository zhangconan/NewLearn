package com.zkn.newlearn.tester.string;

import java.util.Arrays;

/**
 * Created by wb-zhangkenan on 2016/8/23.
 */
public class StringTest01 {

    public static void main(String[] args){
        String str = "sssssssz.ddds.sdsdwe.";
        //str = str.substring(0,str.length()-1);
        //System.out.println(str);
        System.out.println(Arrays.toString(str.split("\\.")));
        str = str.substring(0,str.lastIndexOf("."));
        System.out.println(str);
        System.out.println(str.substring(0,str.lastIndexOf(".")));
    }
}
