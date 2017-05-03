package com.zkn.newlearn.thread.localvariable;

import java.util.stream.IntStream;

/**
 * Created by wb-zhangkenan on 2017/1/13.
 */
public class LocalObjectRun {

    public static void main(String[] args){
        /**
         * 这里是不会出现多线程的问题的
         *  因为每个线程都有自己的栈帧（Frame）,
         */
        LocalObjectTest localObjectTest = new LocalObjectTest();
        IntStream
                .range(0,10)
                .forEach((e)->{
                    Thread thread = new Thread(()->
                            localObjectTest.run());thread.start();});
        while (true){
            if(Thread.activeCount() == 2) {
                break;
            }
        }
    }
}
