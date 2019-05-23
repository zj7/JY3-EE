package com.neuedu.dao;

import com.neuedu.dataSource.DruidDataSource;
import com.neuedu.pojo.User;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao{
    private QueryRunner qr = null;
    private DruidDataSource dds = DruidDataSource.getDataSource();

    public UserDaoImpl(){
        //构造器中初始化QueryRunner对象
        qr = new QueryRunner();
    }

    //查询所有用户的方法
    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM register";
        Connection conn = dds.getConnection();
        List<User> users = null;
        try {
            users = qr.query(conn,sql,new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    @Override
        public void updateUser(User newUser) {
        String sql = "UPDATE register SET username=?,password=? WHERE id=?";
        Connection conn = dds.getConnection();
        try {
            qr.update(conn,sql,newUser.getUsername(),newUser.getPassword(),newUser.getId());
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

    @Override
    public void deleteUser(Integer id) {
        String sql = "DELETE FROM register WHERE id=?";
        Connection conn = dds.getConnection();
        try {
            qr.update(conn,sql,id);
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
