package com.zkn.newlearn.jvm;

import com.zkn.newlearn.domain.StudentDomain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zkn on 2017/2/23.
 */
public class TestObjectInHeadOrStack {

    public static void main(String[] args){
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("开始输出了。。。。");
        List<StudentDomain> list = new ArrayList<>();
        for(int i=0;i<1000000;i++){
            StudentDomain studentDomain = new StudentDomain();
            studentDomain.setSchoolName("zhangsan"+i);
            studentDomain.setAddress("黄村"+i);
            studentDomain.setFamily("zhangjia"+i);
            list.add(studentDomain);
        }
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
