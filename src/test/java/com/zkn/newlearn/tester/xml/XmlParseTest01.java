package com.zkn.newlearn.tester.xml;

import org.junit.Test;

import com.zkn.newlearn.xml.DomTest01;

/**
 * ��Ԫ������
 * @author zkn
 *
 */

public class XmlParseTest01 {

	@Test
	public void testTest01(){
		DomTest01 dom = new DomTest01();
		dom.init();
		dom.createXml("D:\\log4j\\xml\\domxml01.xml"); 
	}
}
