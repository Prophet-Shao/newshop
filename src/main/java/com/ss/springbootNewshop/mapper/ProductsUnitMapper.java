package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.ProductsUnit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsUnitMapper {
    int deleteByPrimaryKey(Long unitId);

    int insert(ProductsUnit record);

    int insertSelective(ProductsUnit record);

    ProductsUnit selectByPrimaryKey(Long unitId);

    ProductsUnit selectByUnitName(String symbol);

    int updateByPrimaryKeySelective(ProductsUnit record);

    int updateByPrimaryKey(ProductsUnit record);

    List<ProductsUnit> queryUnitInfo();
}