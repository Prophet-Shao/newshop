package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.StockStockDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface StockStockDetailMapper {
    int deleteByPrimaryKey(Long batchStockId);

    int insert(StockStockDetail record);

    int insertSelective(StockStockDetail record);

    StockStockDetail selectByPrimaryKey(Long batchStockId);

    int updateByPrimaryKeySelective(StockStockDetail record);

    int updateByPrimaryKey(StockStockDetail record);
}