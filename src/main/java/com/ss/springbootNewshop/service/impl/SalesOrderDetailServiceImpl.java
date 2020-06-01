package com.ss.springbootNewshop.service.impl;

import com.ss.springbootNewshop.bean.SalesOrderDetail;
import com.ss.springbootNewshop.mapper.SalesOrderDetailMapper;
import com.ss.springbootNewshop.service.SalesOrderDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: SalesOrderDetailServiceImpl
 * @User: 邵帅
 * @Date: 2020/3/1712:08
 * Version 1.0
 * Description: TODO
 **/
@Service
public class SalesOrderDetailServiceImpl implements SalesOrderDetailService {

    private static final Logger logger = LoggerFactory.getLogger(SalesOrderDetailServiceImpl.class);

    @Autowired
    private SalesOrderDetailMapper salesOrderDetailMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long salesOrderDetail) {
        return salesOrderDetailMapper.deleteByPrimaryKey(salesOrderDetail);
    }

    @Transactional
    @Override
    public int insert(SalesOrderDetail record) {
        return salesOrderDetailMapper.insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(SalesOrderDetail record) {
        return salesOrderDetailMapper.insertSelective(record);
    }

    @Override
    public SalesOrderDetail selectByPrimaryKey(Long salesOrderDetail) {
        return salesOrderDetailMapper.selectByPrimaryKey(salesOrderDetail);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(SalesOrderDetail record) {
        return salesOrderDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(SalesOrderDetail record) {
        return salesOrderDetailMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SalesOrderDetail> selectByInvoiceCode(String invoiceCode) {
        return salesOrderDetailMapper.selectByInvoiceCode(invoiceCode);
    }
}
