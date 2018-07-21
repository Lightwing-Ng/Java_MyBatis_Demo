package com.lightwing.mybatis.mapper;

import com.lightwing.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    User getUserById(Integer id);

    List<User> getUserByUserName(String name);

    void insertUser(User user);
}