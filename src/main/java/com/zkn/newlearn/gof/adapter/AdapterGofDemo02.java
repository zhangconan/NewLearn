package com.zkn.newlearn.gof.adapter;

/**
 * 对象的适配器模式
 * 组合原来存在的类
 * 
 * 适用:当希望将一个对象转换成满足另一个新接口的对象时
 * @author zkn
 *
 */

public class AdapterGofDemo02 implements LearnLanguageInter{

	private LearnLanguage learnLanguage;

	public AdapterGofDemo02(LearnLanguage learnLanguage) {
		this.learnLanguage = learnLanguage;
	}

	public LearnLanguage getLearnLanguage() {
		return learnLanguage;
	}

	public void setLearnLanguage(LearnLanguage learnLanguage) {
		this.learnLanguage = learnLanguage;
	}
	
	@Override
    public void learnEnglish(){
		
		learnLanguage.learnEnglish();
	}
}
