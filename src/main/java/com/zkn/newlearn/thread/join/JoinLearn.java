package com.zkn.newlearn.thread.join;

/**
 * @author zkn
 * @date 2018/6/12 22:51
 */
public class JoinLearn {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("join方法!"));
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main线程");
    }
}
