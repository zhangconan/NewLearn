package com.zkn.newlearn.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Person对象
 *
 * @author zkn
 */

public class PersonDomain implements Serializable {

    /**
     * 序列
     */
    private static final long serialVersionUID = 1L;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;

    private StudentDomain studentDomain;

    private Optional<String> stringOptional;

    /**
     * 出生日期
     */
    private Date birthDay;
    /**
     * 地址
     */
    private String address;
    /**
     * List集合
     */
    private List<String> stringList;
    /**
     * Map集合
     */
    private Map<String, Integer> testMap;
    /**
     *
     */
    private List<StudentDomain> objList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //@Override
    //public String toString() {
    //	return "PersonDomain [name=" + name + ", age=" + age +",birthDay="+(birthDay==null?"birthDay位空":birthDay.getTime())+","+ address +"]";
    //}

    @Override
    public String toString() {
        return "PersonDomain{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentDomain=" + studentDomain +
                ", birthDay=" + birthDay +
                ", address='" + address + '\'' +
                ", stringList=" + stringList +
                ", testMap=" + testMap +
                ", objList=" + objList +
                '}';
    }

    public StudentDomain getStudentDomain() {
        return studentDomain;
    }

    public void setStudentDomain(StudentDomain studentDomain) {
        this.studentDomain = studentDomain;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public Map<String, Integer> getTestMap() {
        return testMap;
    }

    public void setTestMap(Map<String, Integer> testMap) {
        this.testMap = testMap;
    }

    public List<StudentDomain> getObjList() {
        return objList;
    }

    public void setObjList(List<StudentDomain> objList) {
        this.objList = objList;
    }

    public Optional<String> getStringOptional() {
        return stringOptional;
    }

    public void setStringOptional(Optional<String> stringOptional) {
        this.stringOptional = stringOptional;
    }
}
