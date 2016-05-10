package com.zkn.newlearn.thread;

/**
 * @description ∂‡œﬂ≥Ã
 * @author zkn
 *
 */

public class ThreadTest01 {


	public static void main(String[] args) {
		
		Runnable run = new Runnable() {
			
			public void run() {
				System.out.println("ddddddddddddd");
			}
		};
		
		Thread thread1 = new Thread(run);
		Thread thread2 = new Thread(new ThreadTest03());
		thread1.start();
		thread2.start();
	}
	
}

class ThreadTest03 extends Thread{
	@Override
	public void run() {
		System.out.println("aaaaaaaaaaaaaaaaaa");
	}
}