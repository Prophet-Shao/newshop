package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.StockOutDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockOutDetailMapper {
    int deleteByPrimaryKey(Long returnStocksDetailCode);

    int insert(StockOutDetail record);

    int insertSelective(StockOutDetail record);

    StockOutDetail selectByPrimaryKey(Long returnStocksDetailCode);

    int updateByPrimaryKeySelective(StockOutDetail record);

    int updateByPrimaryKey(StockOutDetail record);

    List<StockOutDetail> selectByInvoiceCode(String invoiceCode);
}