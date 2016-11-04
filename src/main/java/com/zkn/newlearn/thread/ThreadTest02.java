package com.zkn.newlearn.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by zkn on 2016/10/31.
 */
public class ThreadTest02 {

    public static void main(String[] args){

        Thread thread = new Thread(){
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println("线程创建的第一种方式："+Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println("线程创建的第二种方式："+Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread2.start();

        FutureTask<Integer> ft = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int i = 0;
                for(;i<10;i++){
                    System.out.println("线程创建的第三种方式："+Thread.currentThread().getName());
                }
                return i;
            }
        });
        new Thread(ft).start();

        try {
            System.out.println("子线程的返回值："+ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable实现类的调用：");
            }
        }){
            @Override
            public void run() {
                System.out.println("继承Thread的调用：");
            }
        }.start();
    }
}
