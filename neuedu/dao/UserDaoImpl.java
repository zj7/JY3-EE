package com.neuedu.dao;

import com.neuedu.entity.User;
import com.neuedu.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * UserDao实现类
 */
public class UserDaoImpl implements UserDao{

    //注册的方法
    @Override
    public void register(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "INSERT INTO register(username,password) VALUES(?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.closePstmt(pstmt);
            DBUtils.closeConn(conn);
        }
    }

    //登录的方法
    @Override
    public boolean login(User user1) {
        //布尔类型结果变量
        boolean result = false;

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT username,password FROM register WHERE username=? AND password=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user1.getUsername());
            pstmt.setString(2,user1.getPassword());
            rs = pstmt.executeQuery();
            if (rs.next()){
                result = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DBUtils.closeRs(rs);
            DBUtils.closePstmt(pstmt);
            DBUtils.closeConn(conn);
        }
        return result;
    }

    //修改密码的方法
    @Override
    public void updatePsw(User user,String newPsw) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "UPDATE register SET password=? WHERE username=? AND password=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,newPsw);
            pstmt.setString(2,user.getUsername());
            pstmt.setString(3,user.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.closePstmt(pstmt);
            DBUtils.closeConn(conn);
        }
    }

    //查询全部用户的方法
    @Override
    public List<User> queryAll() {
        List<User> users = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT username,password FROM register";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if(rs.next()){
                String user = rs.getString("username");
                String psw = rs.getString("password");
                users.add(new User(user,psw));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.closeRs(rs);
            DBUtils.closePstmt(pstmt);
            DBUtils.closeConn(conn);
        }
        return users;
    }


}
