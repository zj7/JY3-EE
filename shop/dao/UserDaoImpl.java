package com.shop.dao;

import com.shop.dataSource.DruidDataSource;
import com.shop.pojo.User;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao{
    private QueryRunner qr;

    public UserDaoImpl(){
        qr = new QueryRunner();
    }

    private DruidDataSource dds = DruidDataSource.getDataSource();

    //登录的方法
    @Override
    public boolean login(User user1) {
        Connection conn = dds.getConnection();
        String sql = "SELECT username,password FROM users WHERE username=? AND password=?";
        try {
            User user = qr.query(conn,sql,new BeanHandler<>(User.class), user1.getUsername(), user1.getPassword());
            if (null != user){
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    //添加用户
    @Override
    public void addUser(User user) {
        Connection conn = dds.getConnection();
        String sql = "INSERT INTO users(username,password,registerDate) VALUES(?,?,?)";
        try {
            qr.update(conn,sql,user.getUsername(),user.getPassword(),user.getRegisterDate());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
