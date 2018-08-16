package com.zkn.newlearn.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 
 * @author zkn
 *
 */

public class ClassLoaderTest04 extends ClassLoader {

	/**
	 * 路径
	 */
	private String path = "";
	/**
	 * 后缀名
	 */
	private String className = ".class";
	
	private String name = "";
	
	private ClassLoader loader = null;
	
	@Override
	protected Class<?> findClass(String name) {
		byte[] b =loadClassData(name);
		if(b != null && b.length > 0) {
            return defineClass(name, b, 0, b.length);
        }
		return this.getClass(); 
	}
	
	@SuppressWarnings("null")
	private byte[] loadClassData(String names) {
		names = names.replace(".", "\\");
		String clazzName = path + names + className;
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		byte[] bytes = new byte[0];
		int i = 0;
		try{
			is = new FileInputStream(new File(clazzName));
			baos = new ByteArrayOutputStream();
			while(-1!=(i = is.read())){
				baos.write(i);
			}
			bytes = baos.toByteArray();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(is != null) {
                    is.close();
                }
				if(baos != null) {
                    baos.close();
                }
			}catch(Exception ee){
				ee.printStackTrace();
			}
		}
		return bytes;
	}

	public ClassLoaderTest04(String name) {
		super();
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "   "+name;
	}
	
	public ClassLoaderTest04(String name, ClassLoader loader) {
		super(loader);
		this.name = name;
		this.loader = loader;
	}

	public static void main(String[] args) throws Exception{
		ClassLoaderTest04 loader1 = new ClassLoaderTest04("loader1");
		loader1.setPath("D:\\log4j\\sys\\");
		
		ClassLoaderTest04 loader2 = new ClassLoaderTest04("loader2",loader1);
		loader2.setPath("D:\\log4j\\common\\");
		
		ClassLoaderTest04 loader3 = new ClassLoaderTest04("loader3",null);
		loader3.setPath("D:\\log4j\\common\\");
		
		try{
			test(loader2,"Parent");
		}catch(Exception e){
			loader2 = new ClassLoaderTest04("loader02");
			loader2.setPath("D:\\log4j\\common\\");
			test(loader2,"Parent");
		}
		test(loader3,"Parent");
	}

	private static void test(ClassLoader loader,String name)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		Class clazz = null;
		try{
			clazz = loader.loadClass(name);
		}catch(Exception e){
			e.printStackTrace();
		}
		clazz.newInstance();
	}
	
}
