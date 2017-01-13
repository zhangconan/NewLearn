package com.zkn.newlearn.thread.localvariable;

import com.zkn.newlearn.domain.PersonDomain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wb-zhangkenan on 2017/1/13.
 */
public class LocalObjectTest {

    public void run(){

        List<PersonDomain> listPer = new ArrayList<PersonDomain>();
        run01(listPer);
    }

    public void run01(List<PersonDomain> listPer){

        PersonDomain personDomain = null;
        for(int i=0;i<1000;i++){
            personDomain = new PersonDomain();
            personDomain.setAge(i);
            personDomain.setName("zkn"+i);
            personDomain.setAddress("nkz"+i);
            listPer.add(personDomain);
        }
        System.out.println(Arrays.toString(listPer.toArray(new PersonDomain[0])));
    }
}
