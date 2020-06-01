package com.ss.springbootNewshop.service.impl;

import com.ss.springbootNewshop.bean.EcomShop;
import com.ss.springbootNewshop.mapper.EcomShopMapper;
import com.ss.springbootNewshop.service.EcomShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: EcomShopServiceImpl
 * @User: 邵帅
 * @Date: 2020/2/1715:55
 * Version 1.0
 * Description: TODO
 **/
@Service
public class EcomShopServiceImpl implements EcomShopService {

    private static final Logger logger = LoggerFactory.getLogger(EcomShopServiceImpl.class);

    @Autowired
    private EcomShopMapper ecomShopMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long shopId) {
        return ecomShopMapper.deleteByPrimaryKey(shopId);
    }

    @Transactional
    @Override
    public int insert(EcomShop record) {
        return ecomShopMapper.insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(EcomShop record) {
        return ecomShopMapper.insertSelective(record);
    }

    @Override
    public EcomShop selectByPrimaryKey(Long shopId) {
        return ecomShopMapper.selectByPrimaryKey(shopId);
    }

    @Override
    public EcomShop selectByShopName(String shopName) {
        return ecomShopMapper.selectByShopName(shopName);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(EcomShop record) {
        return ecomShopMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(EcomShop record) {
        return ecomShopMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<EcomShop> queryEcomShop() {
        return ecomShopMapper.queryEcomShop();
    }
}
