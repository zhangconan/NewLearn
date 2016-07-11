package com.zkn.newlearn.enums;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import static com.zkn.newlearn.enums.EnumTest02.*;
import org.junit.Test;
/**
 * 
 * @author zkn 2016-07-11
 *
 */
public class JunitTestEnum {

	@Test
	public void testEnumValues(){
		System.out.println(Arrays.toString(EnumTest01.values()));
		//循环所有的枚举类型
		for(EnumTest01 test : EnumTest01.values()){
			System.out.println(test.getEnumDesc()+test.getEnumValue());
			System.out.println(test.name()+"   "+test.ordinal());
		}
		//ValueOf
		System.out.println(EnumTest01.valueOf("UPDATE").getEnumDesc());
		System.out.println(Enum.valueOf(EnumTest01.class, "DELETE").getEnumDesc());
		
		EnumMap<EnumTest01, String> enumMap = new EnumMap<EnumTest01, String>(EnumTest01.class);
		enumMap.put(EnumTest01.DELETE, "dsdsd");
		enumMap.put(EnumTest01.UPDATE, "qqqqqq");
		for(Map.Entry<EnumTest01, String> entry : enumMap.entrySet()){
			System.out.println(entry.getValue()+entry.getKey().getEnumDesc());
		}
		
		EnumSet<EnumTest01> enumSet = EnumSet.noneOf(EnumTest01.class);
		enumSet.add(EnumTest01.DELETE);
		enumSet.add(EnumTest01.UPDATE);
		for(Iterator<EnumTest01> it = enumSet.iterator();it.hasNext();){
			System.out.println(it.next().getEnumDesc());
		}
		for(EnumTest01 enumTest : enumSet){
			System.out.println(enumTest.getEnumDesc()+"  ..... ");
		}
	}
}
