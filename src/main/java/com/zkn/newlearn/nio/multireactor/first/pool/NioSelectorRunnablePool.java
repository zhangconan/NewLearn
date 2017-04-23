package com.zkn.newlearn.nio.multireactor.first.pool;

import com.zkn.newlearn.nio.multireactor.first.NioServerWorker;
import com.zkn.newlearn.nio.multireactor.first.NioServerBoss;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zkn on 2017/4/23.
 */
public class NioSelectorRunnablePool {

    private AtomicInteger bossIndex = new AtomicInteger();
    private Boss[] bosses;

    private AtomicInteger workerIndex = new AtomicInteger();
    private Worker[] workeres;

    public NioSelectorRunnablePool(Executor boss, Executor worker) {
        //创建Boss的工作线程
        initBoss(boss, 1);
        //创建Worker的工作线程
        initWorker(worker, Runtime.getRuntime().availableProcessors() * 2);
    }

    private void initWorker(Executor worker, int count) {
        this.workeres = new NioServerWorker[count];
        for (int i = 0; i < workeres.length; i++) {
            workeres[i] = new NioServerWorker(worker, "worker thread " + (i+1), this);
        }
    }

    private void initBoss(Executor boss, int count) {
        this.bosses = new Boss[count];
        for(int i=0;i<bosses.length;i++){
            this.bosses[i] = new NioServerBoss(boss,"boss thread"+i,this);
        }
    }
    /**
     * 获取下一个Worker
     * @return
     */
    public Worker getNextWorker(){
        return this.workeres[workerIndex.getAndIncrement() % this.workeres.length];
    }
    /**
     * 获取下一个Boss
     * @return
     */
    public Boss getNextBoss(){
        return this.bosses[workerIndex.getAndIncrement() % this.workeres.length];
    }
}
