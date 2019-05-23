package com.neuedu.dataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class DruidDataSource {

    //配置文件
    private static Properties prop = new Properties();

    //单例模式
    private static DruidDataSource ds = null;

    private DruidDataSource(){

    }

    public static DruidDataSource getDataSource(){
        if (null == ds){
            ds = new DruidDataSource();
        }
        return ds;
    }

    //拿到连接
    public Connection getConnection(){
        try {
            prop.load(DruidDataSource.class.getResourceAsStream("/mysql.properties"));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
            Connection connection = dataSource.getConnection();
            return connection;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //拿连接的测试
//    public static void main(String[] args) {
//        DruidDataSource druidDataSource = DruidDataSource.getDataSource();
//        Connection connection = druidDataSource.getConnection();
//        System.out.println(connection);
//    }
}
