package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.EcomUserBasket;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EcomUserBasketMapper {
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