package com.zkn.newlearn.jdk8.stream;

import org.junit.Test;

/**
 * Created by zkn on 2018/1/27.
 */
public class TestLambda {

    @Test
    public void test() {

        Thread thread = new Thread(() ->
                System.out.println("我被执行了。。。。。")
        );
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行完了。。。。。");
    }
}
