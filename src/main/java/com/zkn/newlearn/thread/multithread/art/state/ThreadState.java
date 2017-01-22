package com.zkn.newlearn.thread.multithread.art.state;

/**
 * Created by wb-zhangkenan on 2017/1/22.
 * 用来测试线程的运行状态。
 *  可以通过下面的命令来查询线程的堆栈信息：
 *      CMD---->jps(得到进程号)--->jstack(上一部获取的进程号)---->得到线程的堆栈信息
 */
public class ThreadState {

    public static void main(String[] args) {
        new Thread(new WaitingTimed(), "TimeWaitingThread").start();
        new Thread(new Waiting(), "WaitingThread").start();
        // 使用两个Blocked线程，一个获取锁成功，另一个被阻塞
        new Thread(new Blocked(), "BlockedThread-1").start();
        new Thread(new Blocked(), "BlockedThread-2").start();
    }
}
