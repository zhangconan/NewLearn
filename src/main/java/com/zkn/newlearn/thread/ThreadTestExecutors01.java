package com.zkn.newlearn.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by wb-zhangkenan on 2016/11/4.
 */
public class ThreadTestExecutors01 {

    public static void main(String[] args) {
        //创建一个两个线程的线程池
        ExecutorService executors = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 4; i++) {
            executors.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        executors.shutdown();
    }
}

