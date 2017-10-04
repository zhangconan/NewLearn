package com.zkn.newlearn.tester.others;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wb-zhangkenan on 2017/1/5.
 */
public class TestInteger {

    @Test
    public void testInteger(){
        if(500 == new Integer(500)){
            System.out.println("ssss");
        }
        System.out.println(ArrayList.class.isAssignableFrom(List.class));
        System.out.println(List.class.isAssignableFrom(ArrayList.class));

        LearnTest learnTest = new LearnTest();
        learnTest.add();
    }
}
