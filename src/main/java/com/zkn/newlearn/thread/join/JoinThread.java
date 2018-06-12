package com.zkn.newlearn.thread.join;

/**
 * @author zkn
 * @date 2017/1/22
 * 测试join方法。
 */
public class JoinThread {

    public static void main(String[] args) {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
    }
}

class Domino implements Runnable {
    private Thread thread;

    public Domino(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "  terminate ");
    }
}