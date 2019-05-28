package com.shop.dao;

import com.shop.pojo.User;


public interface UserDao {

    //添加用户
    void addUser(User user);

    //登录
    boolean login(User user);
}
