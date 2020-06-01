package com.ss.springbootNewshop.service;

import com.ss.springbootNewshop.bean.StockStockDetail;

public interface StockStockDetailService {
    int deleteByPrimaryKey(Long batchStockId);

    int insert(StockStockDetail record);

    int insertSelective(StockStockDetail record);

    StockStockDetail selectByPrimaryKey(Long batchStockId);

    int updateByPrimaryKeySelective(StockStockDetail record);

    int updateByPrimaryKey(StockStockDetail record);
}
