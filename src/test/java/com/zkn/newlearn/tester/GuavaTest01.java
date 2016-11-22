package com.zkn.newlearn.tester;

import com.google.common.base.Joiner;
import org.junit.Test;

/**
 * Created by wb-zhangkenan on 2016/11/22.
 */
public class GuavaTest01 {

    @Test
    public void testJoner(){
        String[] str = {"sss","ddd","sdsdwe"};
        System.out.println(Joiner.on(",").join(str));
    }
}
