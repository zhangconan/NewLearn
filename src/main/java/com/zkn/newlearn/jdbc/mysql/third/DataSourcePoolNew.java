package com.zkn.newlearn.jdbc.mysql.third;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wb-zhangkenan on 2017/5/3.
 *
 * @date 2017/05/03
 */
public class DataSourcePoolNew {
    /**
     * 最大连接数
     */
    private static final int COUNT = 10;
    /**
     * 存放数据库
     */
    private static final LinkedList<Connection> connections = new LinkedList<>();
    /**
     * 创建锁
     */
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition notEmpty = lock.newCondition();
    private static final Condition notFull = lock.newCondition();
    /**
     * 数据库连接
     */
    private static String URL;
    /**
     * 用户名
     */
    private static String USER_NAME;
    /**
     * 密码
     */
    private static String PASS_WORD;
    /**
     * 驱动类型
     */
    private static String DRIVER_CLASS_NAME;
    /**
     * 存放属性信息
     */
    private static Properties properties = new Properties();

    /**
     * 初始化信息
     */
    static {
        InputStream is = DataSourcePoolNew.class.getResourceAsStream("driver.properties");
        try {
            properties.load(is);
            URL = (String) properties.get("url");
            USER_NAME = (String) properties.get("userName");
            PASS_WORD = (String) properties.get("passWord");
            DRIVER_CLASS_NAME = (String) properties.get("driverClassName");
            //加载驱动
            Class.forName(DRIVER_CLASS_NAME);
            Connection connection = null;
            for (int i = 0; i < 10; i++) {
                connection = DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
                connections.add(connection);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Connection
     */
    public static Connection getConnection() {
        final ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            //如果没有连接了，则等待着新放入的连接
            if (connections.isEmpty()) {
                notEmpty.await();
            }
            Connection connection = connections.removeFirst();
            notFull.signalAll();
            return connection;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
        return null;
    }

    /**
     * 释放连接
     *
     * @param connection
     */
    public static void release(Connection connection) {
        final ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            if (connections.size() == COUNT) {
                notFull.await();
            }
            if (connection == null || connection.isClosed()) {
                connections.add(DriverManager.getConnection(URL, USER_NAME, PASS_WORD));
                notEmpty.signalAll();
                return;
            }
            //恢复默认值
            if (connection.getAutoCommit() == false) {
                connection.setAutoCommit(true);
            }
            connections.add(connection);
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

}
