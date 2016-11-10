package com.zkn.newlearn.thread;

/**
 * Created by wb-zhangkenan on 2016/11/10.
 * 线程内传递参数 各线程用自己的线程内参数
 */
public class ThreadLocalInnerParams {

    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    public static void main(String[] args) throws InterruptedException {
        threadLocal.set(1);
        mainPrint();
        new Thread(new A("A")).start();
        new Thread(new B("B")).start();
        Thread.sleep(1000);
        mainPrint();
        Thread.sleep(1000);
        mainPrint01();
        Thread.sleep(1000);
        mainPrint02();
        Thread.sleep(1000);
        mainPrint03();
        Thread.sleep(1000);
        mainPrint04();
    }

    public static void mainPrint() {
        System.out.println(Thread.currentThread() + "-" + Thread.currentThread().getName() + "-method:mainPrint=" + threadLocal.get());
    }

    public static void mainPrint01() {
        System.out.println(Thread.currentThread() + "-" + Thread.currentThread().getName() + "-method:mainPrint01 =" + threadLocal.get());
    }

    public static void mainPrint02() {
        System.out.println(Thread.currentThread() + "-" + Thread.currentThread().getName() + "-method:mainPrint02 =" + threadLocal.get());
    }

    public static void mainPrint03() {
        System.out.println(Thread.currentThread() + "-" + Thread.currentThread().getName() + "-method:mainPrint03 =" + threadLocal.get());
    }

    public static void mainPrint04() {
        System.out.println(Thread.currentThread() + "-" + Thread.currentThread().getName() + "-method:mainPrint04 =" + threadLocal.get());
    }
}

class A implements Runnable {
    private String name;

    public A(String name) {
        this.name = name;
    }

    public void run() {
        ThreadLocalInnerParams.threadLocal.set(2);
        try {
            print();
            print01();
            Thread.sleep(500);
            print02();
            Thread.sleep(500);
            print03();
            Thread.sleep(500);
            print04();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void print() {
        System.out.println(Thread.currentThread() + "-" + this.name + "-method:print=" + ThreadLocalInnerParams.threadLocal.get());
    }

    private void print01() {
        System.out.println(Thread.currentThread() + "-" + this.name + "-method:print01=" + ThreadLocalInnerParams.threadLocal.get());
    }

    private void print02() {
        System.out.println(Thread.currentThread() + "-" + this.name + "-method:print02=" + ThreadLocalInnerParams.threadLocal.get());
    }

    private void print03() {
        System.out.println(Thread.currentThread() + "-" + this.name + "-method:print03=" + ThreadLocalInnerParams.threadLocal.get());
    }

    private void print04() {
        System.out.println(Thread.currentThread() + "-" + this.name + "-method:print04=" + ThreadLocalInnerParams.threadLocal.get());
    }
}

class B implements Runnable {
    private String name;

    public B(String name) {
        this.name = name;
    }

    public void run() {
        print01();
        print02();
    }

    private void print01() {
        System.out.println(Thread.currentThread() + "-" + this.name + "-method:print01=" + ThreadLocalInnerParams.threadLocal.get());
    }

    private void print02() {
        System.out.println(Thread.currentThread() + "-" + this.name + "-method:print02=" + ThreadLocalInnerParams.threadLocal.get());
    }
}
