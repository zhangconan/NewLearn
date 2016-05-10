package com.zkn.newlearn.gof.adapter;

/**
 * 接口的适配器模式
 * 当不希望实现一个接口中所有的方法时，
 * 可以创建一个抽象类Wrapper，实现所有方法，
 * 我们写别的类的时候，继承抽象类即可
 * @see com.zkn.newlearn.gof.adapter.AdapterGofDemo03
 * @author zkn
 *
 */

public class AdapterGofDemo04 extends AdapterGofDemo03{

	@Override
	public void learnEnglish() {
		
		System.out.println("接口的适配器模式........");
	}

}
