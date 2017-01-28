package com.zkn.newlearn.thread.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wb-zhangkenan on 2017/1/23.
 */
public class ConnectionPoolTest {
    //初始化10个连接
    static ConnectionPool pool = new ConnectionPool(10);
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;

    public static void main(String[] args) {

        int threadCount = 10;
        //保证所以的线程都被终止掉
        end = new CountDownLatch(threadCount);
        int count = 20;
        //保证原子操作
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count,got,notGot),"ConnectinRunner");
            thread.start();
        }
        //所有的线程同一时刻开始运行
        start.countDown();
        try {
            //使主线程在锁存器倒计数至零之前一直等待，
            //阻塞主线程 还有一个重载的方法,带超时时间的
            end.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("total invoke: "+(threadCount*count));
        System.out.println("got connection: "+got.longValue());
        System.out.println("not got connection: "+notGot.longValue());
    }

    static class ConnectionRunner implements Runnable {

        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                //为了让上面的线程能同时开始运行
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count > 0){
                try{
                    //设置取Connection的超时时间
                    Connection connection = pool.fetchConnection(1000);
                    if(connection != null){
                        try {
                            connection.createStatement();
                            connection.commit();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    }else{
                        notGot.incrementAndGet();
                    }
                }catch (Exception e){

                }finally {
                    count--;
                }
            }
            //递减锁存器的计数，如果计数到达零，则释放所有等待的线程
            end.countDown();
        }
    }
}
