package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.SalesReturns;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesReturnsMapper {
    int deleteByPrimaryKey(Long salesReturnsId);

    int insert(SalesReturns record);

    int insertSelective(SalesReturns record);

    SalesReturns selectByPrimaryKey(Long salesReturnsId);

    int updateByPrimaryKeySelective(SalesReturns record);

    int updateByPrimaryKey(SalesReturns record);
}