package com.zkn.newlearn.opensource.spring.lifecycle;

/**
 * Created by wb-zhangkenan on 2017/4/24.
 *
 * @author wb-zhangkenan
 * @date 2017/04/24
 */
public class BeanLifeCycleLearn02 {

    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
