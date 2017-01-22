package com.zkn.newlearn.thread.multithread.art;

import com.zkn.newlearn.thread.multithread.art.state.SleepUtils;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by wb-zhangkenan on 2017/1/22.
 * 守护线程：
 * 守护线程的作用：主要为用户线程提供支持性的工作。守护线程一般是由虚拟机自行创建的。守护线程可以认为是所有非守护线程的保姆，
 *      只要虚拟机中还有任何一个非守护线程在工作，则守护线程就会工作。只有当最后一个非守护线程工作结束时，守护线程也随着JVM结束工作。
 * 守护线程的使用：
 *      JVM中的GC。
 * 创建守护：
 *      守护线程(setDaemon(true))的设置要在线程启动之后设置，不能在线程启动之后设置。
 * 注意：
 *      守护线程的finally不一定能执行到。在构建Daemon线程时，不能依靠finally块中的内容来确保执行关闭或清理资源的逻辑。
 */
public class DaemonThread {

    public static void main(String[] args) {
        Thread thread = new TestDaemonThread("我是守护线程");
        thread.setDaemon(true);
        thread.start();
        Thread thread02 = new TestDaemonThread("我不是守护线程");
        thread02.start();
    }
}

class TestDaemonThread extends Thread {

    public TestDaemonThread(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        try {
            SleepUtils.sleep(20);
            ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
            ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
            for (ThreadInfo threadInfo : threadInfos)
                System.out.println(threadInfo.getThreadId() + "  " + threadInfo.getThreadName());
        } finally {
            System.out.println("守护线程工作结束了!"+Thread.currentThread().getName());
        }
    }
}
