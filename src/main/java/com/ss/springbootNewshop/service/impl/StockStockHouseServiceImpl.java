package com.ss.springbootNewshop.service.impl;

import com.ss.springbootNewshop.bean.StockStockHouse;
import com.ss.springbootNewshop.mapper.StockStockHouseMapper;
import com.ss.springbootNewshop.service.StockStockHouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: StockStockHouseServiceImpl
 * @User: 邵帅
 * @Date: 2020/2/230:20
 * Version 1.0
 * Description: TODO
 **/
@Service
public class StockStockHouseServiceImpl implements StockStockHouseService {

    private static final Logger logger = LoggerFactory.getLogger(StockStockHouseServiceImpl.class);

    @Autowired
    private StockStockHouseMapper stockStockHouseMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long stockhouseId) {
        return stockStockHouseMapper.deleteByPrimaryKey(stockhouseId);
    }

    @Transactional
    @Override
    public int insert(StockStockHouse record) {
        return stockStockHouseMapper.insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(StockStockHouse record) {
        return stockStockHouseMapper.insertSelective(record);
    }

    @Override
    public StockStockHouse selectByPrimaryKey(Long stockhouseId) {
        return stockStockHouseMapper.selectByPrimaryKey(stockhouseId);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(StockStockHouse record) {
        return stockStockHouseMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(StockStockHouse record) {
        return stockStockHouseMapper.updateByPrimaryKey(record);
    }
}
