package com.zkn.newlearn.thread.multithread.art.state;

import java.util.concurrent.TimeUnit;

/**
 * Created by wb-zhangkenan on 2017/1/22.
 */
public class SleepUtils {

    public static void sleep(long times){
        try {
            TimeUnit.SECONDS.sleep(times);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
