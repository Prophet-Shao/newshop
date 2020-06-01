package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.Value;
import org.springframework.stereotype.Repository;

@Repository
public interface ValueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Value record);

    int insertSelective(Value record);

    Value selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Value record);

    int updateByPrimaryKey(Value record);
}