package com.ss.springbootNewshop.service.impl;

import com.ss.springbootNewshop.bean.ProductsUnit;
import com.ss.springbootNewshop.mapper.ProductsUnitMapper;
import com.ss.springbootNewshop.service.ProductsUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: ProductsUnitServiceImpl
 * @User: 邵帅
 * @Date: 2020/2/811:47
 * Version 1.0
 * Description: 商品单位
 **/
@Service
public class ProductsUnitServiceImpl implements ProductsUnitService {

    @Autowired
    private ProductsUnitMapper productsUnitMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long unitId) {
        return productsUnitMapper.deleteByPrimaryKey(unitId);
    }

    @Transactional
    @Override
    public int insert(ProductsUnit record) {
        return productsUnitMapper.insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(ProductsUnit record) {
        return productsUnitMapper.insertSelective(record);
    }

    @Override
    public ProductsUnit selectByPrimaryKey(Long unitId) {
        return productsUnitMapper.selectByPrimaryKey(unitId);
    }

    @Override
    public ProductsUnit selectByUnitName(String symbol) {
        return productsUnitMapper.selectByUnitName(symbol);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(ProductsUnit record) {
        return productsUnitMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(ProductsUnit record) {
        return productsUnitMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ProductsUnit> queryUnitInfo() {
        return productsUnitMapper.queryUnitInfo();
    }
}
