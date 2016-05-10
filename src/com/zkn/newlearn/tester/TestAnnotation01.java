package com.zkn.newlearn.tester;

import java.lang.annotation.Annotation;

import com.zkn.newlearn.annotation.AnnotationTest01;

@AnnotationTest01(color="red")
public class TestAnnotation01 {

	public static void main(String[] args) {
		
		if(TestAnnotation01.class.isAnnotationPresent(AnnotationTest01.class)){
			AnnotationTest01 an = TestAnnotation01.class.getAnnotation(AnnotationTest01.class);
			System.out.println("有注解。。。。。。");
			System.out.println(an.color());
		}else{
			System.out.println("没有注解");
		}
	}
}
