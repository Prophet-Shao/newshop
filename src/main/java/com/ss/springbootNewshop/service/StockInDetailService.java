package com.ss.springbootNewshop.service;

import com.ss.springbootNewshop.bean.StockInDetail;

import java.util.List;

public interface StockInDetailService {

    int deleteByPrimaryKey(Long returnStocksDetailCode);

    int insert(StockInDetail record);

    int insertSelective(StockInDetail record);

    StockInDetail selectByPrimaryKey(Long returnStocksDetailCode);

    int updateByPrimaryKeySelective(StockInDetail record);

    int updateByPrimaryKey(StockInDetail record);

    List<StockInDetail> selectByInvoiceCode(String invoiceCode) throws Exception;
}
