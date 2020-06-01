package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.StockOut;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockOutMapper {
    int deleteByPrimaryKey(Long stockInoutId);

    int insert(StockOut record);

    int insertSelective(StockOut record);

    StockOut selectByPrimaryKey(Long stockInoutId);

    StockOut selectByInvoiceCode(String invoiceCode);

    int updateByPrimaryKeySelective(StockOut record);

    int updateByPrimaryKey(StockOut record);

    List<StockOut> queryStockOutList();

    List<StockOut> selectByStockOut(StockOut stockOut);
}