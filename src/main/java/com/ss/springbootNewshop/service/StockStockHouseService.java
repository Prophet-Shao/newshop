package com.ss.springbootNewshop.service;

import com.ss.springbootNewshop.bean.StockStockHouse;

public interface StockStockHouseService {

    int deleteByPrimaryKey(Long stockhouseId);

    int insert(StockStockHouse record);

    int insertSelective(StockStockHouse record);

    StockStockHouse selectByPrimaryKey(Long stockhouseId);

    int updateByPrimaryKeySelective(StockStockHouse record);

    int updateByPrimaryKey(StockStockHouse record);
}
