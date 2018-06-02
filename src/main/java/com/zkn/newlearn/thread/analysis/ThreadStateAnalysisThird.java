package com.zkn.newlearn.thread.analysis;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * 查询CPU占比高的线程：
 * 1、使用top -H命令查看CPU运行高的 进程号 PID
 * 或者直接 top -H -p pid进程号  最消耗资源最高的线程
 * 2、使用 printf "%x\n" tid线程号  转换为 16进行
 * 3、打印线程的堆栈信息 jstack tid|grep tid的16进制值 -A 30
 *
 * @author zkn
 * @date 2018/6/2 21:23
 */
public class ThreadStateAnalysisThird {

    private ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        ThreadStateAnalysisThird wait = new ThreadStateAnalysisThird();
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
    }

    public void methodA() {
        //获取锁一定不能try里
        reentrantLock.lock();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放锁一定要在这里
            reentrantLock.unlock();
        }
    }
}
