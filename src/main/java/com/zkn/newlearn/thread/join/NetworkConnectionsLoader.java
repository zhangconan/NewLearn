package com.zkn.newlearn.thread.join;

import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 * Created by wb-zhangkenan on 2017/1/10.
 * Thread.join()，是用来指定当前主线程等待其他线程执行完毕后，再来继续执行Thread.join()后面的代码。
 */
public class NetworkConnectionsLoader implements Runnable{

    @Override
    public void run() {
        System.out.printf("Beginning network connect loading: %s\n",new Date());
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Network connect loading has finished: %s\n",new Date());
    }

    public static void main(String[] args){
        DataSourcesLoader dsLoader = new DataSourcesLoader();
        Thread thread1 = new Thread(dsLoader,"DataSourceThread");

        NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
        Thread thread2 = new Thread(ncLoader,"NetworkConnectionLoader");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join(1900);//这里改成3000结果会不一样。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: Configuration has been loaded: %s\n",new Date());
    }

}