package com.zkn.newlearn.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zkn on 2017/10/30.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RepeatableAnnos {
    /**
     * 这个方法必须为 value
     *
     * @return
     */
    RepeatableAnno[] value();
}
