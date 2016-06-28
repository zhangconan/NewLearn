package com.zkn.newlearn.collection;

/**
 * 
 * @author zkn 2016-06-25
 *	LinkedList的内部数据结构是双向链表，
 *	所以定义一个内部类，用来表示一个节点，
 *	这个节点包括三个属性，
 *		1、一个用来表示当前元素
 *		2、一个用来表示上一个元素
 *		3、一个用来表示下一个元素
 *	还需要两个属性节点用来保存链表的头和尾
 */

public class ImitateLinkedListTest02<E> {
	/**
	 * 表示头部
	 */
	private Node<E> first;
	/**
	 * 表示尾部
	 */
	private Node<E> last;
	/**
	 * size的大小
	 */
	private int size;
	/**
	 * 元素的个数
	 */
	public int size(){
		
		return size;
	}
	/**
	 * add的方法
	 * @param e
	 */
	public void add(E e){
		//说明这个时候还没有进行过add操作，即链表中没有元素
		if(last == null){
			//创建一个新的节点
			//对于第一个节点，它的上一个元素为不存在所以为null，下一个元素同样为null
			Node<E> newNode = new Node<E>(e,null,null);
			//在这个链表中，第一个元素为当前要插入的节点，最后一个元素同样为当前要插入的节点
			first = newNode;
			last = newNode;
		}else{
			//对于链表中已经存在元素节点的情况
			//创建出来一个新的节点
			//对于这种链表中已经有几点存在的情况，它的上一个节点为最后一个元素，下一个节点为null
			Node<E> newNode = new Node<E>(e,last,null);
			//当前的最后一个元素的下一个节点应该指向当前要插入的这个节点。
			//当前最后一个元素的下一个节点指向当前要插入的节点，当前要插入的节点的上一个元素指向当前的最后一个元素
			//这样正好构成了一个双向链表
			last.next = newNode;
			//最后，要把最后一个元素节点变为当前插入的元素节点
			last = newNode;
		}
		size++;
	}
	/**
	 * 根据元素位置取元素的值
	 * 从这个例子中就可以看出来，为什么LinkedList获取元素比较慢，因为每次取出元素都有进行一次循环！！！！
	 * @param size
	 * @return
	 */
	public E get(int index){
		checkSize(index);
		//获取元素的值
		//如果索引小于当前元素个数的一半，就从头部开始循环，否则从尾部开始循环
		if(index < (size >> 1)){
			//把头给节点，便于下面递归循环
			Node<E> node = first;
			for(int i=0;i<index;i++){
				//循环递归
				node = node.next;
			}
			//返回节点中的元素
			return node.item;
		}else{
			//把尾给节点，便于下面递归循环
			Node<E> node = last;
			for(int i=size-1;i>index;i--){
				node = node.prev;
			}
			return node.item;
		}
	}
	/**
	 * 检查元素是否合法
	 * @param size2
	 */
	private void checkSize(int index) {
		if(index >= size || index < 0){
			throw new IllegalArgumentException("输入的参数不合法，请输入合法的参数");
		}
	}
	/**
	 * 双向链表的节点
	 * @author zkn
	 *
	 * @param <E>
	 */
	private static class Node<E>{
		//当前元素
		E item;
		//上一个
		Node prev;
		//下一个
		Node next;
		
		public Node(E item, Node prev, Node next) {
			this.item = item;
			this.prev = prev;
			this.next = next;
		}
	}
	
	public static void main(String[] args){
		
		ImitateLinkedListTest02<String> linkedList = new ImitateLinkedListTest02<String>();
		linkedList.add("张三");
		linkedList.add("李四");
		linkedList.add("王五");
		linkedList.add("马六");
		
		System.out.println(linkedList.size());
		System.out.println(linkedList.get(2));
	}
}
