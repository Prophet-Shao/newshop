package com.ss.springbootNewshop.service;

public interface SalesReturnsService {

    int deleteByPrimaryKey(Long salesReturnsId);

    int insert(com.ss.springbootNewshop.bean.SalesReturns record);

    int insertSelective(com.ss.springbootNewshop.bean.SalesReturns record);

    com.ss.springbootNewshop.bean.SalesReturns selectByPrimaryKey(Long salesReturnsId);

    int updateByPrimaryKeySelective(com.ss.springbootNewshop.bean.SalesReturns record);

    int updateByPrimaryKey(com.ss.springbootNewshop.bean.SalesReturns record);
}
