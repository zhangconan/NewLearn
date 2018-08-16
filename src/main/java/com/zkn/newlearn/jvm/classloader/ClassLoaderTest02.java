package com.zkn.newlearn.jvm.classloader;

/**
 *
 * @author zkn
 *
 */

class MainClass{

	public static int a;
	public static MainClass clt = new MainClass();
	public static int b = 0;
	/**
	 *
	 static{
	 a = 20;
	 System.out.println("a=:"+a);
	 }
	 { //构造块 初始化一次 执行一次
	 //a = 23;
	 b = 14;
	 System.out.println("a=:"+a+" b=:"+b);
	 }
	 */

	private MainClass() {
		a++;
		b++;
	}

	public static MainClass getInstance(){

		return clt;
	}

	private int c = 0;
}

class ClassLoaderTest02 {


	public static void main(String[] args) {

		MainClass cl = MainClass.getInstance();
		System.out.println(MainClass.a +" "+ MainClass.b);
	}

}



