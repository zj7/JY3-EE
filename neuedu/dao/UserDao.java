package com.neuedu.dao;

import com.neuedu.entity.User;

import java.util.List;

public interface UserDao {
    //注册的方法
    void register(User user);

    //登录的方法
    boolean login(User user);

    //修改密码的方法
    void updatePsw(User user,String newPsw);

    //查询全部用户
    List<User> queryAll();
}
