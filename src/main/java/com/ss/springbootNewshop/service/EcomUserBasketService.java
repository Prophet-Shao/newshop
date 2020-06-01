package com.ss.springbootNewshop.service;

import com.ss.springbootNewshop.bean.EcomUserBasket;

import java.util.List;

public interface EcomUserBasketService {

    int deleteByPrimaryKey(Long customersBasketId);

    int insert(EcomUserBasket record);

    int insertSelective(EcomUserBasket record);

    EcomUserBasket selectByPrimaryKey(Long customersBasketId);

    int updateByPrimaryKeySelective(EcomUserBasket record);

    int updateByPrimaryKey(EcomUserBasket record);

    List<EcomUserBasket> queryEcomUserBasket();

    List<EcomUserBasket> selectByUserName(String userName);

    List<EcomUserBasket> selectByUserId(Long userId);

    List<EcomUserBasket> selectByBasket(EcomUserBasket ecomUserBasket);
}
