package com.zkn.newlearn.thread.threadlocal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 如何往一个线程的ThreadLocal中设置多个值？创建多个ThreadLocal
 *
 * @author zkn
 * @date 2018/6/12 22:39
 */
public class ThreadLocalLearn {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        threadLocal.set("张三");

        List<Thread> threadList = new ArrayList<>(5);
        IntStream.range(0, 5).forEach(ele -> {
            Thread thread = new Thread(() -> {
                System.out.println(String.format("第%d个线程第一次取值：", ele) + threadLocal.get());
                threadLocal.set(String.format("第%d个线程", ele));
                System.out.println(String.format("第%d个线程第二次取值：", ele) + threadLocal.get());
            });
            thread.start();
            threadList.add(thread);
        });
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("取主线程设置的值：" + threadLocal.get());
    }
}
