package com.lightwing.mybatis.jdbc;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import org.junit.Test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC_Test {
    @Test
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 1.加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2.通过驱动管理类获取数据库链接
            connection = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/MyBatis?characterEncoding=utf-8",
                    "root",
                    "canton0520"
            );

            // 3.定义 SQL 语句 ?表示占位符
            String sql = "SELECT * FROM `user` WHERE id > ?";

            // 4.获取预处理statement
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);

            // 5.设置参数，第一个参数为 SQL 语句中参数的序号（从1开始），第二个参数为设置的参数值
            preparedStatement.setString(1, "0");

            // 6.向数据库发出 SQL 执行查询，查询出结果集 resultSet
            resultSet = preparedStatement.executeQuery();

            // 7. 遍历查询结果集
            int count = 0;
            while (resultSet.next()) {
                count += 1;
                System.out.println(
                        "ID: " + resultSet.getString("id") +
                                ", Name: " + resultSet.getString("username") +
                                ", Birthday: " + resultSet.getString("birthday") +
                                ", Gender: " + resultSet.getString("sex") +
                                ", Address: " + resultSet.getString("address")
                );
            }
            System.out.println("TOTAL: " + count + " RECORDS FOUND");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 8.释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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