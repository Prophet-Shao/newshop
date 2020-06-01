package com.ss.springbootNewshop.service;

import com.ss.springbootNewshop.bean.StockOutDetail;

import java.util.List;

/**
 * @ClassName: StockOutDetialService
 * @User: 邵帅
 * @Date: 2020/2/2212:48
 * Version 1.0
 * Description: TODO
 **/
public interface StockOutDetialService {
    int deleteByPrimaryKey(Long returnStocksDetailCode);

    int insert(StockOutDetail record);

    int insertSelective(StockOutDetail record);

    StockOutDetail selectByPrimaryKey(Long returnStocksDetailCode);

    int updateByPrimaryKeySelective(StockOutDetail record);

    int updateByPrimaryKey(StockOutDetail record);

    List<StockOutDetail> selectByInvoiceCode(String invoiceCode) throws Exception;
}
