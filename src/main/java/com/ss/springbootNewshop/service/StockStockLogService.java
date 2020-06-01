package com.ss.springbootNewshop.service;

import com.ss.springbootNewshop.bean.StockStockLog;

public interface StockStockLogService {
    int deleteByPrimaryKey(Long stockLogId);

    int insert(StockStockLog record);

    int insertSelective(StockStockLog record);

    StockStockLog selectByPrimaryKey(Long stockLogId);

    int updateByPrimaryKeySelective(StockStockLog record);

    int updateByPrimaryKey(StockStockLog record);
}
