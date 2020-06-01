package com.ss.springbootNewshop.mapper;


import com.ss.springbootNewshop.bean.CrmPayType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrmPayTypeMapper {
    int deleteByPrimaryKey(Long payCode);

    int insert(CrmPayType record);

    int insertSelective(CrmPayType record);

    CrmPayType selectByPrimaryKey(Long payCode);

    CrmPayType selectByName(String payName);

    int updateByPrimaryKeySelective(CrmPayType record);

    int updateByPrimaryKey(CrmPayType record);

    List<CrmPayType> queryPayTypeInfo();
}