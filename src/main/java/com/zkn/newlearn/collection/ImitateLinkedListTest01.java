package com.zkn.newlearn.collection;

import java.util.LinkedList;

/**
 * 
 * @author	zkn
 *	LinkedList的数据结构是双向链表
 */

public class ImitateLinkedListTest01<E> {

	Node<E> first; 
	Node<E> last;
	int size;
	
	public int size(){
		
		return size;
	}
	
	public void add(E e){
		//双向链表
		//第一步 最后一个元素为空不为空  如果为空 说明是第一次add的操作
		if(last == null){
			Node<E> node = new Node<E>(e,null,null);
			//对于第一个元素 首是它 尾也是它
			first = node;
			last = node;
		}else{
			//如果不是第一次add 则当前要插入的 前一个元素是 last 下一个元素是null
			Node<E> node = new Node<E>(e,last,null);
			//当前最后一个元素的下一个元素是  当前要插入的元素
			last.next = node;
			//需要把当前插入的元素 变为 最后一个元素
			last = node;
		}
		size++;
	}
	
	private static class Node<E>{
		E item;
		Node<E> next;
		Node<E> prev;
		public Node(E item, Node<E> prev, Node<E> next) {
			
			this.item = item;
			this.next = next;
			this.prev = prev;
		}
	}
	
	public static void main(String[] args) {
		LinkedList<String> linked = new LinkedList<String>();
		linked.add("zhangsan");
		linked.add("lisi");
		linked.add("wangwu");
		
		ImitateLinkedListTest01<String> linkedTest = new ImitateLinkedListTest01<String>();
		linkedTest.add("zhangsan");
		linkedTest.add("lisi");
		linkedTest.add("wangwu");
		linkedTest.add("maliu");
	}
}
