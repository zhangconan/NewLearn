package com.zkn.newlearn.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zkn.newlearn.domain.PersonDomain;
import com.zkn.newlearn.domain.StudentDomain;

/**
 * JSON和javaBean的相互转换
 * Created by zkn on 2016/8/23.
 */
public class JsonTransfBeanTest01 {

    public static void main(String[] args){

        PersonDomain personDomain = new PersonDomain();
        personDomain.setAge(12);
        personDomain.setName("zhangsan");
        StudentDomain studentDomain = new StudentDomain();
        studentDomain.setAddress("北京市海淀区");
        studentDomain.setSchoolName("北京大学");
        personDomain.setStudentDomain(studentDomain);

        String str = JSON.toJSONString(personDomain);
        System.out.println(str);

        PersonDomain person = JSONObject.parseObject(str,PersonDomain.class);
        System.out.println(person.getStudentDomain().getAddress());
    }
}
