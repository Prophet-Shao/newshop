package com.ss.springbootNewshop.service;


import com.ss.springbootNewshop.bean.ProductsUnit;

import java.util.List;

public interface ProductsUnitService {

    int deleteByPrimaryKey(Long unitId);

    int insert(ProductsUnit record);

    int insertSelective(ProductsUnit record);

    ProductsUnit selectByPrimaryKey(Long unitId);

    ProductsUnit selectByUnitName(String symbol);

    int updateByPrimaryKeySelective(ProductsUnit record);

    int updateByPrimaryKey(ProductsUnit record);

    List<ProductsUnit> queryUnitInfo();
}
