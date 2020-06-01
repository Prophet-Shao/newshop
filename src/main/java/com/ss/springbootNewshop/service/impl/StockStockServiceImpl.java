package com.ss.springbootNewshop.service.impl;

import com.ss.springbootNewshop.bean.StockStock;
import com.ss.springbootNewshop.mapper.StockStockMapper;
import com.ss.springbootNewshop.service.StockStockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: StockStockServiceImpl
 * @User: 邵帅
 * @Date: 2020/2/230:08
 * Version 1.0
 * Description: TODO
 **/

@Service
public class StockStockServiceImpl implements StockStockService {

    private static final Logger logger = LoggerFactory.getLogger(StockStockServiceImpl.class);

    @Autowired
    private StockStockMapper stockStockMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long stockId) {
        return stockStockMapper.deleteByPrimaryKey(stockId);
    }

    @Transactional
    @Override
    public int insert(StockStock record) {
        return stockStockMapper.insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(StockStock record) {
        return stockStockMapper.insertSelective(record);
    }

    @Override
    public StockStock selectByPrimaryKey(Long stockId) {
        return stockStockMapper.selectByPrimaryKey(stockId);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(StockStock record) {
        return stockStockMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(StockStock record) {
        return stockStockMapper.updateByPrimaryKey(record);
    }
}
