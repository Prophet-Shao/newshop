package com.ss.springbootNewshop.service;

import com.ss.springbootNewshop.bean.SalesFreightCompany;

import java.util.List;

public interface SalesFreightCompanyService {
    int deleteByPrimaryKey(Long freightId);

    int insert(SalesFreightCompany record);

    int insertSelective(SalesFreightCompany record);

    SalesFreightCompany selectByPrimaryKey(Long freightId);

    SalesFreightCompany selectByCompany(String freightCompany);

    public List<SalesFreightCompany> querySalesFreightCompany();

    int updateByPrimaryKeySelective(SalesFreightCompany record);

    int updateByPrimaryKey(SalesFreightCompany record);
}
