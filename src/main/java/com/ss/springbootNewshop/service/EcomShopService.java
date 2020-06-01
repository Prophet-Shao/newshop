package com.ss.springbootNewshop.service;

import com.ss.springbootNewshop.bean.EcomShop;

import java.util.List;

/**
 * @ClassName: EcomShopService
 * @User: 邵帅
 * @Date: 2020/2/1713:15
 * Version 1.0
 * Description: TODO
 **/
public interface EcomShopService {

    int deleteByPrimaryKey(Long shopId);

    int insert(EcomShop record);

    int insertSelective(EcomShop record);

    EcomShop selectByPrimaryKey(Long shopId);

    EcomShop selectByShopName(String shopName);

    int updateByPrimaryKeySelective(EcomShop record);

    int updateByPrimaryKey(EcomShop record);

    List<EcomShop> queryEcomShop();

}
