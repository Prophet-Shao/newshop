package com.ss.springbootNewshop.service;

import com.ss.springbootNewshop.bean.SalesOrder;
import com.ss.springbootNewshop.bean.UserOrderInfo;

import java.util.List;

public interface SalesOrderService {
    int deleteByPrimaryKey(Long salesOrderId);

    int insert(SalesOrder record);

    int insertSelective(SalesOrder record);

    SalesOrder selectByPrimaryKey(Long salesOrderId);

    int updateByPrimaryKeySelective(SalesOrder record);

    int updateByPrimaryKey(SalesOrder record);

    int updateByInvoiceCode(SalesOrder salesOrder);

    SalesOrder selectByInvoiceCode (String InvoiceCode);

    List<SalesOrder> querySalesOrder() throws Exception;

    List<SalesOrder> selectBySalesOrder(SalesOrder salesOrder) throws Exception;

    List<SalesOrder> selectBySalesOrderBack(SalesOrder salesOrder) throws Exception;

    int deleteByInvoiceCode(String InvoiceCode);

    void changeUserPoint(SalesOrder salesOrder) throws Exception;

    UserOrderInfo selectUserOrderInfo(Long userId);
}
