package com.ss.springbootNewshop.service.impl;

import com.ss.springbootNewshop.bean.StockOutDetail;
import com.ss.springbootNewshop.mapper.StockOutDetailMapper;
import com.ss.springbootNewshop.service.StockOutDetialService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: StockOutDetailServiceImpl
 * @User: 邵帅
 * @Date: 2020/2/230:01
 * Version 1.0
 * Description: TODO
 **/
@Service
public class StockOutDetailServiceImpl implements StockOutDetialService {

    private static final Logger logger = LoggerFactory.getLogger(StockOutDetailServiceImpl.class);

    @Autowired
    private StockOutDetailMapper stockOutDetailMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long returnStocksDetailCode) {
        return stockOutDetailMapper.deleteByPrimaryKey(returnStocksDetailCode);
    }

    @Transactional
    @Override
    public int insert(StockOutDetail record) {
        return stockOutDetailMapper.insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(StockOutDetail record) {
        return stockOutDetailMapper.insertSelective(record);
    }

    @Override
    public StockOutDetail selectByPrimaryKey(Long returnStocksDetailCode) {
        return stockOutDetailMapper.selectByPrimaryKey(returnStocksDetailCode);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(StockOutDetail record) {
        return stockOutDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(StockOutDetail record) {
        return stockOutDetailMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<StockOutDetail> selectByInvoiceCode(String invoiceCode) throws Exception{
        List<StockOutDetail> stockOutDetaillist = new ArrayList<StockOutDetail>();
        try {
            stockOutDetaillist = stockOutDetailMapper.selectByInvoiceCode(invoiceCode);
        } catch (Exception e){
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
        return stockOutDetaillist;
    }

    //扩展属性方法
    public void fiilRelationFields(StockOutDetail target) throws Exception{
        try {

        } catch (Exception e){
            e.printStackTrace();
            logger.warn(e.getMessage());
        }

    }


}
