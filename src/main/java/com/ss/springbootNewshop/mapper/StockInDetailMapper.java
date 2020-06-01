package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.StockInDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockInDetailMapper {
    int deleteByPrimaryKey(Long returnStocksDetailCode);

    int insert(StockInDetail record);

    int insertSelective(StockInDetail record);

    StockInDetail selectByPrimaryKey(Long returnStocksDetailCode);

    int updateByPrimaryKeySelective(StockInDetail record);

    int updateByPrimaryKey(StockInDetail record);

    List<StockInDetail> selectByInvoiceCode(String invoiceCode);
}