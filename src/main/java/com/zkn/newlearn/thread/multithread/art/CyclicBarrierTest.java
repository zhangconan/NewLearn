package com.zkn.newlearn.thread.multithread.art;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by wb-zhangkenan on 2017/1/23.
 */
public class CyclicBarrierTest {

    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                }
                System.out.println(1);
            }
        }).start();
        try {
            c.await();
        } catch (Exception e) {
        }
        System.out.println(2);
    }
}
