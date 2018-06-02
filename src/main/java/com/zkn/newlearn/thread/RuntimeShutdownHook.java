package com.zkn.newlearn.thread;/**
 * Created by zkn on 2017/11/14.
 */

import static java.lang.System.out;

/**
 * @author zkn
 * @date 2017/11/14 23:00
 */
public class  RuntimeShutdownHook {

    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread(() ->
                out.println("我被关闭了!")
        ));

        Thread thread = new Thread(() ->
                System.out.println("这是第一个线程!"));
        thread.start();
        
        Thread thread2 = new Thread(() ->
                System.out.println("这是第二个线程!"));
        thread2.start();

        try {
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
