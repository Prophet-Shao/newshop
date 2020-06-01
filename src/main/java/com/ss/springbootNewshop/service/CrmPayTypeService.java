package com.ss.springbootNewshop.service;

import com.ss.springbootNewshop.bean.CrmPayType;

import java.util.List;

public interface CrmPayTypeService {
    int deleteByPrimaryKey(Long payCode);

    int insert(CrmPayType record);

    int insertSelective(CrmPayType record);

    CrmPayType selectByPrimaryKey(Long payCode);

    CrmPayType selectByName(String payName);

    int updateByPrimaryKeySelective(CrmPayType record);

    int updateByPrimaryKey(CrmPayType record);

    List<CrmPayType> queryPayTypeInfo();

}
