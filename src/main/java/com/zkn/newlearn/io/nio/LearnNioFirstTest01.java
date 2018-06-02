package com.zkn.newlearn.io.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * 学习NIO的第一个例子
 * @author zkn 2016-07-31
 *
 */

public class LearnNioFirstTest01 {

	public static void main(String[] args) {
		CharBuffer cbfer = CharBuffer.allocate(20);
		String str = "zhangsanlisi";
		for(int i=0;i<str.length();i++){
			cbfer.put(str.charAt(i));
		}
		//bbfer.flip();
		while(cbfer.hasRemaining()){
			System.out.print(cbfer.get());
		}
		System.out.println("");
		
		ByteBuffer bbfer = ByteBuffer.allocate(20);
		String stra = "zhangsanlisi";
		bbfer.put(stra.getBytes());
		bbfer.flip();
		int count = bbfer.remaining();
		byte[] bytes = new byte[count];
		for(int i=0;i<count;i++){
			bytes[i] = bbfer.get();
		}
		System.out.println(new String(bytes));
	}
}
