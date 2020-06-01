package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.SalesReturnsDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesReturnsDetailMapper {
    int deleteByPrimaryKey(Long returnsDetailId);

    int insert(SalesReturnsDetail record);

    int insertSelective(SalesReturnsDetail record);

    SalesReturnsDetail selectByPrimaryKey(Long returnsDetailId);

    int updateByPrimaryKeySelective(SalesReturnsDetail record);

    int updateByPrimaryKey(SalesReturnsDetail record);
}