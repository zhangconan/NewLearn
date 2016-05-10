package com.zkn.newlearn.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wb-zhangkenan on 2016/5/9.
 */
public class ReflectTest03 {

    public static void main(String[] args){
        try {
            Object clazz = Class.forName("com.zkn.newlearn.reflect.ReflectTest02").newInstance();
            //��ȡ���еķ���������˽�еķ���
            Method[] obj = clazz.getClass().getDeclaredMethods();
            for(Method method : obj){
                if("testVariableArgument".equals(method.getName())){
                	//��ȡ���еò�������
                	Class[] parameterClass = method.getParameterTypes();
                	for(Class parmeter : parameterClass){
                		
                		System.out.println(parmeter.getTypeName());
                		
                	}
                    if(!method.isAccessible()){
                    	//�����private ���� ��������Ϊtrue
                    	method.setAccessible(true);
                    }
                    List<Object> list = new ArrayList<Object>();
                    list.add("1111");
                    list.add(88888);
                    method.invoke(clazz,list.toArray());
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
