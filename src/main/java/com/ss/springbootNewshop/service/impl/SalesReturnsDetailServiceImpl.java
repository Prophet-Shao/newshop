package com.ss.springbootNewshop.service.impl;

import com.ss.springbootNewshop.bean.SalesReturnsDetail;
import com.ss.springbootNewshop.mapper.SalesReturnsDetailMapper;
import com.ss.springbootNewshop.service.SalesReturnsDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: SalesReturnsDetailServiceImpl
 * @User: 邵帅
 * @Date: 2020/2/2223:28
 * Version 1.0
 * Description: TODO
 **/
@Service
public class SalesReturnsDetailServiceImpl implements SalesReturnsDetailService {

    private static final Logger logger = LoggerFactory.getLogger(SalesReturnsDetailServiceImpl.class);

    @Autowired
    private SalesReturnsDetailMapper salesReturnsDetailMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long returnsDetailId) {
        return salesReturnsDetailMapper.deleteByPrimaryKey(returnsDetailId);
    }

    @Transactional
    @Override
    public int insert(SalesReturnsDetail record) {
        return salesReturnsDetailMapper.insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(SalesReturnsDetail record) {
        return salesReturnsDetailMapper.insertSelective(record);
    }

    @Override
    public SalesReturnsDetail selectByPrimaryKey(Long returnsDetailId) {
        return salesReturnsDetailMapper.selectByPrimaryKey(returnsDetailId);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(SalesReturnsDetail record) {
        return salesReturnsDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(SalesReturnsDetail record) {
        return salesReturnsDetailMapper.updateByPrimaryKey(record);
    }
}
