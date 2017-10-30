package com.zkn.newlearn.annotation;

import java.lang.reflect.Method;

/**
 * Created by zkn on 2017/10/30.
 */
public class RepeatableAnnoTest {

    @RepeatableAnno(role = "admin")
    @RepeatableAnno(role = "employee")
    public void validatorRole() {

    }

    public static void main(String[] args) {
        //获取Clazz
        Class clazz = RepeatableAnnoTest.class;
        Method[] methods = clazz.getDeclaredMethods();
        if (methods != null && methods.length > 0) {
            for (Method method : methods) {
                RepeatableAnno[] repeatable = method.getAnnotationsByType(RepeatableAnno.class);
                if (repeatable != null && repeatable.length > 0) {
                    System.out.println("获取RepeatableAnno的值");
                    for (RepeatableAnno repeatableAnno : repeatable) {
                        System.out.println(repeatableAnno.role());
                    }
                }
                RepeatableAnnos repeatableAnnos = method.getAnnotation(RepeatableAnnos.class);
                if (repeatableAnnos != null) {
                    RepeatableAnno[] repeatables = repeatableAnnos.value();
                    if (repeatable != null && repeatable.length > 0) {
                        System.out.println("获取RepeatableAnnos的值");
                        for (RepeatableAnno repeatableAnno : repeatable) {
                            System.out.println(repeatableAnno.role());
                        }
                    }
                }
            }
        }
    }
}
