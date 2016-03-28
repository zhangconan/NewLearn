package com.zkn.newlearn.proxyhandler;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 
 * @author zkn
 *	�����಻��Ϊfinal���ε���
 *	�˴����� �������û��ʵ�ֽӿڵ���
 */

public class CglibProxyHandler implements MethodInterceptor{

	/**
	 * �������
	 */
	private Object targetObj;
	
	public Object createObject(Object obj){
		this.targetObj = obj;
		Enhancer eh = new Enhancer();
		eh.setSuperclass(this.targetObj.getClass());
		eh.setCallback(this);
		return eh.create();
	}
	
	public Object intercept(Object obj, Method arg1, Object[] arg2,
			MethodProxy proxy) throws Throwable {
		
		Object object = proxy.invoke(this.targetObj, arg2);//�����������obj ��������ѭ����
		return object;
	}
	
}
