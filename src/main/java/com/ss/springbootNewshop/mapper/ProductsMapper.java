package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.Products;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsMapper {
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