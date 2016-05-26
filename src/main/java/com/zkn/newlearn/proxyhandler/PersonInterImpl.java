package com.zkn.newlearn.proxyhandler;

/**
 * 
 * @author zkn
 *
 */

public class PersonInterImpl implements PersonInter {

	public String test() {

		System.out.println("动态代理测试。。。。。。。。。。。。。");
		System.out.println("动态代理测试。。。。。。。。。。。。。");
		return "111";
	}
	
	public static void main(String[] args) {
		
		JdkProxyHandler jdk = new JdkProxyHandler();
		PersonInter per = (PersonInter) jdk.createObject(new PersonInterImpl());
		per.test();
		
		CglibProxyHandler cglib = new CglibProxyHandler();
		PersonInter pre = (PersonInter)cglib.createObject(new PersonInterImpl());
		pre.test();
	}
	
}
