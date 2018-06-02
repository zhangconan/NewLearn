package com.zkn.newlearn.thread.analysis;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * @author zkn
 */
public class ThreadStateAnalysisFir {


    public static void main(String[] args) {
        ThreadStateAnalysisFir wait = new ThreadStateAnalysisFir();
        //启动二十个线程
        int threadSize = 2;
        CountDownLatch downLatch = new CountDownLatch(threadSize);
        IntStream.range(0, threadSize).filter(ele -> {
            Thread thread = new Thread(() -> {
                System.out.println("线程启动：" + ele);
                wait.methodA();
                downLatch.countDown();
            });
            thread.start();
            return true;
        }).forEach(ele ->
                System.out.println(ele)
        );
        //上面的这段代码会出现这两种情况
        /**
         * "Thread-1" #13 prio=5 os_prio=0 tid=0x000000001b1c2800 nid=0x2814 waiting for monitor entry [0x000000001b9ee000]
         *    java.lang.Thread.State: BLOCKED (on object monitor)
         *
         * "Thread-0" #12 prio=5 os_prio=0 tid=0x000000001b1c1000 nid=0x604 waiting on condition [0x000000001b8cf000]
         *    java.lang.Thread.State: TIMED_WAITING (sleeping)
         *
         * Thread-1  线程状态是 BLOCKED waiting for monitor entry
         * Thread-0  线程状态是 TIMED_WAITING waiting on condition
         * 什么时候会出现线程 TIMED_WAITING 状态？ 调用sleep方法的时候、调用wait(long time)
         *
         * http://www.cnblogs.com/zhengyun_ustc/archive/2013/01/06/dumpanalysis.html
         */
    }

    public synchronized void methodA() {
        try {
            //休眠5S
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
