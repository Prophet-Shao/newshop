package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.StockIn;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockInMapper {
    int deleteByPrimaryKey(Long stockInoutId);

    int deleteByInvoiceCode(String invoiceCode);

    int insert(StockIn record);

    int insertSelective(StockIn record);

    StockIn selectByPrimaryKey(Long stockInoutId);

    StockIn selectByInvoiceCode(String invoiceCode);

    int updateByPrimaryKeySelective(StockIn record);

    int updateByPrimaryKey(StockIn record);

    List<StockIn> queryStockInList();

    List<StockIn> selectByStockIn(StockIn stockIn);
}