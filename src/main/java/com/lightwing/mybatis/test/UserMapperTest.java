package com.lightwing.mybatis.test;

import com.lightwing.mybatis.mapper.UserMapper;
import com.lightwing.mybatis.pojo.User;
import com.lightwing.mybatis.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class UserMapperTest {
    @Test
    public void testGetUserById() {
        // 1.加载配置得到 SqlSession
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        // 2.获取代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 3.查询数据
        User user = userMapper.getUserById(12998);
        System.out.println(user);
        // 4.关闭资源
        sqlSession.close();
    }

    @Test
    public void testGetUserByUserName() {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        // 1.获取代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 2.查询数据
        List<User> list = userMapper.getUserByUserName("Lo");
        for (User user : list) {
            System.out.println(user);
        }
        // 3.关闭资源
        sqlSession.close();
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();

        user.setUsername("Karen Cheung");
        user.setAddress("Shanghai");
        user.setBirthday(new Date());
        user.setSex("F");

        userMapper.insertUser(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
