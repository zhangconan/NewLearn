package com.zkn.newlearn.gof.factory;

/**
 * �ʼ���Ϣ�ṩ��
 * @author zkn
 *
 */
public class AbstractFactoryTest01 implements AbstractInter{

	@Override
	public Sender getSender() {
		
		return new MailSenderImpl();
	}
}
