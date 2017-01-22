package com.zkn.newlearn.thread.threadlocal;

/**
 * Created by wb-zhangkenan on 2016/11/10.
 */
public class ShieldThreadData {
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread() + "-" + Thread.currentThread().getName() + "- method-main=>" + ShieldThreadData.threadLocal.get());
        new Thread(new TA("TA")).start();
        new Thread(new TB("TB")).start();
        Thread.sleep(5000);
        System.out.println(Thread.currentThread() + "-" + Thread.currentThread().getName() + "- method-main=>" + ShieldThreadData.threadLocal.get());
        System.out.println(Thread.currentThread() + "-" + Thread.currentThread().getName() + "- method-main=>" + ShieldThreadData.threadLocal.get());
    }
}

class TA implements Runnable {
    private String name;

    public TA(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(Thread.currentThread() + "-" + this.name + "- method-run=>" + ShieldThreadData.threadLocal.get());
        ShieldThreadData.threadLocal.set(2);
        System.out.println(Thread.currentThread() + "-" + this.name + "- method-run#set=>2");
        print();
    }

    private void print() {
        System.out.println(Thread.currentThread() + "-" + this.name + "- method-print=>" + ShieldThreadData.threadLocal.get());
    }
}

class TB implements Runnable {
    private String name;

    public TB(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(Thread.currentThread() + "-" + this.name + "- method-run=>" + ShieldThreadData.threadLocal.get());
        ShieldThreadData.threadLocal.set(3);
        System.out.println(Thread.currentThread() + "-" + this.name + "- method-run#set=>3");
        print();
    }

    private void print() {
        System.out.println(Thread.currentThread() + "-" + this.name + "- method-print=>" + ShieldThreadData.threadLocal.get());
    }
}
