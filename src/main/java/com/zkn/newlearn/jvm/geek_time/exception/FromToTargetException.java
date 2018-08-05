package com.zkn.newlearn.jvm.geek_time.exception;

/**
 * @author zkn
 * @date 2018/8/3 22:03
 **/
public class FromToTargetException {

    public static void main(String[] args) {
        try {
            System.out.println("要出异常了!");
            mayThrowException();
            System.out.println("异常执行完了!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void mayThrowException() {
        throw new RuntimeException("抛出异常!");
    }
}
