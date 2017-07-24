package com.zkn.newlearn.gof.proxyhandler;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 
 * @author zkn
 *	代理类不能为final修饰的类
 *	此代理类 代理的是没有实现接口的类
 */

public class CglibProxyHandler implements MethodInterceptor{

	/**
	 * 代理对象
	 */
	private Object targetObj;
	
	public Object createObject(Object obj){
		this.targetObj = obj;
		Enhancer eh = new Enhancer();
		eh.setSuperclass(this.targetObj.getClass());
		eh.setCallback(this);
		return eh.create();
	}
	
	@Override
    public Object intercept(Object obj, Method arg1, Object[] arg2,
                            MethodProxy proxy) throws Throwable {
		
		Object object = proxy.invoke(this.targetObj, arg2);//这里如果换成obj 会陷入死循环中
		return object;
	}
	
}
