package com.zkn.newlearn.jvm.classloader;

/**
 * 
 * @author pc
 *
 */

public class Dog {

	public Dog(){
		System.out.println("Dog"+ Dog.class.getClassLoader());
	}
	
}
