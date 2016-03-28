package com.zkn.newlearn.gof.singleton;

/**
 * ����ʽ����ģʽ
 * @author zkn
 *
 */
public class SingletonGofTest01 {

	private static SingletonGofTest01 singleton = new SingletonGofTest01();

	private SingletonGofTest01() {
		
	}
	
	public static SingletonGofTest01 getInstance(){
		
		return singleton;
	}
	
	
}
