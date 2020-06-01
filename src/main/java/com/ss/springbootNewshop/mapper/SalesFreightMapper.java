package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.SalesFreight;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesFreightMapper {
    int deleteByPrimaryKey(Long salesFreightId);

    int insert(SalesFreight record);

    int insertSelective(SalesFreight record);

    SalesFreight selectByPrimaryKey(Long salesFreightId);

    SalesFreight selectByFreightName(String freightName);

    SalesFreight selectByInvoiceCode(String invoiceCode);

    public List<SalesFreight> querySalesFreight();

    int updateByPrimaryKeySelective(SalesFreight record);

    int updateByPrimaryKey(SalesFreight record);
}