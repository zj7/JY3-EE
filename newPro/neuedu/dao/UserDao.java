package com.neuedu.dao;

import com.neuedu.pojo.User;

import java.util.List;

public interface UserDao {

    //查询所有用户
    List<User> getAllUsers();

    //修改用户信息
    void updateUser(User newUser);

    //删除用户
    void deleteUser(Integer id);
}
