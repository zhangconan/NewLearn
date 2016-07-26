package com.zkn.newlearn.anonymousinnerclasses;

/**
 * 匿名内部类的第一个测试
 * 匿名类为实现实现AnonymousInnerClassInter接口的类
 * @author zkn
 *
 */

public class AnonymousInnerClassesTest01 {

	public static void main(String[] args) {
		
		AnonymousInnerClassInter inter = new AnonymousInnerClassInter() {
			@Override
			public void test() {
				System.out.println("这是一个匿名内部类的测试!!!!");
			}

			@Override
			public void testInnerClass() {
				
			}
		};
		inter.test();
	}
}
