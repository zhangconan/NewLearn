package com.zkn.newlearn.tester.gof;


import com.zkn.newlearn.gof.singleton.*;
import org.junit.Test;

import com.zkn.newlearn.gof.factory.AbstractFactoryTest01;
import com.zkn.newlearn.gof.factory.AbstractInter;
import com.zkn.newlearn.gof.factory.Sender;
import com.zkn.newlearn.gof.factory.StaticFactoryTest01;

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

	/**
     * 单例模式测试类
     * @author zkn
     *
     */

    public static class SingletonGofTest {

        /**
         * 饿汉模式测试类
         */
        @Test
        public void testHungrySingleton(){

            SingletonGofTest01 singleton1 = SingletonGofTest01.getInstance();
            SingletonGofTest01 singleton2 = SingletonGofTest01.getInstance();
            System.out.println(singleton1==singleton2);
        }

        /**
         * 懒汉模式测试类
         */
        @Test
        public void testLazySingleton(){

            SingletonGofTest02 singleton1 = SingletonGofTest02.getInstance();
            SingletonGofTest02 singleton2 = SingletonGofTest02.getInstance();
            System.out.println(singleton1==singleton2);
        }
        /**
         * 静态内部类测试类
         */
        @Test
        public void testStaticSingleton(){

            SingletonGofTest03 singleton1 = SingletonGofTest03.getInstance();
            SingletonGofTest03 singleton2 = SingletonGofTest03.getInstance();
            System.out.println(singleton1==singleton2);
        }
        /**
         * 枚举类测试类
         */
        @Test
        public void testEnumSingleton(){

            SingletonGofTest04 singleton1 = SingletonGofTest04.singleton;
            SingletonGofTest04 singleton2 = SingletonGofTest04.singleton;
            System.out.println(singleton1==singleton2);
        }
    }
}
