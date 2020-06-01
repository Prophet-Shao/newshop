package com.ss.springbootNewshop.service.impl;

import com.ss.springbootNewshop.bean.StockIn;
import com.ss.springbootNewshop.bean.StockOut;
import com.ss.springbootNewshop.mapper.StockOutMapper;
import com.ss.springbootNewshop.service.StockOutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: StockOutServiceImpl
 * @User: 邵帅
 * @Date: 2020/2/2223:53
 * Version 1.0
 * Description: TODO
 **/
@Service
public class StockOutServiceImpl implements StockOutService {

    private static final Logger logger = LoggerFactory.getLogger(StockOutServiceImpl.class);

    @Autowired
    private StockOutMapper stockOutMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long stockInoutId) {
        return stockOutMapper.deleteByPrimaryKey(stockInoutId);
    }

    @Transactional
    @Override
    public int insert(StockOut record) {
        return stockOutMapper.insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(StockOut record) {
        return stockOutMapper.insertSelective(record);
    }

    @Override
    public StockOut selectByPrimaryKey(Long stockInoutId) {
        return stockOutMapper.selectByPrimaryKey(stockInoutId);
    }

    @Override
    public StockOut selectByInvoiceCode(String invoiceCode) {
        return stockOutMapper.selectByInvoiceCode(invoiceCode);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(StockOut record) {
        return stockOutMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(StockOut record) {
        return stockOutMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<StockOut> queryStockOutList() throws Exception{
        List<StockOut> stockOutList = new ArrayList<StockOut>();
        try {
            stockOutList = stockOutMapper.queryStockOutList();
            if(stockOutList.size()>0){
                for (int i = 0; i < stockOutList.size(); i++){
                    fiilRelationFields(stockOutList.get(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
        return stockOutList;
    }

    @Override
    public List<StockOut> selectByStockOut(StockOut stockOut) throws Exception{
        List<StockOut> stockOutList = new ArrayList<StockOut>();
        try {
            stockOutList = stockOutMapper.selectByStockOut(stockOut);
            if(stockOutList.size()>0){
                for (int i = 0; i < stockOutList.size(); i++){
                    fiilRelationFields(stockOutList.get(i));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
        return stockOutList;
    }

    //扩展属性方法
    public void fiilRelationFields(StockOut target) throws Exception{
        try {
            if (target.getProcessStatus() != null){
                if (target.getProcessStatus().equals("0")){
                    target.setProcessStatusName("未出库");
                } else if (target.getProcessStatus().equals("1")){
                    target.setProcessStatusName("已出库");
                } else if (target.getProcessStatus().equals("5")){
                    target.setProcessStatusName("已删除");
                }else {
                    target.setProcessStatusName("状态异常");
                }
            }
            if (null != target.getMoveTypeId()){
                if (target.getMoveTypeId() == 1){
                    target.setMoveTypeName("直接出库");
                } else if (target.getMoveTypeId() == 2){
                    target.setMoveTypeName("调货出库");
                } else {
                    target.setMoveTypeName("未知出库类型");
                }

            }
        } catch (Exception e){
            e.printStackTrace();
            logger.warn("出库扩展属性错误"+e.getMessage());
        }
    }
}
