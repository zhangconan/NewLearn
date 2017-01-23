package com.zkn.newlearn.thread.multithread.art;

import com.zkn.newlearn.thread.multithread.art.state.SleepUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by zkn on 2017/1/22.
 * 线程中断：
 *   中断只是一个线程状态的标识，它不会终止线程的执行。
 *  对于休眠中的线程进行中断的操作
 */
public class InterruptedThread {

    public static void main(String[] args){

        Thread sleepThread = new Thread(new SleepRunner(),"SleepThread");
        sleepThread.setDaemon(true);

        Thread busyThread = new Thread(new BusyRunner(),"BusyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("sdsdsd");
        }

        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("SleepThread interrupted is "+sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is "+busyThread.isInterrupted());

        SleepUtils.sleep(2);
    }
}

class SleepRunner implements Runnable {

    @Override
    public void run() {
        while (true){
            SleepUtils.sleep(10);
            System.out.println(Thread.currentThread().isInterrupted());
        }
    }
}

class BusyRunner implements Runnable {

    @Override
    public void run() {
        while (true){

        }
    }
}