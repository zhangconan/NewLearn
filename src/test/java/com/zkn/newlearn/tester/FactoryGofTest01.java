package com.zkn.newlearn.tester;


import org.junit.Test;

import com.zkn.newlearn.gof.factory.AbstractFactoryTest01;
import com.zkn.newlearn.gof.factory.AbstractInter;
import com.zkn.newlearn.gof.factory.Sender;
import com.zkn.newlearn.gof.factory.StaticFactoryTest01;
import com.zkn.newlearn.gof.singleton.SimpleFactoryTest01;

public class FactoryGofTest01 {

	/**
	 * 测试简单工厂
	 */
	@Test
	public void testSimpleFactory() {
		
		SimpleFactoryTest01 simple = new SimpleFactoryTest01();
		Sender sender = simple.getProduce("message");
		sender.doSend();
	}

	/**
	 * 测试静态工厂
	 */
	@Test
	public void testStaticFactory(){
		
		//Sender sender = StaticFactoryTest01.getMailSender();
		Sender sender = StaticFactoryTest01.getMessageSender();
		sender.doSend();
	}
	
	/**
	 * 测试抽象工厂
	 */
	@Test
	public void testAbstraceFactory(){
		
		AbstractInter abs = new AbstractFactoryTest01();
		Sender send = abs.getSender();
		send.doSend();
	}
}
