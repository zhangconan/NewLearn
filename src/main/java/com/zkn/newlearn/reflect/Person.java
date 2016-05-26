package com.zkn.newlearn.reflect;

/**
 * 
 * @author zkn
 *
 */

public class Person {

	private int age;
	
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(int age, String name) {
		
		this.age = age;
		this.name = name;
	}

	public Person() {
		
	}
	
	private void getValue(){
		
		System.out.println(name + age);
	}
	
}
