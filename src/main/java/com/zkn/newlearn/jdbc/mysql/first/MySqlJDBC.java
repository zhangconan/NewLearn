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
     * 用户名
     */
    private static String USER_NAME;
    /**
     * 密码
     */
    private static String PASS_WORD;
    /**
     * 存放属性信息
     */
    private static Properties properties = new Properties();

    static {
        InputStream is = MySqlJDBC.class.getResourceAsStream("driver.properties");
        try {
            properties.load(is);
            URL = (String)properties.get("url");
            USER_NAME = (String)properties.get("userName");
            PASS_WORD = (String)properties.get("passWord");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询操作
     */
    @Test
    public void testStatementQuery() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //加载连接 这里会导致类的初始化
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库驱动
            connection = DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
            //获取sql的声明
            statement = connection.createStatement();
            //执行查询的操作
            resultSet = statement.executeQuery("SELECT * FROM TABLE_NAME");
            //取出查询出来的数据
            StringBuilder sb = new StringBuilder();
            while (resultSet.next()) {

                sb.append(resultSet.getLong("id")).append("  ");
                //这里需要注意的是下标是从1开始的，不是从0开始的
                sb.append(resultSet.getString(2)).append("  ");
                sb.append(resultSet.getString("gmt_create")).append("  ");
                System.out.println(sb.toString());
                //清空原来的数据
                sb.delete(0, sb.length());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            //关闭sql声明
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            //关闭连接
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 预编译查询
     */
    @Test
    public void testPreparedStatement() {
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet resultSet = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            connection = DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
            String sql = "SELECT * FROM TABLE_NAME WHERE EMPID = ?";
            //获取sql声明
            pst = connection.prepareStatement(sql);
            //pst.setLong(1,2);
            //封装查询条件
            pst.setString(1, "32151");
            //执行sql的操作
            resultSet = pst.executeQuery();
            StringBuilder sb = new StringBuilder();
            while (resultSet.next()) {
                sb.append(resultSet.getLong("id")).append(" ");
                sb.append(resultSet.getString(2));
                System.out.println(sb.toString());
                //清空原来的数据
                sb.delete(0, sb.length());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 单条插入
     */
    @Test
    public void testInsert() {
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet resultSet = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            connection = DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
            //自动提交为false
            connection.setAutoCommit(false);
            //创建sql声明
            pst = connection.prepareStatement(
                "INSERT INTO TABLE_NAME (NAME,EMPID,ORG_ID,ORG_CODE,IS_ADMIN,GMT_CREATE,GMT_MODIFIED) VALUES (?,"
                    + "?,?,?,?,now(),now())",
                Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, "张三");
            pst.setString(2, "784550");
            pst.setLong(3, 2);
            pst.setString(4, "0.1.2");
            pst.setInt(5, 1);
            //执行插入操作
            int count = pst.executeUpdate();
            if (count > 0) {
                System.out.println("插入成功!");
            } else {
                System.out.println("插入失败!");
            }
            resultSet = pst.getGeneratedKeys();
            while (resultSet.next()) {
                System.out.println(String.format("主键值为%d", resultSet.getLong(1)));
            }
            //提交操作
            connection.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            //异常回滚
            try {
                connection.rollback();
            } catch (SQLException ee) {
                ee.printStackTrace();
            }
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 批量插入 需要设置 rewriteBatchedStatements=true
     */
    @Test
    public void testBatchInsert() {
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet resultSet = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            connection = DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
            //自动提交为false
            connection.setAutoCommit(false);
            //创建sql声明
            pst = connection.prepareStatement(
                "INSERT INTO TABLE_NAME (NAME,EMPID,ORG_ID,ORG_CODE,IS_ADMIN,GMT_CREATE,GMT_MODIFIED) VALUES (?,"
                    + "?,?,?,?,now(),now())",
                Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < 10; i++) {
                pst.setString(1, "张三");
                pst.setString(2, "784550");
                pst.setLong(3, 2);
                pst.setString(4, "0.1.2");
                pst.setInt(5, 1);
                pst.addBatch();
            }
            int[] count = pst.executeBatch();
            if (count != null && count.length > 0) {
                System.out.println("插入成功!");
            } else {
                System.out.println("插入失败!");
            }
            resultSet = pst.getGeneratedKeys();
            while (resultSet.next()) {
                System.out.println(String.format("主键值为%d", resultSet.getLong(1)));
            }
            //提交操作
            connection.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            //异常回滚
            try {
                connection.rollback();
            } catch (SQLException ee) {
                ee.printStackTrace();
            }
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate() {
        Connection connection = null;
        PreparedStatement pst = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            connection = DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
            //自动提交为false
            connection.setAutoCommit(false);
            //创建sql声明
            pst = connection.prepareStatement("update TABLE_NAME set name = ? where id >=? and id <= ? ");
            pst.setString(1, "李思思");
            pst.setLong(2, 1972);
            pst.setLong(3, 1995);
            int count = pst.executeUpdate();
            if (count > 0) {
                System.out.println("更新成功!");
            } else {
                System.out.println("更新失败");
                return;
            }
            //提交操作
            connection.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            //异常回滚
            try {
                connection.rollback();
            } catch (SQLException ee) {
                ee.printStackTrace();
            }
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDelete() {
        Connection connection = null;
        PreparedStatement pst = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            connection = DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
            //自动提交为false
            connection.setAutoCommit(false);
            //创建sql的声明
            pst = connection.prepareStatement("DELETE FROM TABLE_NAME WHERE ID >=? AND ID <=? ");
            pst.setLong(1, 1972);
            pst.setLong(2, 1995);
            //执行sql
            pst.executeUpdate();
            //提交
            connection.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            //异常回滚
            try {
                connection.rollback();
            } catch (SQLException ee) {
                ee.printStackTrace();
            }
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}