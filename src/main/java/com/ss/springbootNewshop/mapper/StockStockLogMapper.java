package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.StockStockLog;
import org.springframework.stereotype.Repository;

@Repository
public interface StockStockLogMapper {
    int deleteByPrimaryKey(Long stockLogId);

    int insert(StockStockLog record);

    int insertSelective(StockStockLog record);

    StockStockLog selectByPrimaryKey(Long stockLogId);

    int updateByPrimaryKeySelective(StockStockLog record);

    int updateByPrimaryKey(StockStockLog record);
}