package com.zkn.newlearn.domain;

import java.io.Serializable;

/**
 * Person对象
 * @author zkn
 *
 */

public class PersonDomain implements Serializable{

	/**
	 * 序列
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 年龄
	 */
	private int age;

	private StudentDomain studentDomain;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "PersonDomain [name=" + name + ", age=" + age + "]";
	}

	public StudentDomain getStudentDomain() {
		return studentDomain;
	}

	public void setStudentDomain(StudentDomain studentDomain) {
		this.studentDomain = studentDomain;
	}
}
