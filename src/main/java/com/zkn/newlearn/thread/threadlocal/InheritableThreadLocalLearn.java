package com.zkn.newlearn.thread.threadlocal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 子线程可以读取到父线程中设置的值 不过也只限于在子线程启动之前 父线程设置的值
 *
 * @author zkn
 * @date 2018/6/12 22:58
 */
public class InheritableThreadLocalLearn {

    private static InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal();

    public static void main(String[] args) {
        threadLocal.set("张三");
        List<Thread> threadList = new ArrayList<>(5);
        IntStream.range(0, 5).forEach(ele -> {
            Thread thread = new Thread(() -> {
                System.out.println(String.format("第%d个子线程第一次取值:", ele) + threadLocal.get());
                threadLocal.set(String.format("第%d个子线程", ele));
                System.out.println(String.format("第%d个子线程第二次取值:", ele) + threadLocal.get());
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
        System.out.println("主线程的值：" + threadLocal.get());
    }
}
