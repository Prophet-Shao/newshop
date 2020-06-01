package com.ss.springbootNewshop.service;

import com.ss.springbootNewshop.bean.StockStockHouseRight;

public interface StockStockHouseRightService {

    int deleteByPrimaryKey(Long stockPurviewId);

    int insert(StockStockHouseRight record);

    int insertSelective(StockStockHouseRight record);

    StockStockHouseRight selectByPrimaryKey(Long stockPurviewId);

    int updateByPrimaryKeySelective(StockStockHouseRight record);

    int updateByPrimaryKey(StockStockHouseRight record);
}
