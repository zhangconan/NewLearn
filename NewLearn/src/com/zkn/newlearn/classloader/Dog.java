package com.zkn.newlearn.classloader;

/**
 * 
 * @author pc
 *
 */

public class Dog {

	public Dog(){
		System.out.println("Dog 类 ：   类加载器为--"+ Dog.class.getClassLoader());
	}
	
}
