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
		System.out.println("ParentÀà¼ÓÔØÆ÷Îª£º"+Parent.class.getClassLoader());
		
	}
	
}
