package com.zkn.newlearn.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zkn on 2016/11/1.
 */
public class TraditionalTimerTest02 {

    public static void main(String[] args){

        new Timer().schedule(new MyTimerTask01(),4000);
    }

    private static class MyTimerTask01 extends TimerTask{

        @Override
        public void run() {
            System.out.println("我是TimerTask1，我被执行了!");
            new Timer().schedule(new MyTimerTask02(),2000);
        }
    }

    private static class MyTimerTask02 extends TimerTask {

        @Override
        public void run() {
            System.out.println("我是TimerTask2，我被执行了!");
            new Timer().schedule(new MyTimerTask01(),4000);
        }
    }
}
