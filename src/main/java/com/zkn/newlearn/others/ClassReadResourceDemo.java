package com.zkn.newlearn.others;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.zkn.newlearn.gof.singleton.SimpleFactoryTest01;

/**
 * 读取资源文件的五种方式
 * @author zkn
 */

public class ClassReadResourceDemo {

	public static void main(String[] args) {
		/**
		 * 第一种方式 用类加载器读取资源文件。
		 * 适用情形：资源文件和类文件在不在同一目录都可以。
		 * 注意：getResourceAsStream里的参数要
		 * 写资源文件的全限定路径，包名+文件名
		 * 开头千万不要写"/"
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
		 * 第二种写法：用class.getResourceAsStream()(其实还是用的类加载器)
		 * 适用情形：如果资源文件和类文件在同一包下，直接写资源文件的名称就行了，
		 * 注意：资源文件的名称前面不需要加“/”
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
		 * 第三种写法：用class.getResourceAsStream()(其实还是用的类加载器)
		 * 适用情形：这个写法适用的情形是资源文件和类文件不在同一个目录下的情况
		 * 注意：开头一定要加上”/“
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
		 * 第四种写法:用class.getResourceAsStream()
		 * 适用情形：这种写法适用于资源文件在根目录下的情况
		 * 注意：文件名称前面一定要加上”/“
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
		 * 第五种写法：用类加载器来读取资源文件
		 * 适用情形：资源文件在跟目录下
		 * 注意：资源文件名称前面一定不要加”/“
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
