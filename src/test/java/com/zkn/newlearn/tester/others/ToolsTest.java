package com.zkn.newlearn.tester.others;

import com.alibaba.fastjson.JSON;

import com.zkn.newlearn.domain.PersonDomain;
import com.zkn.newlearn.tools.RandomObjectValue;
import org.junit.Test;

/**
 * Created by wb-zhangkenan on 2017/4/13.
 *
 * @author wb-zhangkenan
 * @date 2017/04/13
 */
public class ToolsTest {

    @Test
    public void testRanddomObject(){

        System.out.println(JSON.toJSONString(RandomObjectValue.getObject(PersonDomain.class)));
        System.out.println((PersonDomain)RandomObjectValue.getObject(PersonDomain.class));
    }
}
