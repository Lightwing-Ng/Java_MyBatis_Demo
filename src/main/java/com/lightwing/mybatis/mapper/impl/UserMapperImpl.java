package com.lightwing.mybatis.mapper.impl;

import com.lightwing.mybatis.mapper.UserMapper;
import com.lightwing.mybatis.pojo.User;
import com.lightwing.mybatis.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserMapperImpl implements UserMapper {
    @Override
    public User getUserById(Integer id) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        User user = sqlSession.selectOne("user.getUserById", id);
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> getUserByUserName(String name) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        List<User> list = sqlSession.selectList("user.getUserByName", name);
        sqlSession.close();
        return list;
    }

    @Override
    public void insertUser(User user) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        sqlSession.insert("user.insertUser", user);
        sqlSession.commit();
        sqlSession.close();
    }
}
