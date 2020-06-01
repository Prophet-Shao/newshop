package com.ss.springbootNewshop.service;

import com.ss.springbootNewshop.bean.SalesReturnsDetail;

public interface SalesReturnsDetailService {

    int deleteByPrimaryKey(Long returnsDetailId);

    int insert(SalesReturnsDetail record);

    int insertSelective(SalesReturnsDetail record);

    SalesReturnsDetail selectByPrimaryKey(Long returnsDetailId);

    int updateByPrimaryKeySelective(SalesReturnsDetail record);

    int updateByPrimaryKey(SalesReturnsDetail record);
}
