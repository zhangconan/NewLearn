package com.zkn.newlearn.thread;

/**
 * Created by wb-zhangkenan on 2016/11/4.
 */
public class ThreadTest04 {

    public static void main(String[] args){

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    Thread.currentThread().getThreadGroup().list();
                }
            }
        }).start();
    }
}
