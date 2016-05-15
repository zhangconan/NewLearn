package com.zkn.newlearn.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 
 * @author zkn
 *
 */

public class ReflectTest01 {

	public static void main(String[] args) {
		Person person = new Person(30,"ÕÅÈý");
		try {
			Class<?> clazz = Class.forName("com.zkn.newlearn.reflect.Person");
			Method methods = clazz.getDeclaredMethod("getValue",null);
			methods.setAccessible(true);
			Object obj = methods.invoke(person, null);
			System.out.println(obj);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
}
