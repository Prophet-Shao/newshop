package com.ss.springbootNewshop.service.impl;

import com.ss.springbootNewshop.bean.Products;
import com.ss.springbootNewshop.mapper.ProductsMapper;
import com.ss.springbootNewshop.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: ProductsServiceImpl
 * @User: 邵帅
 * @Date: 2020/2/823:34
 * Version 1.0
 * Description: TODO
 **/
@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsMapper productsMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return productsMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public int insert(Products record) {
        return productsMapper.insert(record);
    }

    @Override
    public int insertSelective(Products record) {
        return productsMapper.insertSelective(record);
    }

    @Override
    public Products selectByPrimaryKey(Integer id) {
        return productsMapper.selectByPrimaryKey(id);
    }

    @Override
    public Products selectByProductsName(String productsName) {
        return productsMapper.selectByProductsName(productsName);
    }

    @Override
    public Products selectByProductsCode(String memo2) {
        return productsMapper.selectByProductsCode(memo2);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(Products record) {
        return productsMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(Products record) {
        return productsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Products> queryProductsList() {
        return productsMapper.queryProductsList();
    }

    @Override
    public List<Products> selectByCategory(String category) {
        return productsMapper.selectByCategory(category);
    }

    @Override
    public List<Products> selectByProducts(Products products) {
        return productsMapper.selectByProducts(products);
    }
}
