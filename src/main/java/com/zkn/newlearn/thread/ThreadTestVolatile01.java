package com.zkn.newlearn.thread;

/**
 * Created by wb-zhangkenan on 2016/11/4.
 */
public class ThreadTestVolatile01 {

    public static void main(String[] args){
        int value = 100;
        //控制循环次数
        int loops = 0;
        //获取线程组
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        while(loops < 1000){
            //让多线程共享TestVolatile中count值
            TestVolatile testVolatile = new TestVolatile();
            for(int i=0;i<value;i++){
                new Thread(testVolatile).start();
            }
            do{
                try {
                    //让线程休眠15秒
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }while (threadGroup.activeCount() != 2);
            threadGroup.list();
            if(testVolatile.getCount() != value){
                System.out.println("循环到第"+loops+"遍时，出现线程不安全的情况!!");
                System.out.println("此时 count值为："+testVolatile.getCount());
                System.exit(0);
            }
            loops++;
        }
    }
}

class TestVolatile implements Runnable{

    private volatile int count;

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            Math.hypot(Math.pow(92456789,i),Math.cos(i));
        }
        /*
        synchronized (this){
            count++;
        }*/
        count++;
    }

    public int getCount() {

        return count;
    }
}