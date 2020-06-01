package com.ss.springbootNewshop.service;

import com.ss.springbootNewshop.bean.StockOut;

import java.util.List;

public interface StockOutService {
    int deleteByPrimaryKey(Long stockInoutId);

    int insert(StockOut record);

    int insertSelective(StockOut record);

    StockOut selectByPrimaryKey(Long stockInoutId);

    StockOut selectByInvoiceCode(String invoiceCode);

    int updateByPrimaryKeySelective(StockOut record);

    int updateByPrimaryKey(StockOut record);

    List<StockOut> queryStockOutList() throws Exception;

    List<StockOut> selectByStockOut(StockOut stockOut) throws Exception;

}
