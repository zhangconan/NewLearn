package com.zkn.newlearn.io.nio.multireactor.first;

import com.zkn.newlearn.io.nio.multireactor.first.pool.NioSelectorRunnablePool;

import java.io.IOException;
import java.nio.channels.Selector;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by zkn on 2017/4/23.
 */
public abstract class AbstractNioSelector implements Runnable {
    /**
     * 线程池
     */
    private Executor executor;
    /**
     * NIO 选择器
     */
    protected Selector selector;
    /**
     * 选择器的wakeUp状态
     */
    private AtomicBoolean wakeUp = new AtomicBoolean();
    /**
     * 任务队列
     */
    private Queue<Runnable> taskQueue = new ConcurrentLinkedQueue();
    /**
     * 线程名称
     */
    private String threadName;
    /**
     * 线程管理对象
     */
    private NioSelectorRunnablePool selectorRunnablePool;

    public AbstractNioSelector(Executor executor, String threadName, NioSelectorRunnablePool selectorRunnablePool) {
        this.executor = executor;
        this.threadName = threadName;
        this.selectorRunnablePool = selectorRunnablePool;
        openSelector();
    }

    private void openSelector() {
        try {
            selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("创建Selector失败");
        }
        //执行线程任务
        executor.execute(this);
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.threadName);
        while (true) {
            try {
                //唤醒标志
                wakeUp.set(false);
                //获取选择键
                select(selector);
                //执行任务
                processTaskQueue();
                //处理选择器任务
                process(selector);
            } catch (Exception e) {
            }
        }
    }

    /**
     * 注册任务进来
     *
     * @param runnable
     */
    protected final void registerTask(Runnable runnable) {
        taskQueue.add(runnable);

        Selector selector = this.selector;
        if (selector != null) {
            if (wakeUp.compareAndSet(false, true)) {
                selector.wakeup();
            }
        } else {
            taskQueue.remove(runnable);
        }
    }

    /**
     * 执行队列里的任务
     */
    private void processTaskQueue() {
        for (; ; ) {
            final Runnable task = taskQueue.poll();
            if (task == null) {
                break;
            }
            task.run();
        }
    }

    /**
     * 获取线程管理对象
     *
     * @return
     */
    public NioSelectorRunnablePool getSelectorRunnablePool() {
        return selectorRunnablePool;
    }

    /**
     * select抽象方法
     *
     * @param selector
     * @return
     * @throws IOException
     */
    protected abstract int select(Selector selector) throws IOException;

    /**
     * selector的业务处理
     *
     * @param selector
     * @throws IOException
     */
    protected abstract void process(Selector selector) throws IOException;

}
