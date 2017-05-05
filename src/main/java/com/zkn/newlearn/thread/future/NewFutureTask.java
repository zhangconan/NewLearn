package com.zkn.newlearn.thread.future;

import java.util.concurrent.TimeUnit;

/**
 * Created by wb-zhangkenan on 2017/5/5.
 *
 * @author wb-zhangkenan
 * @date 2017/05/05
 */
public class NewFutureTask<V> implements NewRunnableFuture<V> {
    /**
     * 回调的接口
     */
    private NewCallable<V> callable;
    /**
     * 返回的结果
     */
    private V result;
    /**
     * 这里一定要定义成volatile，要不然程序停不下来。
     * volatile的内存语义。每次都从主存中读取数据。
     */
    private volatile boolean isFinish;

    public NewFutureTask(NewCallable<V> callable) {
        this.callable = callable;
    }

    public NewFutureTask(Runnable runnable, V result) {

        this.callable = new RunnableAdapter<>(runnable, result);
    }

    @Override
    public V get() {
        if (!isFinish) {
            for(;;){
                if(isFinish){
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public void run() {
        try {
            result = callable.call();
            TimeUnit.SECONDS.sleep(2L);
            isFinish = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
