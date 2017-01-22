package com.zkn.newlearn.thread.multithread.art;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by wb-zhangkenan on 2017/1/22.
 * @Description:
 *  这个例子是用来描述java程序是多线程的
 *  从下面这个例子可以看出来当运行一个main方法的时候，启动的线程不止main线程一个，而是多个线程在后台运行。
 */
public class MultiThread {

    public static void main(String[] args){
        //获取java Thread管理MXBean
        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = mxBean.dumpAllThreads(false,false);
        //正在运行的线程信息
        for(int i=0;i<threadInfos.length;i++){
            System.out.println(threadInfos[i].getThreadId()+"  "+threadInfos[i].getThreadName());
        }
    }
}
