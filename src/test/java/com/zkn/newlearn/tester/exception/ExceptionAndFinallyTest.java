package com.zkn.newlearn.tester.exception;

/**
 * Created by wb-zhangkenan on 2017/1/22.
 */
public class ExceptionAndFinallyTest {

    public static void main(String[] args){
        testFinally();
    }

    public static void testFinally() {

        try{
            throw new RuntimeException();
        }catch (Exception e){
            System.out.println("我是异常!");
        }finally {
            System.out.println("我是finally!");
        }
    }
}
