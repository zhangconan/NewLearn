package com.zkn.newlearn.thread;

/**
 * Created by zkn on 2016/11/14.
 * 传统的同步通信技术
 * 需求描述：
 *      子线程先运行10次，接着主线程运行20次，
 *      接着子线程运行10次，依次交替反复20次
 * 关键点：共同数据要放到一个类上。
 * 难点：可能想不用操作一个共同的对象来解决。
 * 多线程访问操作共同资源的时候，要在资源的类上进行操作。
 */
public class ThreadSynchronousCommunicationTest01 {

    public static void main(String[] args){
        //确保多线程对共同资源的操作，是操作在资源类上。
        SynchronousCommunication synchronousCommunication = new SynchronousCommunication();
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0;i<20;i++){
                            synchronousCommunication.sub(i);
                        }
                    }
                }
        ).start();
        for(int i=0;i<20;i++){
            synchronousCommunication.main(i);
        }
    }
}

/**
 * 通信类
 */
class SynchronousCommunication{
    /**
     * 线程执行的标记
     */
    private boolean flag = true;

    public synchronized void sub(int i){
        //这里要用while，防止线程被假唤醒
        //如果flag是false，说明主线程在执行，所以子线程要进入等待状态
        while(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int j=0;j<10;j++){
            System.out.println("子线程第"+i+"遍运行，运行到第"+j+"次");
        }
        //子线程执行完之后，要改变执行标记
        flag = false;
        //唤醒休眠中的线程（即这里的主线程）
        this.notifyAll();
    }

    public synchronized void main(int i){
        //这里要用while，防止线程被假唤醒
        //如果flag是false，说明子线程在执行，所以主线程要进入等待状态
        while (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int j=0;j<20;j++){
            System.out.println("主线程第"+i+"遍运行，运行到第"+j+"次");
        }
        //主线程执行完之后，要改变执行标记
        flag = true;
        //唤醒休眠中的线程（即这里的子线程）
        this.notifyAll();
    }
}


