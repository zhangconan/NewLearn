package com.zkn.newlearn.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * Created by zkn on 2017/1/31.
 * 线程池的小例子
 */
public class ThreadPoolLearn01 {

    public static void main(String[] args){
        //创建三个线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //创建十个线程
        IntStream.range(0,10).forEach(e->executorService.execute(()-> System.out.println(Thread.currentThread().getName())));
        //关闭线程池
        executorService.shutdown();
    }
}
