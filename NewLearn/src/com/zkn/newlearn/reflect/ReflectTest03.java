package com.zkn.newlearn.reflect;

import java.lang.reflect.Method;

/**
 * Created by wb-zhangkenan on 2016/5/9.
 */
public class ReflectTest03 {

    public static void main(String[] args){
        try {
            Object clazz = Class.forName("com.zkn.newlearn.reflect.ReflectTest02").newInstance();
            Method[] obj = clazz.getClass().getMethods();
            for(Method method : obj){
                if("testVariableArgument".equals(method.getName())){
                    Class[] cla = method.getParameterTypes();
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
