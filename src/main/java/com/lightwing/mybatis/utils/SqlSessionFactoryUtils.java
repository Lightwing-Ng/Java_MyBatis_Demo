package com.lightwing.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtils {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        // 创建 SqlSessionFactoryBuilder 对象
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        try {
            // 查找配置文件创建输入流
            InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
            // 加载配置文件，创建 SqlSessionFactory 对象
            sqlSessionFactory = sfb.build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
