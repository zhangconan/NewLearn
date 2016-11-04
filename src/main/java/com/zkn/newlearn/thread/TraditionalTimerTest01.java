package com.zkn.newlearn.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 传统的定时器
 * Created by zkn on 2016/11/1.
 */
public class TraditionalTimerTest01 {

    public static void main(String[] args){
        //TimerTask是Runnable接口的一个实现类是，它是一个抽像类
        //schedule是一个重载方法：第一个参数TimerTask的实现类。
        // 第二个参数是第一次执行的时间。
        // 第三个参数是间隔时间
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                System.out.println("这是一个定时器任务!");
            }
        },1000,2000);
    }
}
