package com.lightwing.mybatis.test;

import com.lightwing.mybatis.pojo.User;
import com.lightwing.mybatis.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBatisTest {
    @Test
    public void testGetUserById() throws IOException {
        // 1.创建 SqlSessionFactoryBuilder 对象
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();

        // 2.创建核心配置的输入流
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = sfb.build(inputStream);

        // 3.创建 SqlSession 对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        for (int i = 10000; i < 10001; i++) {
            // 4.执行查询
            User user = sqlSession.selectOne("user.getUserById", i);
            if (user != null)
                System.out.println(user);
        }

        // 5.释放资源
        sqlSession.close();
    }

    @Test
    public void getUserByName() throws IOException {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        String name = "Light";
        List<User> users = sqlSession.selectList("user.getUserByName", name);

        System.out.println("Result of users contains of: " + name);
        for (User user : users)
            System.out.println(user);
    }

    public void testInsertUser() throws IOException {
        // 1. 创建 SqlSession 对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        User user = new User();
        user.setId(50821);
        user.setUsername("Nelson Englishby");
        user.setBirthday(new Date());
        user.setSex("M");
        user.setAddress("73 Delaware Place");

        // 2.执行插入
        sqlSession.insert("user.insertUser", user);
        // 3.提交事务
        sqlSession.commit();
        // 4.释放资源
        sqlSession.close();
    }
}
