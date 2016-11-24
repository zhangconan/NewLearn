package com.zkn.newlearn.tester;

import org.apache.commons.collections.ComparatorUtils;
import org.junit.Test;

import com.zkn.newlearn.collection.ImitateArrayListTest01;

import java.util.*;

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
		System.out.println(Arrays.toString(str.split(",")));
		System.out.println(str.split(",")[2]);
	}

	/**
	 * 测试取两个list的合集信息
	 */
	@Test
	public void testHeJiList(){
		List<Long> list1 = new ArrayList<Long>(){
			{
				add(10L);
				add(11L);
				add(12L);
				add(13L);
				add(14L);
				add(15L);
			}
		};
		List<Long> list2 = new ArrayList<Long>(){
			{
				add(10L);
				add(11L);
				add(19L);
				add(20L);
				add(21L);
			}
		};
		//合集 会删除掉list1中的元素，只剩下合集中的元素
		//list1.retainAll(list2);
		//取差集
		//list2.removeAll(list1);
		//得到两个集合的差集
		List<Long> list3 = new ArrayList<Long>(list1);
		List<Long> list4 = new ArrayList<Long>(list2);
		list1.removeAll(list4);
		list2.removeAll(list3);
		System.out.println(Arrays.toString(list1.toArray()));
		System.out.println(Arrays.toString(list2.toArray()));
	}

	/**
	 *	测试Set
	 */
	@Test
	public void testSet(){

		Set<String> set01 = new HashSet<String>();
		set01.add("zhangsan");
		set01.add("zhangsan01");
		set01.add("zhangsan02");
		set01.add("zhangsan03");
		System.out.println(Arrays.toString(set01.toArray()));
	}
	private class ListCompator implements Comparator<String[]>{

		@Override
		public int compare(String[] o1, String[] o2) {

			return o1.length - o2.length;
		}
	}
	@Test
	public void testComparator(){
		List<String[]> lists = new ArrayList<String[]>(){
			{
				add(new String[]{"1","22","3ee"});
				add(new String[]{"1","3ee","ddd","ddddd","ss"});
				add(new String[]{"1","22"});
				add(new String[]{"1","22","3ee","sdwe"});
			}
		};
		Collections.sort(lists,new ListCompator());
		System.out.println(Arrays.toString(lists.get(1)));
	}
}
