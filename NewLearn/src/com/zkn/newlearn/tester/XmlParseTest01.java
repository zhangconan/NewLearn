package com.zkn.newlearn.tester;

import org.junit.Test;

import com.zkn.newlearn.xml.DomTest01;

/**
 * µ¥Ôª²âÊÔÀà
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
