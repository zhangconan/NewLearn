package com.zkn.newlearn.tester.gof;

import org.junit.Test;

import com.zkn.newlearn.gof.proxyhandler.CglibProxyHandler;
import com.zkn.newlearn.gof.proxyhandler.JdkProxyHandler;
import com.zkn.newlearn.gof.proxyhandler.PersonInter;
import com.zkn.newlearn.gof.proxyhandler.PersonInterImpl;


public class ProxyHandlerTester {

	/**
	 * JDK动态代理
	 */
	@Test 
	public void testJdk(){
		JdkProxyHandler jdk = new JdkProxyHandler();
		PersonInter per = (PersonInter)jdk.createObject(new PersonInterImpl());
		String st = per.test("");
		System.out.println(st+"     ");
	}
	
	/**
	 * CGLIB动态代理
	 */
	@Test
	public void testCglib(){
		CglibProxyHandler cglib = new CglibProxyHandler();
		PersonInter pre = (PersonInter)cglib.createObject(new PersonInterImpl());
		pre.test("");
	}
}
