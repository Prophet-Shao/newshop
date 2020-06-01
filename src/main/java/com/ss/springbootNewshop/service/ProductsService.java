package com.ss.springbootNewshop.service;

import com.ss.springbootNewshop.bean.Products;

import java.util.List;

public interface ProductsService {

    int deleteByPrimaryKey(Integer id);

    int insert(Products record);

    int insertSelective(Products record);

    Products selectByPrimaryKey(Integer id);

    Products selectByProductsName(String productsName);

    Products selectByProductsCode(String memo2);

    int updateByPrimaryKeySelective(Products record);

    int updateByPrimaryKey(Products record);

    List<Products> queryProductsList();

    List<Products> selectByCategory(String category);

    List<Products> selectByProducts(Products products);
}
