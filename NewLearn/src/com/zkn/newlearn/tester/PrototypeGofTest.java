package com.zkn.newlearn.tester;

import org.junit.Test;

import com.zkn.newlearn.domain.PersonDomain;
import com.zkn.newlearn.gof.prototype.PrototypeGofTest01;

/**
 * 原型模式单元测试类
 * @author zkn
 *
 */

public class PrototypeGofTest {

	@Test
	public void testPrototypeGof() throws Exception{
		PrototypeGofTest01 prototype = new PrototypeGofTest01();
		prototype.setAge(12);
		prototype.setName("zhangsanlisi");
		prototype.setSchool("三元桥。。。。");
		PersonDomain person = new PersonDomain();
		person.setAge(50);
		person.setName("王万往往");
		prototype.setPersonDomain(person);
		
		PrototypeGofTest01 proto = (PrototypeGofTest01) prototype.clone();//浅拷贝 引用对象还是执向原来的对象
		proto.setSchool("天通苑。。。。");
		PersonDomain pd = new PersonDomain();
		pd.setName("我问问而入");
		pd.setAge(89);
		//proto.setPersonDomain(pd);
		proto.getPersonDomain().setName("eee");
		System.out.println(prototype.toString());
		System.out.println(proto.toString());
		
		PrototypeGofTest01 protoDeep = (PrototypeGofTest01) prototype.deepClone();
		protoDeep.getPersonDomain().setName("66666666");
		System.out.println(prototype.toString());
		System.out.println(protoDeep.toString());
	}
}
