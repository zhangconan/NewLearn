package com.zkn.newlearn.collection;

import com.google.common.collect.Lists;
import com.zkn.newlearn.domain.PersonDomain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 重写一个集合比较器的方法
 * Created by wb-zhangkenan on 2016/9/22.
 */
public class CollectionCompareSort {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //sdf.parse("2014-01-03")
        List list = Lists.newArrayList();
        PersonDomain personDomain1 = new PersonDomain();
        personDomain1.setBirthDay(new Date());
        PersonDomain personDomain2 = new PersonDomain();
        personDomain2.setBirthDay(null);
        PersonDomain personDomain3 = new PersonDomain();
        personDomain3.setBirthDay(null);
        list.add(personDomain1);
        list.add(personDomain2);
        list.add(personDomain3);
        Collections.sort(list, new NewCollectionCompareSort());
        System.out.println(Arrays.toString(list.toArray()));
    }
}

class NewCollectionCompareSort implements Comparator<PersonDomain> {

    @Override
    public int compare(PersonDomain o1, PersonDomain o2) {
        if(o1.getBirthDay() == null)
            return 1;
        if(o2.getBirthDay() == null)
            return -1;
        return o1.getBirthDay().getTime() > o2.getBirthDay().getTime()?1:-1;
    }
}