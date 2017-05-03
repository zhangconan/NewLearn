package com.zkn.newlearn.jdbc.mysql.second;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by wb-zhangkenan on 2017/5/3.
 *
 * @author wb-zhangkenan
 * @date 2017/05/03
 */
public class DataSourcePool {
    /**
     * 十个长度的连接池
     */
    public static BlockingQueue<Connection> pool = new LinkedBlockingDeque(10);
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
        InputStream is = DataSourcePool.class.getResourceAsStream("driver.properties");
        try {
            properties.load(is);
            URL = (String)properties.get("url");
            USER_NAME = (String)properties.get("userName");
            PASS_WORD = (String)properties.get("passWord");
            DRIVER_CLASS_NAME = (String)properties.get("driverClassName");
            //加载驱动
            Class.forName(DRIVER_CLASS_NAME);
            Connection connection = null;
            for (int i = 0; i < 10; i++) {
                connection = DriverManager.getConnection(URL,USER_NAME,PASS_WORD);
                //这里会阻塞
                pool.put(connection);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取一个连接
     * @return
     */
    public static Connection getConnection(){
        try {
            return pool.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 释放连接
     * @param connection
     */
    public static void release(Connection connection){
        try {
            //如果连接已经被关闭了 重新创建一个连接
            if(connection.isClosed()){
                pool.put(DriverManager.getConnection(URL,USER_NAME,PASS_WORD));
                return;
            }
            if(connection.getAutoCommit() == false){
                //恢复默认值
                connection.setAutoCommit(true);
            }
            pool.put(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
