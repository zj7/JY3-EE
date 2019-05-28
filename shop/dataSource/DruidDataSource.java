package com.shop.dataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class DruidDataSource {

    private static Properties prop = new Properties();

    private static DruidDataSource ds = null;

    private DruidDataSource(){

    }

    public static DruidDataSource getDataSource(){
        if (null == ds){
            ds = new DruidDataSource();
        }
        return ds;
    }

    public Connection getConnection(){
        try {
            prop.load(DruidDataSource.class.getResourceAsStream("/mysql.properties"));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
            Connection conn = dataSource.getConnection();
            return conn;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
