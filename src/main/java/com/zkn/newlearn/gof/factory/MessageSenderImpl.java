package com.zkn.newlearn.gof.factory;

/**
 * 
 * @author zkn
 *
 */

public class MessageSenderImpl implements Sender{

	@Override
	public void doSend() {

		System.out.println("发送短信。。。。。");
	}
}
