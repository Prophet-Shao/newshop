package com.ss.springbootNewshop.service.impl;

import com.ss.springbootNewshop.bean.StockStockDetail;
import com.ss.springbootNewshop.mapper.StockStockDetailMapper;
import com.ss.springbootNewshop.service.StockStockDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: StockStockDetailServiceImpl
 * @User: 邵帅
 * @Date: 2020/2/230:12
 * Version 1.0
 * Description: TODO
 **/

@Service
public class StockStockDetailServiceImpl implements StockStockDetailService {

    private static final Logger logger = LoggerFactory.getLogger(StockStockDetailServiceImpl.class);

    @Autowired
    private StockStockDetailMapper stockStockDetailMapper;

    @Override
    public int deleteByPrimaryKey(Long batchStockId) {
        return stockStockDetailMapper.deleteByPrimaryKey(batchStockId);
    }

    @Override
    public int insert(StockStockDetail record) {
        return stockStockDetailMapper.insert(record);
    }

    @Override
    public int insertSelective(StockStockDetail record) {
        return stockStockDetailMapper.insertSelective(record);
    }

    @Override
    public StockStockDetail selectByPrimaryKey(Long batchStockId) {
        return stockStockDetailMapper.selectByPrimaryKey(batchStockId);
    }

    @Override
    public int updateByPrimaryKeySelective(StockStockDetail record) {
        return stockStockDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(StockStockDetail record) {
        return stockStockDetailMapper.updateByPrimaryKey(record);
    }
}
