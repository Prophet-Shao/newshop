package com.ss.springbootNewshop.service.impl;

import com.ss.springbootNewshop.bean.StockStockHouseRight;
import com.ss.springbootNewshop.mapper.StockStockHouseRightMapper;
import com.ss.springbootNewshop.service.StockStockHouseRightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: StockStockHouseRightServiceImpl
 * @User: 邵帅
 * @Date: 2020/2/230:25
 * Version 1.0
 * Description: TODO
 **/
@Service
public class StockStockHouseRightServiceImpl implements StockStockHouseRightService {

    private static final Logger logger = LoggerFactory.getLogger(StockStockHouseRightServiceImpl.class);

    @Autowired
    private StockStockHouseRightMapper stockStockHouseRightMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long stockPurviewId) {
        return stockStockHouseRightMapper.deleteByPrimaryKey(stockPurviewId);
    }

    @Transactional
    @Override
    public int insert(StockStockHouseRight record) {
        return stockStockHouseRightMapper.insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(StockStockHouseRight record) {
        return stockStockHouseRightMapper.insertSelective(record);
    }

    @Override
    public StockStockHouseRight selectByPrimaryKey(Long stockPurviewId) {
        return stockStockHouseRightMapper.selectByPrimaryKey(stockPurviewId);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(StockStockHouseRight record) {
        return stockStockHouseRightMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(StockStockHouseRight record) {
        return stockStockHouseRightMapper.updateByPrimaryKey(record);
    }
}
