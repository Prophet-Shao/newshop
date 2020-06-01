package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.StockStock;
import org.springframework.stereotype.Repository;

@Repository
public interface StockStockMapper {
    int deleteByPrimaryKey(Long stockId);

    int insert(StockStock record);

    int insertSelective(StockStock record);

    StockStock selectByPrimaryKey(Long stockId);

    int updateByPrimaryKeySelective(StockStock record);

    int updateByPrimaryKey(StockStock record);
}