package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.Attribute;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Attribute record);

    int insertSelective(Attribute record);

    Attribute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Attribute record);

    int updateByPrimaryKey(Attribute record);
}