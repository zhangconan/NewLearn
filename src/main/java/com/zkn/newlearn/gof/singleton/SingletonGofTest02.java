package com.zkn.newlearn.gof.singleton;

/**
 * ����ʽ����ģʽ
 * @author zkn
 *
 */
public class SingletonGofTest02 {

	private static SingletonGofTest02 singleton;
	
	/**
	 * ���캯��˽�л�
	 */
	private SingletonGofTest02(){
		
	}
	/**
	 * ��������������ܱȽϵ͡�
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
