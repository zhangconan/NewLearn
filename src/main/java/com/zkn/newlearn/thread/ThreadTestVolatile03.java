package com.zkn.newlearn.thread;

/**
 * Created by wb-zhangkenan on 2016/11/4.
 */
public class ThreadTestVolatile03 {

    public static void main(String[] args){

        TestVolatile testVolatile = new TestVolatile();
        for(int i=0;i<10000;i++){
            new Thread(testVolatile).start();
        }
        ThreadGroup tg = Thread.currentThread().getThreadGroup();
        while (tg.activeCount() != 2){
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        tg.list();
        if(tg.activeCount() == 2){
            System.out.println(testVolatile.getCount());
        }
    }
}
