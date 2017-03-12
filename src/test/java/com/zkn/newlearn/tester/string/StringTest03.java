package com.zkn.newlearn.tester.string;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wb-zhangkenan on 2016/12/27.
 */
public class StringTest03 {

    @Test
    public void testSubString(){

        String str = "GET /zhang HTTP/1.1";
        int indexFirst = str.indexOf(" ");
        if(indexFirst != -1){//说明查找到了
            int indexSecond = str.indexOf(" ",indexFirst+1);
            if(indexSecond > indexFirst)
                System.out.println(str.substring(indexFirst+1,indexSecond));
        }
    }
    @Test
    public void testSplitString(){

        String str = "sdsd.sdwewe.sdwewe.";
        System.out.println(Arrays.toString(str.split("\\.")));
    }

    @Test
    public void testBoundary(){
        String str = "multipart/form-data; boundary=----WebKitFormBoundaryBjbce374AAVAQIjz";
        System.out.println(str.substring(str.indexOf("boundary")+"boundary=".length()));
    }
}
