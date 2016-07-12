package com.zkn.newlearn.gof.singleton;

import com.zkn.newlearn.gof.factory.MailSenderImpl;
import com.zkn.newlearn.gof.factory.MessageSenderImpl;
import com.zkn.newlearn.gof.factory.Sender;

/**
 * 简单工厂模式
 * @author zkn
 *
 */

public class SimpleFactoryTest01 {

	public Sender getProduce(String fac){
		if("main".equals(fac)){
			return new MailSenderImpl();
		}else if("message".equals(fac)){
			return new MessageSenderImpl();
		}
		return new MailSenderImpl();
	}
}
