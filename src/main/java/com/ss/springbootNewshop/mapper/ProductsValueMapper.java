package com.ss.springbootNewshop.mapper;


import com.ss.springbootNewshop.bean.ProductsValue;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsValueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductsValue record);

    int insertSelective(ProductsValue record);

    ProductsValue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductsValue record);

    int updateByPrimaryKey(ProductsValue record);
}