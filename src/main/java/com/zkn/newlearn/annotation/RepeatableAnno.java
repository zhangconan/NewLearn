package com.zkn.newlearn.annotation;

import java.lang.annotation.*;

/**
 * Created by zkn on 2017/10/30.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(RepeatableAnnos.class)
public @interface RepeatableAnno {

    String role();
}
