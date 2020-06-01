package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.Sku;
import org.springframework.stereotype.Repository;

@Repository
public interface SkuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sku record);

    int insertSelective(Sku record);

    Sku selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sku record);

    int updateByPrimaryKey(Sku record);
}