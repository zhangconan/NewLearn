package com.zkn.newlearn.classloader;

/**
 * 
 * @author zkn
 *
 */

public class Parent {

	public static int i = 1;
	
	public Parent(){
		
		new Dog();
		System.out.println("Parent类加载器为："+Parent.class.getClassLoader());
		
	}
	
}
