package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.SalesOrderDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesOrderDetailMapper {
    int deleteByPrimaryKey(Long salesOrderDetail);

    int insert(SalesOrderDetail record);

    int insertSelective(SalesOrderDetail record);

    SalesOrderDetail selectByPrimaryKey(Long salesOrderDetail);

    int updateByPrimaryKeySelective(SalesOrderDetail record);

    int updateByPrimaryKey(SalesOrderDetail record);

    List<SalesOrderDetail> selectByInvoiceCode(String invoiceCode);
}