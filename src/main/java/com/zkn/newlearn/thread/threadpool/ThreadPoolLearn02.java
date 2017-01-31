package com.zkn.newlearn.thread.threadpool;

import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Created by zkn on 2017/1/31.
 */
public class ThreadPoolLearn02 {

    private static ExecutorService executorService;

    public static void main(String[] args) {
        //testCall();
        //testRunnable();
        //testCallSec();
        testRunnableSec();
    }

    public static void testCall() {
        executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int mark = i + 1;
            Future<Integer> submit = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    System.out.println(Thread.currentThread().getName());
                    return mark;
                }
            });
            try {
                System.out.println(submit.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }

    public static void testCallSec() {
        executorService = Executors.newFixedThreadPool(3);
        IntStream.range(0, 10).forEach(e -> {
            Future future = executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                return e+1;
            });
            try {
                System.out.println(future.get());
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } catch (ExecutionException e1) {
                e1.printStackTrace();
            }
        });
        executorService.shutdown();
    }

    public static void testRunnable() {
        //创建一个三个线程的线程池
        executorService = Executors.newFixedThreadPool(3);
        IntStream.range(0, 10).forEach(e -> executorService.submit(() -> System.out.println(Thread.currentThread().getName())));
        executorService.shutdown();
    }

    public static void testRunnableSec(){
        executorService = Executors.newFixedThreadPool(3);
        IntStream.range(0,10).forEach(e->{
            Future<Integer> future = executorService.submit(()->{
                System.out.println(Thread.currentThread().getName());
            },0);
            try {
                System.out.println(future.get());
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } catch (ExecutionException e1) {
                e1.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}
