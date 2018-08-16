package com.zkn.newlearn.opensource.spring.springutil;

import org.springframework.core.ResolvableType;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zkn on 2016/11/14.
 * Spring中的泛型工具类
 */
public class ParameterizedTypeTest01 {

    private List<List<String>> list;

    private Map<String, Map<String, Integer>> map;

    private List<String>[] array;

    public static void main(String[] args){
        /*
        Type type = GenericTypeTest01.class.getGenericInterfaces()[0];
        System.out.println(type.getTypeName());

        ResolvableType resolvableType1 = ResolvableType.forClass(GenericTypeTest01.class);
        System.out.println( resolvableType1.getInterfaces()[0].getGeneric(0).resolve());
        System.out.println(resolvableType1.as(GenericTypeTest01.class).getGeneric(0).resolve());
        */
        //得到类型上的泛型   如果你的类可能被代理 可以通过ClassUtils.getUserClass(ABService.class)得到原有的类型
        ResolvableType resolvableType1 = ResolvableType.forClass(GenericTypeTest01.class);

        //resolvableType1.getSuperType(); 得到父类
        //以下是得到接口上的
        System.out.println(resolvableType1.getInterfaces()[0].getGeneric(1).resolve());
        //转换为某个类型（父类/实现的接口）  还提供了简便方法 asMap() /asCollection
        System.out.println(resolvableType1.as(Service.class).getGeneric(1).resolve());

        ///得到字段的
        ResolvableType resolvableType2 =
                ResolvableType.forField(ReflectionUtils.findField(ParameterizedTypeTest01.class, "cdService"));
        System.out.println(resolvableType2.getGeneric(0).resolve()); //得到某个位置的 如<C, D>  0就是C 1就是D

        //嵌套的
        ResolvableType resolvableType3 =
                ResolvableType.forField(ReflectionUtils.findField(ParameterizedTypeTest01.class, "list"));
        System.out.println(resolvableType3.getGeneric(0).getGeneric(0).resolve());

        //Map嵌套
        ResolvableType resolvableType4 =
                ResolvableType.forField(ReflectionUtils.findField(ParameterizedTypeTest01.class, "map"));
        System.out.println(resolvableType4.getGeneric(1).getGeneric(1).resolve());
        System.out.println(resolvableType4.getGeneric(1, 1).resolve());

        //方法返回值
        ResolvableType resolvableType5 =
                ResolvableType.forMethodReturnType(ReflectionUtils.findMethod(ParameterizedTypeTest01.class, "method"));
        System.out.println(resolvableType5.getGeneric(1, 0).resolve());

        //构造器参数
        ResolvableType resolvableType6 =
                ResolvableType.forConstructorParameter(ClassUtils.getConstructorIfAvailable(Const.class, List.class, Map.class), 1);
        System.out.println(resolvableType6.getGeneric(1, 0).resolve());

        //数组
        ResolvableType resolvableType7 =
                ResolvableType.forField(ReflectionUtils.findField(ParameterizedTypeTest01.class, "array"));
        System.out.println(resolvableType7.isArray());
        System.out.println(resolvableType7.getComponentType().getGeneric(0).resolve());

        //自定义一个泛型数组 List<String>[]
        ResolvableType resolvableType8 = ResolvableType.forClassWithGenerics(List.class, String.class);
        ResolvableType resolvableType9 = ResolvableType.forArrayComponent(resolvableType8);
        System.out.println(resolvableType9.getComponentType().getGeneric(0).resolve());

        //比较两个泛型是否可以赋值成功
        System.out.println(resolvableType7.isAssignableFrom(resolvableType9));

        ResolvableType resolvableType10 = ResolvableType.forClassWithGenerics(List.class, Integer.class);
        ResolvableType resolvableType11 = ResolvableType.forArrayComponent(resolvableType10);
        System.out.println(resolvableType11.getComponentType().getGeneric(0).resolve());

        System.out.println(resolvableType7.isAssignableFrom(resolvableType11));

    }

    private HashMap<String, List<String>> method() {
        return null;
    }

    static class Const {
        public Const(List<List<String>> list, Map<String, Map<String, Integer>> map) {
        }

    }
}

interface GenericTypeInterface<T> {

}

class GenericTypeTest01 implements GenericTypeInterface<ParameterizedTypeTest01> {

}

interface Service<A,B> {

}