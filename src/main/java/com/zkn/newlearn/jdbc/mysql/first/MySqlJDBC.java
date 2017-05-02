package com.zkn.newlearn.jdbc.mysql.first;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by zkn on 2017/5/2.
 */
public class MySqlJDBC {
    /**
     * 数据库连接
     */
    private static String URL;
    /**
     *  用户名
     */
    private static String USER_NAME;
    /**
     *  密码
     */
    private static String PASS_WORD;
    /**
     * 存放属性信息
     */
    private static Properties properties = new Properties();

    static{
        InputStream is = MySqlJDBC.class.getResourceAsStream("driver.properties");
        try {
            properties.load(is);
            URL = (String) properties.get("url");
            USER_NAME = (String) properties.get("userName");
            PASS_WORD = (String) properties.get("passWord");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testStatementQuery(){
        try {
            //加载连接 这里会导致类的初始化
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库驱动
            Connection connection = DriverManager.getConnection(URL,USER_NAME,PASS_WORD);
            //获取sql的声明
            Statement statement = connection.createStatement();
            //执行查询的操作
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PROVINCE_CHINA");
            //取出查询出来的数据
            while (resultSet.next()){
                StringBuilder sb = new StringBuilder();
                sb.append(resultSet.getLong("id")).append("  ");
                //这里需要注意的是下标是从1开始的，不是从0开始的
                sb.append(resultSet.getString(2)).append("  ");
                sb.append(resultSet.getString("cname")).append("  ");
                System.out.println(sb.toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
