package com.zkn.newlearn.anonymousinnerclasses;

/**
 * 匿名内部类的第二个测试
 * 匿名类为继承AnonymousInnerClassInterImpl的类
 * @author zkn
 *
 */

public class AnonymousInnerClassTest02 {

	public AnonymousInnerClassInter test(){
		
		return new AnonymousInnerClassInterImpl(){
			@Override
			public void test() {
				System.out.println("我是第二个匿名内部类的测试");
			}
		};
	}
	
	public static void main(String[] args) {
		AnonymousInnerClassTest02 test = new AnonymousInnerClassTest02();
		AnonymousInnerClassInter inter = test.test();
		inter.test();
		inter.testInnerClass();
	}
}
