package com.zkn.newlearn.tester.collections;

import org.junit.Test;

import java.util.*;

/**
 * Created by wb-zhangkenan on 2016/12/5.
 */
public class SetListTransferArrayTest01 {

    @Test
    public void testSetListTransferArray(){
        Set set = new HashSet(){{
            add("张三");
            add("张三02");
            add("张三01");
            add("李四");
            add("张三04");
            add("张三05");
        }};
        //注意这里：toArray这个方法里的参数，如果传入的参数的数组长度超过集合的长度，超过的部分设置为null.
        String[] strs = (String[]) set.toArray(new String[2]);
        System.out.println(Arrays.toString(strs));
        List<String> list = new ArrayList<String>(){{
            add("张三");
            add("张三02");
            add("张三01");
            add("李四");
            add("张三04");
            add("张三05");
        }};
        String[] strList = (String[]) list.toArray(new String[0]);
        System.out.println(Arrays.toString(strList));
    }
}
