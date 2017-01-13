package com.zkn.newlearn.thread.deadlock;

/**
 * Created by wb-zhangkenan on 2017/1/12.
 */
public class DeadLockExample {

    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args){
        new DeadLockExample().deadLock();
    }

    public void deadLock(){

        Thread thread01 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B){
                        System.out.println("1");
                    }
                }
            }
        });
        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                    synchronized (A){
                        System.out.println("2");
                    }
                }
            }
        });
        thread01.start();
        thread02.start();
    }
}
