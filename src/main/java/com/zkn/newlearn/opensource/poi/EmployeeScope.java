package com.zkn.newlearn.opensource.poi;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zkn on 2017/5/24.
 */
public class EmployeeScope implements Serializable {
    /**
     * 姓名
     */
    private String name;
    /**
     * 工号
     */
    private String empId;
    /**
     * 收入
     */
    private Double amounted;
    /**
     * 时间
     */
    private Date date;
}
