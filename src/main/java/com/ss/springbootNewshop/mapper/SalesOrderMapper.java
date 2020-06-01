package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.SalesOrder;
import com.ss.springbootNewshop.bean.UserOrderInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesOrderMapper {
    int deleteByPrimaryKey(Long salesOrderId);

    int insert(SalesOrder record);

    int insertSelective(SalesOrder record);

    SalesOrder selectByPrimaryKey(Long salesOrderId);

    int updateByPrimaryKeySelective(SalesOrder record);

    int updateByPrimaryKey(SalesOrder record);

    int updateByInvoiceCode(SalesOrder salesOrder);

    SalesOrder selectByInvoiceCode (String InvoiceCode);

    List<SalesOrder> querySalesOrder();

    List<SalesOrder> selectBySalesOrder(SalesOrder salesOrder);

    List<SalesOrder> selectBySalesOrderBack(SalesOrder salesOrder);

    int deleteByInvoiceCode(String InvoiceCode);

    UserOrderInfo selectUserOrderInfo(Long userId);
}