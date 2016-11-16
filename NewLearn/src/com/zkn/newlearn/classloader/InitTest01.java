package com.zkn.newlearn.classloader;

/**
 * 
 * @author zkn
 *
 */

public class InitTest01 {

	public static InitTest01 test = new InitTest01();
	public static int a;
	public static int b = 0;
	
	static{
		System.out.println("static block ..........");
	}
	
	public static InitTest01 test1 = new InitTest01();
	public static InitTest01 test2 = new InitTest01();
	
	{
		System.out.println("更夛旗鷹翠。。。。。。。。。");
	}
	
	public InitTest01() {
		a ++ ;
		b ++;
	}
	
	public static void main(String[] args) {
		new InitTest01();
		//InitTest01 te = null;
		System.out.println(InitTest01.a + "  &&&&&");
		System.out.println(InitTest01.b + "  &&&&&");
	}
	
}
