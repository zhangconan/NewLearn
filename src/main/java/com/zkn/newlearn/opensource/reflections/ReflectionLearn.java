package com.zkn.newlearn.opensource.reflections;

import com.zkn.newlearn.annotation.AnnotationTest02;
import org.reflections.Reflections;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by zkn on 2017/8/7.
 */
public class ReflectionLearn {

    public static void main(String[] args){

        Reflections reflections = new Reflections("com.zkn.newlearn.annotation");
        Set<Class<?>> set = reflections.getTypesAnnotatedWith(AnnotationTest02.class);
        for(Iterator<Class<?>> it = set.iterator();it.hasNext();){
            System.out.println(it.next());
        }
        System.out.println(set.size());
        System.out.println("结束了、、、、");
    }
}
