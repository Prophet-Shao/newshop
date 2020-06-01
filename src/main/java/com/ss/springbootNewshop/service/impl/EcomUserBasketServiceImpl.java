package com.ss.springbootNewshop.service.impl;

import com.ss.springbootNewshop.bean.EcomUserBasket;
import com.ss.springbootNewshop.mapper.EcomUserBasketMapper;
import com.ss.springbootNewshop.service.EcomUserBasketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: EcomUserBasketServiceImpl
 * @User: 邵帅
 * @Date: 2020/3/918:22
 * Version 1.0
 * Description: TODO
 **/
@Service
public class EcomUserBasketServiceImpl implements EcomUserBasketService {

    private static final Logger logger = LoggerFactory.getLogger(EcomUserBasketServiceImpl.class);

    @Autowired
    private EcomUserBasketMapper ecomUserBasketMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long customersBasketId) {
        return ecomUserBasketMapper.deleteByPrimaryKey(customersBasketId);
    }

    @Transactional
    @Override
    public int insert(EcomUserBasket record) {
        return ecomUserBasketMapper.insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(EcomUserBasket record) {
        return ecomUserBasketMapper.insertSelective(record);
    }

    @Override
    public EcomUserBasket selectByPrimaryKey(Long customersBasketId) {
        return ecomUserBasketMapper.selectByPrimaryKey(customersBasketId);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(EcomUserBasket record) {
        return ecomUserBasketMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(EcomUserBasket record) {
        return ecomUserBasketMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<EcomUserBasket> queryEcomUserBasket() {
        return ecomUserBasketMapper.queryEcomUserBasket();
    }

    @Override
    public List<EcomUserBasket> selectByUserName(String userName) {
        return ecomUserBasketMapper.selectByUserName(userName);
    }

    @Override
    public List<EcomUserBasket> selectByUserId(Long userId) {
        return ecomUserBasketMapper.selectByUserId(userId);
    }

    @Override
    public List<EcomUserBasket> selectByBasket(EcomUserBasket ecomUserBasket) {
        return ecomUserBasketMapper.selectByBasket(ecomUserBasket);
    }
}
