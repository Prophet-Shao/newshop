package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.ProductsAttribute;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsAttributeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductsAttribute record);

    int insertSelective(ProductsAttribute record);

    ProductsAttribute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductsAttribute record);

    int updateByPrimaryKey(ProductsAttribute record);
}