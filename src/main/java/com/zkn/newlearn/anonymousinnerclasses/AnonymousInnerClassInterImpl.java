package com.zkn.newlearn.anonymousinnerclasses;

/**
 * 我是一个匿名内部类
 * @author zkn
 *
 */

public class AnonymousInnerClassInterImpl implements AnonymousInnerClassInter{

	@Override
    public void test(){
		
		System.out.println("我是一个匿名内部类");
	}

	@Override
	public void testInnerClass() {
		System.out.println("这是一个匿名内部类的测试");
	}
}
