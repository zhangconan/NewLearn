package com.zkn.newlearn.tester.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

/**
 * Created by wb-zhangkenan on 2017/5/24.
 *
 * @author wb-zhangkenan
 * @date 2017/05/24
 */
public class CollectionTest {

    @Test
    public void testListRemoveAll(){

        List<String> list01 = new ArrayList<String>(){{

            add("2232343");
            add("22w32343");
            add("22323w43");
            add("22tr32343");
        }};
        List<String> list02 = new ArrayList<String>(){{
            add("22323w43");
            add("22tr32343");
            add("22w32343");
            add("22323412qwqw3");
            add("22w323ww43");
            add("2232343");
        }};
        //移除list01和list02中重复的元素，会把list01中的元素删掉
        list01.removeAll(list02);
        System.out.println(list01.size());
        System.out.println(Arrays.toString(list01.toArray()));
        System.out.println("qq"+"  ssss  ".trim()+"zz");

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR));
    }

    public void testDouble(){


    }
}
