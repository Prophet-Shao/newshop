package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.StockStockHouseRight;
import org.springframework.stereotype.Repository;

@Repository
public interface StockStockHouseRightMapper {
    int deleteByPrimaryKey(Long stockPurviewId);

    int insert(StockStockHouseRight record);

    int insertSelective(StockStockHouseRight record);

    StockStockHouseRight selectByPrimaryKey(Long stockPurviewId);

    int updateByPrimaryKeySelective(StockStockHouseRight record);

    int updateByPrimaryKey(StockStockHouseRight record);
}