package com.zkn.newlearn.gof.factory;

/**
 * ������Ϣ�ṩ���ṩ��
 * @author zkn
 *
 */

public class AbstractFactoryTest02 implements AbstractInter {

	@Override
	public Sender getSender() {
		
		return new MessageSenderImpl();
	}

}
