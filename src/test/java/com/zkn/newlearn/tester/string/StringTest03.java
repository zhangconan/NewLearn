package com.zkn.newlearn.tester.string;

import org.junit.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by wb-zhangkenan on 2016/12/27.
 */
public class StringTest03 {

    @Test
    public void testSubString() {

        String str = "GET /zhang HTTP/1.1";
        int indexFirst = str.indexOf(" ");
        if (indexFirst != -1) {//说明查找到了
            int indexSecond = str.indexOf(" ", indexFirst + 1);
            if (indexSecond > indexFirst)
                System.out.println(str.substring(indexFirst + 1, indexSecond));
        }
        String str01 = "sdsxd";
        System.out.println(str01.substring("sds".length()));
    }

    @Test
    public void testSplitString() {

        String str = "sdsd.sdwewe.sdwewe.";
        System.out.println(Arrays.toString(str.split("\\.")));
    }

    @Test
    public void testResolve() {

        Map<String, String> parameterMap = new HashMap<>();
        String uri = "/msp/test.map?password=&name=lisi&user=zhangsan";
        //说明有参数
        int flag = -1;
        if ((flag = uri.indexOf('?')) >= 0) {
            uri = uri.substring(flag+1);
            String[] parameters = uri.split("&");
            if (parameters != null && parameters.length > 0) {
                for (int i = 0; i < parameters.length; i++) {
                    String str = parameters[i];
                    if((flag = str.indexOf('=')) >= 0){
                        String key = str.substring(0,flag);
                        String value = str.substring(flag+1);
                        parameterMap.put(key,value);
                    }else{
                        parameterMap.put(str,null);
                    }
                }
            }
        }
        parameterMap.forEach((key,value)-> System.out.println(key+" "+value));
    }

}
