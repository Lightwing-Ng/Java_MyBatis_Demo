package com.lightwing.mybatis.test;

import com.lightwing.mybatis.dao.UserDao;
import com.lightwing.mybatis.dao.impl.UserDaoImpl;
import com.lightwing.mybatis.pojo.User;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class UserDaoTest {
    @Test
    public void testGetUserById() {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.getUserById(10366);
        System.out.println(user);
    }

    @Test
    public void testGetUserByUserName() {
        UserDao userDao = new UserDaoImpl();
        List<User> list = userDao.getUserByUserName("app");
        for (User user : list)
            System.out.println(user);
    }

    public void testInsertUser() {
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setUsername("Lawson Liang");
        user.setAddress("Shenzhen");
        user.setBirthday(new Date());
        user.setSex("M");

        userDao.insertUser(user);
    }
}
