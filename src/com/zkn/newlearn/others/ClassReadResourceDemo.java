package com.zkn.newlearn.others;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.zkn.newlearn.gof.singleton.SimpleFactoryTest01;

/**
 * ��ȡ��Դ�ļ������ַ�ʽ
 * @author zkn
 */

public class ClassReadResourceDemo {

	public static void main(String[] args) {
		/**
		 * ��һ�ַ�ʽ �����������ȡ��Դ�ļ���
		 * �������Σ���Դ�ļ������ļ��ڲ���ͬһĿ¼�����ԡ�
		 * ע�⣺getResourceAsStream��Ĳ���Ҫ
		 * д��Դ�ļ���ȫ�޶�·��������+�ļ���
		 * ��ͷǧ��Ҫд"/"
		 */
		InputStream is = ClassReadResourceDemo.class.
				getClassLoader().getResourceAsStream("com/zkn/newlearn/io/config.properties");
		Properties prop = new Properties();
		try {
			prop.load(is);
			System.out.println(prop.getProperty("key"));
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**
		 * �ڶ���д������class.getResourceAsStream()(��ʵ�����õ��������)
		 * �������Σ������Դ�ļ������ļ���ͬһ���£�ֱ��д��Դ�ļ������ƾ����ˣ�
		 * ע�⣺��Դ�ļ�������ǰ�治��Ҫ�ӡ�/��
		 */
		is = ClassReadResourceDemo.class.getResourceAsStream("config.properties");
		try {
			prop.load(is);
			System.out.println(prop.getProperty("key"));
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**
		 * ������д������class.getResourceAsStream()(��ʵ�����õ��������)
		 * �������Σ����д�����õ���������Դ�ļ������ļ�����ͬһ��Ŀ¼�µ����
		 * ע�⣺��ͷһ��Ҫ���ϡ�/��
		 */
		is = ClassReadResourceDemo.class.getResourceAsStream("/com/zkn/newlearn/io/config.properties");
		try {
			prop.load(is);
			System.out.println(prop.getProperty("key"));
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**
		 * ������д��:��class.getResourceAsStream()
		 * �������Σ�����д����������Դ�ļ��ڸ�Ŀ¼�µ����
		 * ע�⣺�ļ�����ǰ��һ��Ҫ���ϡ�/��
		 */
		is = ClassReadResourceDemo.class.getResourceAsStream("/config.properties");
		try {
			prop.load(is);
			System.out.println(prop.getProperty("key"));
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**
		 * ������д�����������������ȡ��Դ�ļ�
		 * �������Σ���Դ�ļ��ڸ�Ŀ¼��
		 * ע�⣺��Դ�ļ�����ǰ��һ����Ҫ�ӡ�/��
		 */
		is = ClassReadResourceDemo.class.getClassLoader().getResourceAsStream("config.properties");
		try {
			prop.load(is);
			System.out.println(prop.getProperty("key"));
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
