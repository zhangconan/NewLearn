package com.zkn.newlearn.thread.multithread.art.state;

/**
 * Created by wb-zhangkenan on 2017/1/22.
 */
public class Waiting implements Runnable {

    @Override
    public void run() {
        while (true) {
            synchronized (Waiting.class) {
                try {
                    Waiting.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
