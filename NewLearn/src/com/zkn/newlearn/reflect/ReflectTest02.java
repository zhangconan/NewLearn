package com.zkn.newlearn.reflect;

import java.io.Serializable;

/**
 * Created by zkn on 2016/5/9.
 */
public class ReflectTest02 implements Serializable{

    public void testVariableArgument(String str,char str1){
        System.out.println(str + "   "+str1);
    }
}
