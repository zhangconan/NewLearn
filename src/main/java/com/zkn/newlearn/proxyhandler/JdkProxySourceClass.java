package com.zkn.newlearn.proxyhandler;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.junit.Test;
import sun.misc.ProxyGenerator;

/**
 * 
 * @author zkn 2016-07-06
 *
 */

@SuppressWarnings("restriction")
public class JdkProxySourceClass {

	public static void writeClassToDisk(String path){
		
		byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy4", PersonInterImpl.class.getInterfaces());
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path);
			fos.write(classFile);
			fos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * JDK动态代理
	 */
	@Test 
	public void testJdk(){
		JdkProxyHandler jdk = new JdkProxyHandler();
		PersonInter per = (PersonInter)jdk.createObject(new PersonInterImpl());
		String st = per.test();
		System.out.println(st+"     ");
	}
	
    @Test  
    public void testGenerateProxyClass() {  
    	JdkProxySourceClass.writeClassToDisk("D:/$Proxy4.class");  
    }  
}
