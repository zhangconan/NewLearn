package com.zkn.newlearn.tester;

import org.junit.Test;

import com.zkn.newlearn.collection.ImitateArrayListTest01;

import java.util.Arrays;
import java.util.List;

/**
 * 测试集合类
 * @author zkn 
 *
 */

public class CollectionTester01 {

	@Test
	public void testImitateArray(){
		
		ImitateArrayListTest01 listTest = new ImitateArrayListTest01();
		listTest.add("sdsds");
		listTest.add(1258);
		listTest.add(new Integer(222));
		System.out.println(listTest.size());
	}
	@Test
	public void testArrayToList(){
		String str = "sss,dewwe,dwaaawe";
		List list = Arrays.asList(str.split(","));
		System.out.println(list.size());
	}
}
