package com.zkn.newlearn.gof.adapter;

/**
 * �����������ģʽ
 * ���ԭ�����ڵ���
 * 
 * ����:��ϣ����һ������ת����������һ���½ӿڵĶ���ʱ
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
	
	public void learnEnglish(){
		
		learnLanguage.learnEnglish();
	}
}
