package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.SalesFreightCompany;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesFreightCompanyMapper {
    int deleteByPrimaryKey(Long freightId);

    int insert(SalesFreightCompany record);

    int insertSelective(SalesFreightCompany record);

    SalesFreightCompany selectByPrimaryKey(Long freightId);

    SalesFreightCompany selectByCompany(String freightCompany);

    public List<SalesFreightCompany> querySalesFreightCompany();

    int updateByPrimaryKeySelective(SalesFreightCompany record);

    int updateByPrimaryKey(SalesFreightCompany record);
}