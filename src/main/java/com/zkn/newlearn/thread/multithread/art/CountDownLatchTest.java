package com.zkn.newlearn.thread.multithread.art;

import java.util.concurrent.CountDownLatch;

/**
 * Created by wb-zhangkenan on 2017/1/23.
 */
public class CountDownLatchTest {

    static CountDownLatch c = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        c.await();
        System.out.println("3");
    }
}
