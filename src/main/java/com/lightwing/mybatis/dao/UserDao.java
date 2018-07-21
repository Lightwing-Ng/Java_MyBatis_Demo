package com.lightwing.mybatis.dao;

import com.lightwing.mybatis.pojo.User;

import java.util.List;

public interface UserDao {
    User getUserById(Integer id);

    List<User> getUserByUserName(String name);

    void insertUser(User user);
}
