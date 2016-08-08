package com.zkn.newlearn.tester;

import com.zkn.newlearn.domain.PersonDomain;
import com.zkn.newlearn.gof.prototype.PrototypeGofTest01;
import org.junit.Test;

/**
 * 原锟斤拷模式锟斤拷元锟斤拷锟斤拷锟斤拷
 * @author zkn
 *
 */

public class PrototypeGofTest {

	@Test
	public void testPrototypeGof() throws Exception{
		
		PrototypeGofTest01 prototype = new PrototypeGofTest01();
		prototype.setAge(12);
		prototype.setName("zhangsanlisi");
		prototype.setSchool("寮犱笁鏉庡洓");
		PersonDomain person = new PersonDomain();
		person.setAge(50);
		person.setName("寮犱笁鏉庡洓");
		prototype.setPersonDomain(person);
		/*
		PrototypeGofTest01 proto = (PrototypeGofTest01) prototype.clone();//娴卌opy
		proto.setSchool("寮犱笁鏉庡洓鐨勭偣鐐规淮婊�");
		PersonDomain pd = new PersonDomain();
		pd.setName("寮犱笁鏉庡洓鍑勫噭鍒囧垏");
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
