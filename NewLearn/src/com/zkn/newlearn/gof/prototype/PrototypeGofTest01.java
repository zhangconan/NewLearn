package com.zkn.newlearn.gof.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.zkn.newlearn.domain.PersonDomain;

/**
 * 原型设计模式 浅拷贝 深拷贝
 * @author zkn
 *
 */
public class PrototypeGofTest01 implements Cloneable,Serializable{

	/**
	 * 序列
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 名字
	 */
	private String name;
	/**
	 * 年龄
	 */
	private int age;
	/**
	 * 学校
	 */
	private String school;
	/**
	 * 人
	 */
	private PersonDomain personDomain;
	
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

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public PersonDomain getPersonDomain() {
		return personDomain;
	}

	public void setPersonDomain(PersonDomain personDomain) {
		this.personDomain = personDomain;
	}

	/**
	 * 浅拷贝
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		PrototypeGofTest01 prototype = (PrototypeGofTest01)super.clone(); 
		return prototype;
	}
	/**
	 * 深拷贝 实现思路：先把对象学序列化然后再反序列化
	 * @return
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public Object deepClone() throws IOException, ClassNotFoundException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream object = new ObjectOutputStream(bos);
		object.writeObject(this);
		
		ObjectInputStream objectin = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
		return objectin.readObject();
	}
	
	@Override
	public String toString() {
		return "PrototypeGofTest01 [name=" + name + ", age=" + age
				+ ", school=" + school + ", personDomain=" + personDomain + "]";
	}
	
}
