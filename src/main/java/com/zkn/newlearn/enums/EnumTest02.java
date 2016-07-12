package com.zkn.newlearn.enums;

/**
 * 
 * @author zkn 2016-07-11
 *
 */

public enum EnumTest02{
	GREEN{
		@Override
		public void getInfo(){
			System.out.println("这个是绿灯");
		}
		public void getPrint(){
			System.out.println("zhangsan");
		}
	},
	RED{
		@Override
		public void getInfo(){
			System.out.println("这个是红灯");
		}
	},
	YELLOW{
		@Override
		public void getInfo(){
			System.out.println("这个是黄灯");
		}
	};

	public void getInfo(){
		
	}
	
}


