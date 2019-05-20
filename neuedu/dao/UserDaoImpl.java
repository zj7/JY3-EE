package com.neuedu.dao;

import com.neuedu.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * UserDao实现类
 */
public class UserDaoImpl implements UserDao{

    @Override
    public void register(String user, String psw) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "INSERT INTO register(username,password) VALUES(?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user);
            pstmt.setString(2,psw);
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if (null != pstmt){
                try {
                    pstmt.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (null != conn){
                try {
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
