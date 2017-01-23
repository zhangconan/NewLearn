package com.zkn.newlearn.thread.multithread.art;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by wb-zhangkenan on 2017/1/23.
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        s.acquire();//最大并发数的许可
                        //TimeUnit.SECONDS.sleep(10);
                        System.out.println("save data");
                    } catch (InterruptedException e) {
                    }finally {
                        s.release();//归还许可
                    }
                }
            });
        }
        threadPool.shutdown();
    }
}
