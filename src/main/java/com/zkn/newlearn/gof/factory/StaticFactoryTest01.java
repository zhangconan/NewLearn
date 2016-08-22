package com.zkn.newlearn.gof.factory;

/**
 * 静态工厂模式
 * @author zkn
 *
 */

public class StaticFactoryTest01 {

	/**
	 * 邮件实现类
	 * @return
	 */
	public static Sender getMailSender(){
		
		return new MailSenderImpl();
	}
	
	/**
	 * 短信实现类
	 * @return
	 */
	public static Sender getMessageSender(){
		
		return new MessageSenderImpl();
	}
}
