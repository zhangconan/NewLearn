package com.zkn.newlearn.gof.singleton;

/**
 * �ڲ���̬�����ʽʵ�ֵ���ģʽ
 * @author zkn
 *
 */

public class SingletonGofTest03{

	/**
	 * ˽�л����캯��
	 */
	private SingletonGofTest03() {
		
	}
	/**
	 * ��̬�ڲ���
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
	 * ��ֹ�����л�
	 * @return
	 */
	public Object readResolve(){
		
		return getInstance();
	}
}
