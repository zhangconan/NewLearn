package com.zkn.newlearn.tester.system;

import org.junit.Test;

/**
 * Created by wb-zhangkenan on 2016/12/29.
 */
public class SystemProperties01 {

    @Test
    public void testSystemUserDir(){

        System.out.println(System.getProperty("user.dir"));
    }
}
