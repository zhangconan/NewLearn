package com.zkn.newlearn.enums;

/**
 * 
 * @author zkn 2016-07-11
 *
 */

public enum EnumTest01 {
	
	UPDATE(1,"更新"),QUERY(2,"查询"),DELETE(3,"删除"),INSERT(4,"%s,%s,%s,出现错误!");
	private Integer enumValue;
	private String enumDesc;
	
	private EnumTest01(Integer enumValue, String enumDesc) {
		this.enumValue = enumValue;
		this.enumDesc = enumDesc;
	}
	
	public int getEnumValue(){
		return this.enumValue;
	}
	
	public String getEnumDesc(){
		return this.enumDesc;
	}
}

	
