package com.zkn.newlearn.gof.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.zkn.newlearn.domain.PersonDomain;

/**
 * ԭ�����ģʽ ǳ���� ���
 * @author zkn
 *
 */
public class PrototypeGofTest01 implements Cloneable,Serializable{

	/**
	 * ����
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ����
	 */
	private String name;
	/**
	 * ����
	 */
	private int age;
	/**
	 * ѧУ
	 */
	private String school;
	/**
	 * ��
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
	 * ǳ����
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		PrototypeGofTest01 prototype = (PrototypeGofTest01)super.clone(); 
		return prototype;
	}
	/**
	 * ��� ʵ��˼·���ȰѶ���ѧ���л�Ȼ���ٷ����л�
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
