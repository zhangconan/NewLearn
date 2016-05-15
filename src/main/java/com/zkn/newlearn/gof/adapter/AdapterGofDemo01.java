package com.zkn.newlearn.gof.adapter;

/**
 * 类的适配器模式:
 * 目标类继承原来的类并实现一个适配器接口，但是适配器接口中的方法由原来的类来实现
 * 类的适配器模式是用原来存在的类来继承并实现接口中的方法。
 * 
 * 适用：当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式
 * @see com.zkn.newlearn.gof.adapter.LearnLanguage
 * @see com.zkn.newlearn.gof.adapter.LearnLanguageInter
 * @author zkn
 *
 */
public class AdapterGofDemo01 extends LearnLanguage implements LearnLanguageInter{

	
}
