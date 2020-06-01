package com.ss.springbootNewshop.service;

import com.ss.springbootNewshop.bean.StockStock;

public interface StockStockService {
    int deleteByPrimaryKey(Long stockId);

    int insert(StockStock record);

    int insertSelective(StockStock record);

    StockStock selectByPrimaryKey(Long stockId);

    int updateByPrimaryKeySelective(StockStock record);

    int updateByPrimaryKey(StockStock record);
}
