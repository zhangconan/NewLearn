package com.zkn.newlearn.tester;

import org.junit.Test;

import com.zkn.newlearn.gof.adapter.AdapterGofDemo01;
import com.zkn.newlearn.gof.adapter.AdapterGofDemo02;
import com.zkn.newlearn.gof.adapter.AdapterGofDemo04;
import com.zkn.newlearn.gof.adapter.AdapterGofDemo05;
import com.zkn.newlearn.gof.adapter.LearnLanguage;
import com.zkn.newlearn.gof.adapter.LearnLanguageInter;
import com.zkn.newlearn.gof.adapter.LearnLanguageMuiInter;

/**
 * ������ģʽ��Ԫ������
 * @author zkn
 *
 */
public class AdapterGofTest01 {

	/**
	 * �������������ģʽ
	 */
	@Test
	public void testClassAdapter(){
		
		LearnLanguageInter adapter = new AdapterGofDemo01();
		adapter.learnEnglish();
	}
	/**
	 * ���Զ����������ģʽ
	 */
	@Test
	public void testObjectAdapter(){
		
		LearnLanguageInter adapter = new AdapterGofDemo02(new LearnLanguage());
		adapter.learnEnglish();
	}
	/**
	 * �������������ģʽ
	 */
	@Test
	public void testInterfaceAdapter(){
		
		LearnLanguageMuiInter adapter = new AdapterGofDemo04();
		adapter.learnEnglish();
		
		LearnLanguageMuiInter adapter1 = new AdapterGofDemo05();
		adapter1.learnChinese();
	}
}
