package com.zkn.newlearn.classloader;

/**
 * @description 通过子类引用父类的静态字段，不会导致子类初始化。
 * @author zkn
 *
 */

public class ClassLoaderTest01 {

	public static void main(String[] args) {
		System.out.println(SubClass.a);
		/**		
		SubClass sub = new SubClass(); //new子类会导致父类的初始化，所以会执行父类中的静态块。
		sub.getValue();
		*/
		ClassLoaderTest02 t = new ClassLoaderTest02();
	}
}

class SuperClass{
	
	static{
		
		a = 20;
		System.out.println("父类、、、、");
	}
	public static int a = 14;
}

class SubClass extends SuperClass{
	
	static{
		System.out.println("子类。。。。。。");
	}
	
	public void getValue(){
		System.out.println("a的值是多少："+a);
	}
	
}
