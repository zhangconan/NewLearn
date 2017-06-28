package com.zkn.newlearn.gof.proxyhandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * @author zkn
 * 此代理类 代理实现接口的类
 *
 */

public class JdkProxyHandler implements InvocationHandler {

	private Object targetObject;
	
	public Object createObject(Object obj){
		this.targetObject = obj;
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), 
				targetObject.getClass().getInterfaces(), this);
	}
	
	@Override
    public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		return method.invoke(targetObject, args);
	}
	
}
