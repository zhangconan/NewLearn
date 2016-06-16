package com.zkn.newlearn.thread;

/**
<<<<<<< HEAD
 * @description ¶àÏß³Ì
=======
 * @description ï¿½ï¿½ï¿½ß³ï¿½
>>>>>>> e8b1b93ff21cbde2fb446e81dd836f94782ef6de
 * @author zkn
 *
 */

public class ThreadTest01 {

<<<<<<< HEAD

=======
>>>>>>> e8b1b93ff21cbde2fb446e81dd836f94782ef6de
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
<<<<<<< HEAD
	
=======
>>>>>>> e8b1b93ff21cbde2fb446e81dd836f94782ef6de
}

class ThreadTest03 extends Thread{
	@Override
	public void run() {
		System.out.println("aaaaaaaaaaaaaaaaaa");
	}
}