package com.zkn.newlearn.tester;

import com.zkn.newlearn.domain.PersonDomain;
import com.zkn.newlearn.gof.prototype.PrototypeGofTest01;
import org.junit.Test;

/**
 * ԭ��ģʽ��Ԫ������
 * @author zkn
 *
 */

public class PrototypeGofTest {

	@Test
	public void testPrototypeGof() throws Exception{
		
		PrototypeGofTest01 prototype = new PrototypeGofTest01();
		prototype.setAge(12);
		prototype.setName("zhangsanlisi");
		prototype.setSchool("张三李四");
		PersonDomain person = new PersonDomain();
		person.setAge(50);
		person.setName("张三李四");
		prototype.setPersonDomain(person);
		/*
		PrototypeGofTest01 proto = (PrototypeGofTest01) prototype.clone();//浅copy
		proto.setSchool("张三李四的点点滴滴");
		PersonDomain pd = new PersonDomain();
		pd.setName("张三李四凄凄切切");
		pd.setAge(89);
		//proto.setPersonDomain(pd);
		proto.getPersonDomain().setName("eee");
		System.out.println(prototype.toString());
		System.out.println(proto.toString());
		*/
		PrototypeGofTest01 protoDeep = (PrototypeGofTest01) prototype.deepClone();
		protoDeep.getPersonDomain().setName("66666666");
		System.out.println(prototype.toString());
		System.out.println(protoDeep.toString());
	}
}
