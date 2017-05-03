package com.zkn.newlearn.gof.factory;

/**
 * 
 * @author zkn
 *
 */

public class MailSenderImpl implements Sender{

	@Override
    public void doSend() {
		
		System.out.println("邮件发送。。。。");
	}
}
