package com.zkn.newlearn.annotation;

<<<<<<< HEAD
public @interface AnnotationTest02 {

=======
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AnnotationTest02 {
	
	String getUserName();
>>>>>>> e8b1b93ff21cbde2fb446e81dd836f94782ef6de
}
