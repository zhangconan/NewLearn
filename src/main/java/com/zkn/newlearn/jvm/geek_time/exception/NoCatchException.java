package com.zkn.newlearn.jvm.geek_time.exception;

/**
 * @author zkn
 * @date 2018/8/8 23:39
 **/
public class NoCatchException {

    public static void main(String[] args) {

        throw new RuntimeException("抛出异常!");
    }
}
