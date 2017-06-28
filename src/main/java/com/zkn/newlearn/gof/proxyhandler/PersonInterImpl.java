package com.zkn.newlearn.gof.proxyhandler;

import java.lang.reflect.Method;

/**
 * 
 * @author zkn
 *
 */

public class PersonInterImpl implements PersonInter {

	@Override
    public String test() {

		System.out.println("动态代理测试。。。。。。。。。。。。。");
		System.out.println("动态代理测试。。。。。。。。。。。。。");
		return "111";
	}
	
	public static void main(String[] args) {
		
		JdkProxyHandler jdk = new JdkProxyHandler();
		PersonInter per = (PersonInter) jdk.createObject(new PersonInterImpl());
		System.out.println(per.getClass().getName());
		Method[] methods =  per.getClass().getMethods();
		for(Method method : methods){
			System.out.println(method.getName());
		}
		per.test();
		
		CglibProxyHandler cglib = new CglibProxyHandler();
		PersonInter pre = (PersonInter)cglib.createObject(new PersonInterImpl());
		pre.test();
	}
	
}
