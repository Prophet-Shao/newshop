package com.ss.springbootNewshop.service.impl;

import com.ss.springbootNewshop.bean.StockIn;
import com.ss.springbootNewshop.bean.StockInDetail;
import com.ss.springbootNewshop.mapper.StockInDetailMapper;
import com.ss.springbootNewshop.service.StockInDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: StockInDetailImpl
 * @User: 邵帅
 * @Date: 2020/2/2223:45
 * Version 1.0
 * Description: TODO
 **/
@Service
public class StockInDetailServiceImpl implements StockInDetailService {

    private static final Logger logger = LoggerFactory.getLogger(StockInDetailServiceImpl.class);

    @Autowired
    private StockInDetailMapper stockInDetailMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long returnStocksDetailCode) {
        return stockInDetailMapper.deleteByPrimaryKey(returnStocksDetailCode);
    }

    @Transactional
    @Override
    public int insert(StockInDetail record) {
        return stockInDetailMapper.insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(StockInDetail record) {
        return stockInDetailMapper.insertSelective(record);
    }

    @Override
    public StockInDetail selectByPrimaryKey(Long returnStocksDetailCode) {
        return stockInDetailMapper.selectByPrimaryKey(returnStocksDetailCode);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(StockInDetail record) {
        return stockInDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(StockInDetail record) {
        return stockInDetailMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<StockInDetail> selectByInvoiceCode(String invoiceCode) throws Exception{
        List<StockInDetail> stockInDetailList = new ArrayList<StockInDetail>();
        try {
            stockInDetailList = stockInDetailMapper.selectByInvoiceCode(invoiceCode);
        } catch (Exception e){
            e.printStackTrace();
            logger.warn(e.getMessage());
            return stockInDetailList;
        }
        return stockInDetailList;
    }

    //扩展属性方法
    public void fiilRelationFields(StockInDetail target) throws Exception{
        try {

        } catch (Exception e){
            e.printStackTrace();
            logger.warn(e.getMessage());
        }

    }
}
