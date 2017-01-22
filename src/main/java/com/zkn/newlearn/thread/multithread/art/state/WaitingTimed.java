package com.zkn.newlearn.thread.multithread.art.state;

/**
 * Created by wb-zhangkenan on 2017/1/22.
 */
public class WaitingTimed implements Runnable {
    @Override
    public void run() {
        while (true) {
            SleepUtils.sleep(100);
        }
    }
}
