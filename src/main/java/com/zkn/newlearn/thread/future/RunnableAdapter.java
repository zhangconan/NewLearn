package com.zkn.newlearn.thread.future;



/**
 * Created by wb-zhangkenan on 2017/5/5.
 * 对象的适配器模式
 * @author wb-zhangkenan
 * @date 2017/05/05
 */
public class RunnableAdapter<V> implements NewCallable<V>{
    //适配的对象
    private Runnable task;
    private V result;

    public RunnableAdapter(Runnable task, V result) {
        this.task = task;
        this.result = result;
    }

    @Override
    public V call() {
        task.run();
        return result;
    }
}
