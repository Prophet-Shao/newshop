package com.ss.springbootNewshop.service.impl;

import com.ss.springbootNewshop.bean.SalesReturns;
import com.ss.springbootNewshop.mapper.SalesReturnsMapper;
import com.ss.springbootNewshop.service.SalesReturnsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: SalesReturnsServiceImpl
 * @User: 邵帅
 * @Date: 2020/2/2223:13
 * Version 1.0
 * Description: TODO
 **/
@Service
public class SalesReturnsServiceImpl  implements SalesReturnsService {

    private static final Logger logger = LoggerFactory.getLogger(SalesReturnsServiceImpl.class);

    @Autowired
    private SalesReturnsMapper salesReturnsMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long salesReturnsId) {
        return salesReturnsMapper.deleteByPrimaryKey(salesReturnsId);
    }

    @Transactional
    @Override
    public int insert(SalesReturns record) {
        return salesReturnsMapper.insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(SalesReturns record) {
        return salesReturnsMapper.insertSelective(record);
    }

    @Override
    public SalesReturns selectByPrimaryKey(Long salesReturnsId) {
        return salesReturnsMapper.selectByPrimaryKey(salesReturnsId);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(SalesReturns record) {
        return salesReturnsMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(SalesReturns record) {
        return salesReturnsMapper.updateByPrimaryKey(record);
    }
}
