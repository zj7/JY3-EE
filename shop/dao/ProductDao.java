package com.shop.dao;

import com.shop.pojo.Product;

import java.util.List;

public interface ProductDao {

    //添加商品
    void addPro(Product pro);

    //修改商品信息
    void updatePro(Product pro);

    //删除商品
    void deletePro(String pro_id);

    //查询全部商品
    public List<Product> getAllProducts();
}
