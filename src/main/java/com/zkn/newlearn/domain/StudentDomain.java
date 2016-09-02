package com.zkn.newlearn.domain;

/**
 * Created by zkn on 2016/8/23.
 */
public class StudentDomain {

    /**
     * 地址
     */
    private String address;
    /**
     * 家庭
     */
    private String family;
    /**
     * 学校名称
     */
    private String schoolName;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
