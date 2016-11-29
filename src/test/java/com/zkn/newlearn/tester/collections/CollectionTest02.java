package com.zkn.newlearn.tester.collections;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wb-zhangkenan on 2016/11/29.
 */
public class CollectionTest02 {

    @Test
    public void testJoiner(){
        String domain = "zhangsan";
        String domain01 = "zhangsan,lwweww222";
        Set<String> set = new HashSet<String>(Arrays.asList(domain.split(",")));
        set.addAll(Arrays.asList(domain01.split(",")));
        String str = Joiner.on(",").join(set.iterator());
        System.out.println(str);
    }
}
