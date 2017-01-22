package com.zkn.newlearn.thread.multithread.art.state;

/**
 * Created by wb-zhangkenan on 2017/1/22.
 */
public class Blocked implements Runnable{

    @Override
    public void run() {
        synchronized (Blocked.class){
            while (true){
                SleepUtils.sleep(100);
            }
        }
    }
}
