package com.zkn.newlearn.tester.collections;

import com.google.common.base.Joiner;
import com.zkn.newlearn.reflect.Person;
import org.junit.Test;

import java.util.*;

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

    @Test
    public void testNullList(){
        //Person[] people = null;
        //List<Person> list = Arrays.asList(null);
        List<Person> list = new ArrayList<>();
        System.out.println(Arrays.toString(list.toArray(new Person[0])));
    }
}
