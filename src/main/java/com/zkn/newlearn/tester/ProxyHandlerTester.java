package com.zkn.newlearn.tester;

import org.junit.Test;

import com.zkn.newlearn.proxyhandler.CglibProxyHandler;
import com.zkn.newlearn.proxyhandler.JdkProxyHandler;
import com.zkn.newlearn.proxyhandler.PersonInter;
import com.zkn.newlearn.proxyhandler.PersonInterImpl;


public class ProxyHandlerTester {

	/**
	 * JDK动态代理
	 */
	@Test 
	public void testJdk(){
		JdkProxyHandler jdk = new JdkProxyHandler();
		PersonInter per = (PersonInter)jdk.createObject(new PersonInterImpl());
		String st = per.test();
		System.out.println(st+"     ");
	}
	
	/**
	 * CGLIB动态代理
	 */
	@Test
	public void testCglib(){
		CglibProxyHandler cglib = new CglibProxyHandler();
		PersonInter pre = (PersonInter)cglib.createObject(new PersonInterImpl());
		pre.test();
	}
}
