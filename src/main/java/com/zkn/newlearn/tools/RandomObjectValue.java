package com.zkn.newlearn.tools;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import com.zkn.newlearn.annotation.FormatAnnotation;
import org.springframework.util.StringUtils;

/**
 * Created by wb-zhangkenan on 2017/4/13.
 *
 * @author wb-zhangkenan
 * @date 2017/04/13
 */
public class RandomObjectValue {

    public static <T> T getObject(Class<T> clazz) {

        if (clazz == null) {
            return null;
        }
        //需要有无参的构造器
        T t = null;
        try {
          t = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Field[] fields = clazz.getDeclaredFields();
        //属性字段
        String fileName = "";
        //符合JavaBean规则的属性
        PropertyDescriptor property = null;
        //set方法对象
        Method method = null;
        for(int i=0;i<fields.length;i++){
            //属性字段
            fileName = fields[i].getName();
            //获取属性上的注解
            FormatAnnotation annotation = fields[i].getAnnotation(FormatAnnotation.class);
            try {
                property = new PropertyDescriptor(fileName,clazz);
            } catch (IntrospectionException e) {
                //没有设置set方法，或者不符合JavaBean规范
                continue;
            }
            //获取set方法对象
            method = property.getWriteMethod();
            //如果是字节类型(包含基本类型和包装类)
            if(fields[i].getType() == byte.class || fields[i].getType() == Byte.class){
                try {
                    method.invoke(t,SelfUtils.getByteValue());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            //如果是short类型(包含基本类型和包装类)
            if(fields[i].getType() == short.class || fields[i].getType() == Short.class){
                try {
                    method.invoke(t,SelfUtils.getShortValue());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            //如果是char类型(包含基本类型和包装类)
            if(fields[i].getType() == char.class || fields[i].getType() == Character.class){
                try {
                    method.invoke(t,SelfUtils.getCharValue());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            //如果是整型(包含基本类型和包装类)
            if(fields[i].getType() == int.class || fields[i].getType() == Integer.class){
                try {
                    //为属性赋值
                    method.invoke(t,SelfUtils.getIntValue());
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            //如果是float(包含基本类型和包装类)
            if(fields[i].getType() == float.class || fields[i].getType() == Float.class){
                try {
                    //为属性赋值
                    method.invoke(t,SelfUtils.getFloatValue());
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            //如果是double(包含基本类型和包装类)
            if(fields[i].getType() == double.class || fields[i].getType() == Double.class){
                try {
                    //为属性赋值
                    method.invoke(t,SelfUtils.getDoubleValue());
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            //如果是double(包含基本类型和包装类)
            if(fields[i].getType() == long.class || fields[i].getType() == Long.class){
                try {
                    //为属性赋值
                    method.invoke(t,SelfUtils.getDoubleValue());
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            //如果是boolean(包含基本类型和包装类)
            if(fields[i].getType() == boolean.class || fields[i].getType() == Boolean.class){
                try {
                    //为属性赋值
                    method.invoke(t,SelfUtils.getBooleanValue());
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            //如果是boolean(包含基本类型和包装类)
            if(fields[i].getType() == String.class){
                try {
                    //为属性赋值
                    method.invoke(t,SelfUtils.getRamdomString(8));
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            //如果是日期类型
            if(fields[i].getType() == Date.class){
                try {
                    method.invoke(t,SelfUtils.getDateValue());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return t;
    }
}
