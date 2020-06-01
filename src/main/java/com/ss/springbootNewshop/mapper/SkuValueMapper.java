package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.SkuValue;
import org.springframework.stereotype.Repository;

@Repository
public interface SkuValueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SkuValue record);

    int insertSelective(SkuValue record);

    SkuValue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SkuValue record);

    int updateByPrimaryKey(SkuValue record);
}