package com.neuedu.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

    private static Properties prop;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            prop = new Properties();
            prop.load(DBUtils.class.getResourceAsStream("/mysql.properties"));
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static final String URL = prop.getProperty("url");

    private static final String USERNAME = prop.getProperty("username");

    private static final String PASSWORD = prop.getProperty("password");

    public static Connection getConnection(){
        Connection conn = null;
        try {
            if (null == conn){
                conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}
