package com.zkn.newlearn.gof.factory;

/**
 * ��̬����ģʽ
 * @author zkn
 *
 */

public class StaticFactoryTest01 {

	/**
	 * �ʼ�ʵ����
	 * @return
	 */
	public static Sender getMailSender(){
		
		return new MailSenderImpl();
	}
	
	/**
	 * ����ʵ����
	 * @return
	 */
	public static Sender getMessageSender(){
		
		return new MessageSenderImpl();
	}
}
