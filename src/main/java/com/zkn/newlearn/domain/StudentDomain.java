package com.zkn.newlearn.domain;

import java.util.Date;

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
    /**
     * 成立时间
     */
    private Date buildDate;

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

    public Date getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(Date buildDate) {
        this.buildDate = buildDate;
    }

    @Override
    public String toString() {
        return "StudentDomain{" +
            "address='" + address + '\'' +
            ", family='" + family + '\'' +
            ", schoolName='" + schoolName + '\'' +
            ", buildDate=" + buildDate +
            '}';
    }
}
