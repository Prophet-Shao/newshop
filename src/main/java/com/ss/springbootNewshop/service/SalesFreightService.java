package com.ss.springbootNewshop.service;

import com.ss.springbootNewshop.bean.SalesFreight;

import java.util.List;

public interface SalesFreightService {

    int deleteByPrimaryKey(Long salesFreightId);

    int insert(SalesFreight record);

    int insertSelective(SalesFreight record);

    SalesFreight selectByPrimaryKey(Long salesFreightId);

    SalesFreight selectByFreightName(String freightName);

    SalesFreight selectByInvoiceCode(String invoiceCode) throws Exception;

    public List<SalesFreight> querySalesFreight() throws Exception;

    int updateByPrimaryKeySelective(SalesFreight record);

    int updateByPrimaryKey(SalesFreight record);
}
