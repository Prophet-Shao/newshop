package com.ss.springbootNewshop.service;

import com.ss.springbootNewshop.bean.SalesOrderDetail;

import java.util.List;

public interface SalesOrderDetailService {

    int deleteByPrimaryKey(Long salesOrderDetail);

    int insert(SalesOrderDetail record);

    int insertSelective(SalesOrderDetail record);

    SalesOrderDetail selectByPrimaryKey(Long salesOrderDetail);

    int updateByPrimaryKeySelective(SalesOrderDetail record);

    int updateByPrimaryKey(SalesOrderDetail record);

    List<SalesOrderDetail> selectByInvoiceCode(String invoiceCode);
}
