package com.zkn.newlearn.gof.factory;

/**
 * 邮件信息提供者
 * @author zkn
 *
 */
public class AbstractFactoryTest01 implements AbstractInter{

	@Override
	public Sender getSender() {
		
		return new MailSenderImpl();
	}
}
