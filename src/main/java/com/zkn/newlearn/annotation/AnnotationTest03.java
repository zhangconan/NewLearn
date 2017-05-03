package com.zkn.newlearn.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试Annotation
 * @author zkn
 *
 */
@AnnotationTest02(getUserName="zhangsan")
public class AnnotationTest03 {

	@AnnotationTest01(color="red")
	public static String testColor(String color){
		System.out.println(color);
		return color;
	}
	
	@AnnotationTest04(getAddress="北京市海淀区")
	String address;
	
	public static void main(String[] args) {
		//获取方法上的注解值
		Method[] methods = AnnotationTest03.class.getDeclaredMethods();
		if(methods != null){
			for(Method method : methods){
				AnnotationTest01 annotation = method.getAnnotation(AnnotationTest01.class);
				if(annotation == null) {
                    continue;
                }
				Method[] me = annotation.annotationType().getDeclaredMethods();
				for(Method meth : me){
					try {
						String color = (String) meth.invoke(annotation,null);
						System.out.println(color);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}

		//获取类上的注解值
		AnnotationTest02 anno = AnnotationTest03.class.getAnnotation(AnnotationTest02.class);
		if(anno != null){
			Method[] met = anno.annotationType().getDeclaredMethods();
			for(Method me : met ){
				if(!me.isAccessible()){
					me.setAccessible(true);
				}
				try {
					System.out.println(me.invoke(anno, null));
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		
		//获取字段上的注解值
		AnnotationTest03 noon = new AnnotationTest03();
		Field[] field = AnnotationTest03.class.getDeclaredFields();
		if(field != null){
			for(Field fie : field){
				if(!fie.isAccessible()){
					fie.setAccessible(true);
				}
				AnnotationTest04 annon = fie.getAnnotation(AnnotationTest04.class);
				Method[] meth = annon.annotationType().getDeclaredMethods();
				for(Method me : meth){
					if(!me.isAccessible()){
						me.setAccessible(true);
					}
					try {
						//给字段重新赋值
						fie.set(noon, me.invoke(annon, null));
						System.out.println(fie.get(noon));
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				}
				
			}
		}
	}
}
