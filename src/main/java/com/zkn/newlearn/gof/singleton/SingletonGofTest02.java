package com.zkn.newlearn.gof.singleton;

/**
 * 懒汉式单例模式
 * @author zkn
 *
 */
public class SingletonGofTest02 {

	private static SingletonGofTest02 singleton;
	
	/**
	 * 构造函数私有化
	 */
	private SingletonGofTest02(){
		
	}
	/**
	 * 给对象加锁，性能比较低。
	 * @return
	 */
	public synchronized static SingletonGofTest02 getInstance(){
		
		if(singleton == null){
			
			singleton = new SingletonGofTest02();
			return singleton;
		}
		return singleton;
	}
}
