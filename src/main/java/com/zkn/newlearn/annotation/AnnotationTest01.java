package com.zkn.newlearn.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
<<<<<<< HEAD
@Target({ElementType.TYPE,ElementType.METHOD})
=======
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.PARAMETER})
>>>>>>> e8b1b93ff21cbde2fb446e81dd836f94782ef6de
public @interface AnnotationTest01 {

	String color();
}
