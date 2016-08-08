package com.zkn.newlearn.tester;

import org.junit.Test;

import com.zkn.newlearn.gof.singleton.SingletonGofTest01;
import com.zkn.newlearn.gof.singleton.SingletonGofTest02;
import com.zkn.newlearn.gof.singleton.SingletonGofTest03;
import com.zkn.newlearn.gof.singleton.SingletonGofTest04;


/**
 * 单例模式测试类
 * @author zkn
 *
 */

public class SingletonGofTest {

	/**
	 * 饿汉模式测试类
	 */
	@Test
	public void testHungrySingleton(){
		
		SingletonGofTest01 singleton1 = SingletonGofTest01.getInstance();
		SingletonGofTest01 singleton2 = SingletonGofTest01.getInstance();
		System.out.println(singleton1==singleton2);
	}
	
	/**
	 * 懒汉模式测试类
	 */
	@Test
	public void testLazySingleton(){
		
		SingletonGofTest02 singleton1 = SingletonGofTest02.getInstance();
		SingletonGofTest02 singleton2 = SingletonGofTest02.getInstance();
		System.out.println(singleton1==singleton2);
	}
	/**
	 * 静态内部类测试类
	 */
	@Test
	public void testStaticSingleton(){
		
		SingletonGofTest03 singleton1 = SingletonGofTest03.getInstance();
		SingletonGofTest03 singleton2 = SingletonGofTest03.getInstance();
		System.out.println(singleton1==singleton2);
	}
	/**
	 * 枚举类测试类
	 */
	@Test
	public void testEnumSingleton(){
		
		SingletonGofTest04 singleton1 = SingletonGofTest04.singleton;
		SingletonGofTest04 singleton2 = SingletonGofTest04.singleton;
		System.out.println(singleton1==singleton2);
	}
}
