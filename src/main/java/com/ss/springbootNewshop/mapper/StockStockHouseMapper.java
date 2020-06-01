package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.StockStockHouse;
import org.springframework.stereotype.Repository;

@Repository
public interface StockStockHouseMapper {
    int deleteByPrimaryKey(Long stockhouseId);

    int insert(StockStockHouse record);

    int insertSelective(StockStockHouse record);

    StockStockHouse selectByPrimaryKey(Long stockhouseId);

    int updateByPrimaryKeySelective(StockStockHouse record);

    int updateByPrimaryKey(StockStockHouse record);
}