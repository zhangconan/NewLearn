package com.zkn.newlearn.collection;

import java.util.Arrays;

/**
 * 这个类用来模仿实现ArrayList的功能
 * @author zkn 2016-06-20
 *
 */

public class ImitateArrayListTest01 {
	/**
	 * 一个初始化的数组数据
	 */
	private Object[] elementData;
	/**
	 * 一个空的数组对象
	 */
	private static final Object[] EMPTY_ARRAY = {};
	/**
	 * 默认初始为空
	 */
	private static final Object[] DEFAULT_EMPTY_ARRAY = {}; 
	/**
	 * 用来记录元素的个数
	 */
	private int size;
	private static final int DEFAULT_INIT = 10;
	/**
	 * 构造函数
	 */
	public ImitateArrayListTest01(){
		//默认初始化10参数
		//1.6之后 设置初始因子 放到了第一次add的时候
		this(DEFAULT_INIT);
	}
	
	public ImitateArrayListTest01(int initialCapacity){
		if(initialCapacity < 0) {
            throw new IllegalArgumentException("请传入大于0的值");
        }
		if(initialCapacity == 0) {
            this.elementData = EMPTY_ARRAY;
        }
		this.elementData = new Object[initialCapacity];
	}
	/**
	 * 元素的个数
	 */
	public int size(){
		
		return this.size;
	}
	/**
	 * 添加元素
	 */
	public void add(Object obj){
		if(Arrays.equals(elementData, DEFAULT_EMPTY_ARRAY)) {
            elementData = new Object[DEFAULT_INIT];
        }
		if((this.size+1) > elementData.length){
			int oldLength = elementData.length+1;
			//增加一倍
			int newLength = oldLength + (oldLength >> 1);
			if(newLength - DEFAULT_INIT < 0)
				//如果新长度小于默认值，则扩长为默认值的长度
            {
                newLength = DEFAULT_INIT;
            }
			//去掉大容量的逻辑
			//扩展数组
			elementData = Arrays.copyOf(elementData, newLength);
		}
		elementData[size++] = obj;
	}
	/**
	 * 获取数组中的值
	 * @return
	 */
	public Object get(int index) {
		checkIndex(index);
		return elementData[index];
	}
	private void checkIndex(int index) {
		if(index >= size) {
            throw new IndexOutOfBoundsException("取值范围过大");
        }
	}

	/**
	 * 是否为空
	 * @return
	 */
	public boolean isEmpty(){
		
		return size == 0;
	}
	
}
