package com.zkn.newlearn.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

/**
 * 
 * @author zkn
 *
 */

public class DomTest02 {

	/**
	 * @param fileName
	 */
	public void createXml(String fileName){
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document document = builder.newDocument();
			document.createElement(null);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
	
}
