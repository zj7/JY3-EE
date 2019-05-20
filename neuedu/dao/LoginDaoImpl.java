package com.neuedu.dao;

import com.neuedu.entity.User;
import com.neuedu.utils.DBUtils;

import java.sql.*;

public class LoginDaoImpl implements LoginDao{

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
//            System.out.println(result);
            if (rs.next()){
                result = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            if(null != rs){
                try {
                    rs.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
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
//        System.out.println("--------"+result);
        return result;
    }
}
