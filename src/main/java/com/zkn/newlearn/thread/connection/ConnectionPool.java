package com.zkn.newlearn.thread.connection;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created by wb-zhangkenan on 2017/1/23.
 * 数据库连接池
 */
public class ConnectionPool {

    private LinkedList<Connection> pool = new LinkedList<>();

    /**
     * 初始化一定数量的连接(连接池)
     * @param initialSize
     */
    public ConnectionPool(int initialSize) {
        if(initialSize > 0){
            for(int i=0;i<initialSize;i++){
                pool.add(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection){
        if(connection != null){
            synchronized (pool){
                //释放连接，把连接重新放到连接池中
                pool.addLast(connection);
                //唤醒其他等待的连接
                pool.notifyAll();
            }
        }
    }

    public Connection fetchConnection(long mills){

        synchronized (pool){
            if(mills <= 0) {
                while (pool.isEmpty()){
                    try {
                        pool.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return pool.removeFirst();
            }else{
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                //如果等待时间够了之后，就开始执行后面的内容，所以Connection可能为null
                while (pool.isEmpty() && remaining > 0){
                    try {
                        pool.wait(remaining);
                        remaining = future - System.currentTimeMillis();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Connection result = null;
                if(!pool.isEmpty()){
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }
}
