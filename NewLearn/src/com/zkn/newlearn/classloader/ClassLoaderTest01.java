package com.zkn.newlearn.classloader;

/**
 * @description ͨ���������ø���ľ�̬�ֶΣ����ᵼ�������ʼ����
 * @author zkn
 *
 */

public class ClassLoaderTest01 {

	public static void main(String[] args) {
		System.out.println(SubClass.a);
		/**		
		SubClass sub = new SubClass(); //new����ᵼ�¸���ĳ�ʼ�������Ի�ִ�и����еľ�̬�顣
		sub.getValue();
		*/
		ClassLoaderTest02 t = new ClassLoaderTest02();
	}
}

class SuperClass{
	
	static{
		
		a = 20;
		System.out.println("���ࡢ������");
	}
	public static int a = 14;
}

class SubClass extends SuperClass{
	
	static{
		System.out.println("���ࡣ����������");
	}
	
	public void getValue(){
		System.out.println("a��ֵ�Ƕ��٣�"+a);
	}
	
}
