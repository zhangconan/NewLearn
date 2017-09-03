package com.zkn.newlearn.tester.reflect;

import com.zkn.newlearn.reflect.generic.GenericFirst;
import com.zkn.newlearn.reflect.generic.GenericSec;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by zkn on 2017/9/3.
 */
public class GenericTest {
    /**
     * 获取字段上泛型的实际类型
     */
    @Test
    public void testFiledGeneric() {
        Class clazz = GenericFirst.class;
        Field[] fields = clazz.getDeclaredFields();
        if (fields != null) {
            Field field = null;
            Class fieldClass = null;
            for (int i = 0; i < fields.length; i++) {
                field = fields[i];
                fieldClass = field.getType();
                if (fieldClass.isAssignableFrom(List.class)) {
                    Type type = field.getGenericType();
                    if (type instanceof Class) {
                    }
                    //获取字段的实际参数
                    if (type instanceof ParameterizedType) {
                        ParameterizedType parameterType = (ParameterizedType) type;
                        Class classAct = (Class) parameterType.getActualTypeArguments()[0];
                        System.out.println(classAct.getName());
                    }
                }
            }
        }
    }

    /**
     * 获取类上的泛型字段
     * 本类上的泛型没有意义，也获取不到
     */
    @Test
    public void testClassGeneric() {
        Class clazz = GenericSec.class;
        Type[] types = clazz.getGenericInterfaces();
        if (types != null) {
            for (int i = 0; i < types.length; i++) {
                if (types[i] instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) types[i];
                    System.out.println(parameterizedType.getActualTypeArguments()[0].getTypeName());
                }
            }
        }
        Type type = clazz.getGenericSuperclass();
        if (type != null) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                System.out.println(parameterizedType.getActualTypeArguments()[0].getTypeName());
            }
        }
    }
}
