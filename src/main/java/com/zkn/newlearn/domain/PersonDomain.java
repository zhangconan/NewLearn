package com.zkn.newlearn.domain;

import java.io.Serializable;
import java.util.Date;

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
	/**
	 * 出生日期
	 */
	private Date birthDay;
	/**
	 * 地址
	 */
	private String address;

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
		return "PersonDomain [name=" + name + ", age=" + age +",birthDay="+(birthDay==null?"birthDay位空":birthDay.getTime())+","+ address +"]";
	}

	public StudentDomain getStudentDomain() {
		return studentDomain;
	}

	public void setStudentDomain(StudentDomain studentDomain) {
		this.studentDomain = studentDomain;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
