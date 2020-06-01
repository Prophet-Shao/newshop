package com.ss.springbootNewshop.service.impl;

import com.ss.springbootNewshop.bean.StockIn;
import com.ss.springbootNewshop.mapper.StockInMapper;
import com.ss.springbootNewshop.service.StockInService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: StockInServiceImpl
 * @User: 邵帅
 * @Date: 2020/2/2223:39
 * Version 1.0
 * Description: TODO
 **/

@Service
public class StockInServiceImpl implements StockInService {
    private static final Logger logger = LoggerFactory.getLogger(StockInServiceImpl.class);

    @Autowired
    private StockInMapper stockInMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long stockInoutId) {
        return stockInMapper.deleteByPrimaryKey(stockInoutId);
    }

    @Transactional
    @Override
    public int deleteByInvoiceCode(String invoiceCode) {
        return stockInMapper.deleteByInvoiceCode(invoiceCode);
    }

    @Transactional
    @Override
    public int insert(StockIn record) {
        return stockInMapper.insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(StockIn record) {
        return stockInMapper.insertSelective(record);
    }

    @Override
    public StockIn selectByPrimaryKey(Long stockInoutId) {
        return stockInMapper.selectByPrimaryKey(stockInoutId);
    }

    @Override
    public StockIn selectByInvoiceCode(String invoiceCode) throws Exception {
        StockIn stockIn = new StockIn();
        try {
            stockIn =stockInMapper.selectByInvoiceCode(invoiceCode);
            fiilRelationFields(stockIn);
        }catch (Exception e){
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
        return stockIn;
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(StockIn record) {
        return stockInMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(StockIn record) {
        return stockInMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<StockIn> queryStockInList() throws Exception {
        List<StockIn> StockInList = new ArrayList<StockIn>();
        try {
            StockInList = stockInMapper.queryStockInList();
            for(int i = 0; i <StockInList.size(); i++){
                fiilRelationFields(StockInList.get(i));
            }
        } catch (Exception e){
            e.printStackTrace();
            logger.warn(e.getMessage());
        }

        return StockInList;
    }

    @Override
    public List<StockIn> selectByStockIn(StockIn stockIn) throws Exception {
        List<StockIn> StockInList = new ArrayList<StockIn>();
        try {
            StockInList = stockInMapper.selectByStockIn(stockIn);
            for(int i = 0; i <StockInList.size(); i++){
                fiilRelationFields(StockInList.get(i));
            }
        } catch (Exception e){
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
        return StockInList;

    }

    //扩展属性方法
    public void fiilRelationFields(StockIn target) throws Exception{
        try {
            if (target.getProcessStatus() != null){
                if (target.getProcessStatus().equals("0")){
                    target.setProcessStatusName("未入库");
                } else if (target.getProcessStatus().equals("1")){
                    target.setProcessStatusName("已入库");
                } else if (target.getProcessStatus().equals("5")){
                    target.setProcessStatusName("已删除");
                }else {
                    target.setProcessStatusName("状态异常");
                }
            }
            if (null != target.getMoveTypeId()){
                if (target.getMoveTypeId() == 5){
                    target.setMoveTypeName("采购入库");
                } else if (target.getMoveTypeId() == 6){
                    target.setMoveTypeName("余料入库");
                } else if (target.getMoveTypeId() ==7 ){
                    target.setMoveTypeName("调货入库");
                }

            }
        } catch (Exception e){
            e.printStackTrace();
            logger.warn("入库扩展属性错误"+e.getMessage());
        }
    }
}
