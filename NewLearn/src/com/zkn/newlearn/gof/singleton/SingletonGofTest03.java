package com.zkn.newlearn.gof.singleton;

/**
 * 内部静态类的形式实现单例模式
 * @author zkn
 *
 */

public class SingletonGofTest03{

	/**
	 * 私有化构造函数
	 */
	private SingletonGofTest03() {
		
	}
	/**
	 * 静态内部类
	 * @author zkn
	 *
	 */
	private static class InstanceSingleton{
		
		private static SingletonGofTest03 singleton = new SingletonGofTest03();
	}
	
	public static SingletonGofTest03 getInstance(){
		
		return InstanceSingleton.singleton;
	}
	/**
	 * 防止被序列化
	 * @return
	 */
	public Object readResolve(){
		
		return getInstance();
	}
}
