package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.EcomShop;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EcomShopMapper {
    int deleteByPrimaryKey(Long shopId);

    int insert(EcomShop record);

    int insertSelective(EcomShop record);

    EcomShop selectByPrimaryKey(Long shopId);

    EcomShop selectByShopName(String shopName);

    int updateByPrimaryKeySelective(EcomShop record);

    int updateByPrimaryKey(EcomShop record);

    List<EcomShop> queryEcomShop();

}