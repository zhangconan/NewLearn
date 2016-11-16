package com.zkn.newlearn.gof.factory;

/**
 * 短信信息提供者提供者
 * @author zkn
 *
 */

public class AbstractFactoryTest02 implements AbstractInter {

	@Override
	public Sender getSender() {
		
		return new MessageSenderImpl();
	}

}
