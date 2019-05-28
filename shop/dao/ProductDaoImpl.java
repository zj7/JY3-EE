package com.shop.dao;

import com.shop.dataSource.DruidDataSource;
import com.shop.pojo.Product;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private QueryRunner qr;
    public ProductDaoImpl(){
        qr = new QueryRunner();
    }

    private DruidDataSource dds = DruidDataSource.getDataSource();

    //添加商品的方法
    @Override
    public void addPro(Product pro) {
        Connection conn = dds.getConnection();
        String sql = "INSERT INTO product VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            qr.update(conn,sql,pro.getPro_id(),pro.getPro_name(),pro.getPro_price(),pro.getPro_image(),pro.getPro_des(),pro.getPro_stock(),pro.getPro_date(),pro.getPro_category_id(),pro.getPro_factory());
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

    //修改商品信息
    @Override
    public void updatePro(Product pro) {
        Connection connection = dds.getConnection();
        String sql = "UPDATE product SET pro_name=?,pro_price=?,pro_image=?,pro_des=?,pro_stock=?,pro_date=?,pro_category_id=?,pro_factory=? WHERE pro_id=?";
        try {
            qr.update(connection,sql,pro.getPro_name(),pro.getPro_price(),pro.getPro_image(),pro.getPro_des(),pro.getPro_stock(),pro.getPro_date(),pro.getPro_category_id(),pro.getPro_factory(),pro.getPro_id());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //删除商品
    @Override
    public void deletePro(String pro_id) {
        Connection connection = dds.getConnection();
        String sql = "DELETE FROM product WHERE pro_id=?";
        try {
            qr.update(connection,sql,pro_id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //查询商品信息
    public List<Product> getAllProducts(){
        Connection connection = dds.getConnection();
        String sql = "SELECT * FROM product";
        try {
            List<Product> products = qr.query(connection,sql,new BeanListHandler<>(Product.class));
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
