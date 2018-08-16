package com.zkn.newlearn.opensource.spring.beanwrapper;

import com.zkn.newlearn.domain.StudentDomain;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.Date;

/**
 * BeanWrapper是Spring中提供的一个Java对象的组装类，
 * 设置和获取属性值以及嵌套属性
 * Created by wb-zhangkenan on 2016/9/1.
 */
public class BeanWrapperTest01 {

    public static void main(String[] args){

        BeanWrapper beanWrapper = new BeanWrapperImpl(new StudentDomain());
        beanWrapper.setPropertyValue("address","北京路九十六号");
        beanWrapper.setPropertyValue("buildDate",new Date());
        System.out.println(beanWrapper.getPropertyValue("address"));
   }
}
