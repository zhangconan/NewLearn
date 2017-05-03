package com.zkn.newlearn.thread.localvariable;

import java.util.stream.IntStream;

/**
 * Created by wb-zhangkenan on 2017/1/13.
 */
public class LocalVariableRun {

    public static void main(String[] args){
        /**
         * 这里是不会出现多线程的问题的
         *  因为每个线程都有自己的工作内存(JVM里的栈空间)(这个栈的内存空间分配的大小是一样的，但是使用的大小是不同的)。
         *  run里面的变量都是方法局部变量，分配的内存空间每个线程的工作内存，是每个线程独占的。
         * 只有全局变量（堆中的变量，即共享变量）才会出现多线程问题。
         */
        LocalVariableTest localVariableTest = new LocalVariableTest();
        IntStream
                .range(0,10)
                .forEach((e)->{
                        Thread thread = new Thread(()->
                                localVariableTest.run());thread.start();});
        while (true){
            if(Thread.activeCount() == 2) {
                break;
            }
        }
    }
}

