package com.zkn.newlearn.thread;

/**
 * Created by wb-zhangkenan on 2016/11/4.
 */
/**
 * @author Eric
 *
 * @version 1.0
 */

public class ThreadTestVolatile02 {

    public static void main(String[] args) {

        /** 记录循环次数 */
        int loopCount = 0;

        /** 以main函数主线程创建一个是线程组 */
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();

        for (;;) {
            loopCount++;

			/*
			 * 启动500个线程，初始化的线程会添加到当前线程组中
			 */
            NonSafeThread nonSafeThread = new NonSafeThread();
            startThreads(nonSafeThread);

			/*
			 * 如果线程组中除了主线程之外，还有其它线程，则休眠5毫秒，然后再判断线程组中 剩余的线程数，直到只剩下主线程一个为止。
			 */
            while (!isOnlyMainThreadLeft(threadGroup)) {
                sleep(5);
            }
            threadGroup.list();
			/*
			 * 500个线程运行完毕，那么此时的volatile变量volatileCount的值应该500， 因为每个线程将其值加1。
			 *
			 * 验证是否出现线程不安全的情况。
			 */
            validate(loopCount, nonSafeThread.getVolatileCount(), 500);
        }
    }

    /**
     * 启动500个线程
     */
    private static void startThreads(NonSafeThread nonSafeThread) {

        for (int i = 0; i < 500; i++) {
            new Thread(nonSafeThread).start();
        }
    }

    /**
     * 验证是否出现线程不安全的情况。 如果是，则打印出线程不安全的信息。
     */
    private static void validate(int loopCount, int actualValue,
                                 int expectedValue) {
        if (!isVolatileCountExpected(actualValue, expectedValue)) {
            printNonSafeMessage(loopCount, actualValue, expectedValue);
			/*
			 * 正常退出程序。
			 */
            System.exit(0);
        }
    }

    /**
     * 在控制台打印出现线程不安全时的信息。
     */
    private static void printNonSafeMessage(int loopCount, int actualValue,
                                            int expectedValue) {
        System.out.println(String.format(
                "第%d次循环，出现线程不安全的情况，volatile的值不正确,期望值是%d, 但是500个线程运行的情况下是%d",
                loopCount, expectedValue, actualValue));
    }

    /**
     * 判断实际中的volatile值与期望值是否一致。
     */
    private static boolean isVolatileCountExpected(int actualValue,
                                                   int expectedValue) {
        return actualValue == expectedValue;
    }

    /**
     * 让线程休眠millis毫秒
     */
    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 判断一个线程组是否只剩下主线程了。
     *
     * 如果是则返回true，如果不是则放回false.
     */
    private static boolean isOnlyMainThreadLeft(ThreadGroup tg) {
        return tg.activeCount() == 1;
    }

}
