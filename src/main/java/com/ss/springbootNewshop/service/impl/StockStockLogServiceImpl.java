package com.ss.springbootNewshop.service.impl;

import com.ss.springbootNewshop.bean.StockStockLog;
import com.ss.springbootNewshop.mapper.StockStockLogMapper;
import com.ss.springbootNewshop.service.StockStockLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: StockStockLogServiceImpl
 * @User: 邵帅
 * @Date: 2020/2/230:35
 * Version 1.0
 * Description: TODO
 **/
@Service
public class StockStockLogServiceImpl implements StockStockLogService {

    private static final Logger logger = LoggerFactory.getLogger(StockStockLogServiceImpl.class);

    @Autowired
    private StockStockLogMapper stockStockLogMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long stockLogId) {
        return stockStockLogMapper.deleteByPrimaryKey(stockLogId);
    }

    @Transactional
    @Override
    public int insert(StockStockLog record) {
        return stockStockLogMapper.insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(StockStockLog record) {
        return stockStockLogMapper.insertSelective(record);
    }

    @Override
    public StockStockLog selectByPrimaryKey(Long stockLogId) {
        return stockStockLogMapper.selectByPrimaryKey(stockLogId);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(StockStockLog record) {
        return stockStockLogMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(StockStockLog record) {
        return stockStockLogMapper.updateByPrimaryKey(record);
    }
}
