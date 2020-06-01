package com.ss.springbootNewshop.service;

import com.ss.springbootNewshop.bean.StockIn;

import java.util.List;

public interface StockInService {
    int deleteByPrimaryKey(Long stockInoutId);

    int deleteByInvoiceCode(String invoiceCode);

    int insert(StockIn record);

    int insertSelective(StockIn record);

    StockIn selectByPrimaryKey(Long stockInoutId);

    StockIn selectByInvoiceCode(String invoiceCode) throws Exception;

    int updateByPrimaryKeySelective(StockIn record);

    int updateByPrimaryKey(StockIn record);

    List<StockIn> queryStockInList() throws Exception;

    List<StockIn> selectByStockIn(StockIn stockIn) throws Exception;
}
