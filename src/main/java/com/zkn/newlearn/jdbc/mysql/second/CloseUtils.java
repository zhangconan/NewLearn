package com.zkn.newlearn.jdbc.mysql.second;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wb-zhangkenan on 2017/5/3.
 *
 * @author wb-zhangkenan
 * @date 2017/05/03
 */
public final class CloseUtils {

    private static Logger log = LoggerFactory.getLogger(CloseUtils.class);

    /**
     * 关闭ResultSet
     *
     * @param resultSet
     */
    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                log.info("关闭了");
                resultSet.close();
            } catch (SQLException e) {
                log.error("关闭resultSet出现异常!!!");
            }
        }
    }

    /**
     * 关闭statement
     *
     * @param statement
     */
    public static void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                log.error("关闭statement出现异常!!!");
            }
        }
    }

    /**
     * 关闭preparedStatement
     *
     * @param preparedStatement
     */
    public static void close(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                log.error("关闭preparedStatement出现异常!!!");
            }
        }
    }

    /**
     * 关闭connection
     * @param connection
     */
    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("关闭connection出现异常!!!");
            }
        }
    }
}
