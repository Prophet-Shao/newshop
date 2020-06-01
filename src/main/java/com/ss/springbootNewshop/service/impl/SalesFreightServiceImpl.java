package com.ss.springbootNewshop.service.impl;

import com.ss.springbootNewshop.bean.SalesFreight;
import com.ss.springbootNewshop.controller.admin.SalesFreightController;
import com.ss.springbootNewshop.mapper.SalesFreightMapper;
import com.ss.springbootNewshop.service.SalesFreightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SalesFreightServiceImpl
 * @User: 邵帅
 * @Date: 2020/2/422:11
 * Version 1.0
 * Description: TODO
 **/
@Service
public class SalesFreightServiceImpl implements SalesFreightService {

    private static final Logger logger = LoggerFactory.getLogger(SalesFreightServiceImpl.class);

    @Autowired
    private SalesFreightMapper salesFreightMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long salesFreightId) {
        return salesFreightMapper.deleteByPrimaryKey(salesFreightId);
    }

    @Transactional
    @Override
    public int insert(SalesFreight record) {
        return salesFreightMapper.insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(SalesFreight record) {
        return salesFreightMapper.insertSelective(record);
    }

    @Override
    public SalesFreight selectByPrimaryKey(Long salesFreightId) {
        return salesFreightMapper.selectByPrimaryKey(salesFreightId);
    }

    @Override
    public SalesFreight selectByFreightName(String freightName) {
        return salesFreightMapper.selectByFreightName(freightName);
    }

    @Override
    public SalesFreight selectByInvoiceCode(String invoiceCode) throws Exception{
        SalesFreight salesFreight = new SalesFreight();
        try {
            salesFreight = salesFreightMapper.selectByInvoiceCode(invoiceCode);
            if(null != salesFreight){
                fiilRelationFields(salesFreight);
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.warn("通过订单号 查找配送单出错"+ e.getMessage());
        }
        return salesFreight;
    }

    @Override
    public List<SalesFreight> querySalesFreight() throws Exception {
        List<SalesFreight> salesFreightList = new ArrayList<>();
        try {
            salesFreightList = salesFreightMapper.querySalesFreight();
            for (int i = 0 ; i <salesFreightList.size(); i++){
                fiilRelationFields(salesFreightList.get(i));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return salesFreightList;
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(SalesFreight record) {
        return salesFreightMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(SalesFreight record) {
        return salesFreightMapper.updateByPrimaryKey(record);
    }

    //扩展属性方法
    public void fiilRelationFields(SalesFreight target) throws Exception{
        try {
            if (target.getFreightState() != null){
                if (target.getFreightState().equals("0")){
                    target.setFreightStateEx("未配送");
                } else if (target.getFreightState().equals("1")){
                    target.setFreightStateEx("配送中");
                } else if (target.getFreightState().equals("2")){
                    target.setFreightStateEx("配送成功");
                }else if (target.getFreightState().equals("3")){
                    target.setFreightStateEx("配送失败");
                }else if (target.getFreightState().equals("4")){
                    target.setFreightStateEx("取消配送");
                }else if (target.getFreightState().equals("5")){
                    target.setFreightStateEx("已删除");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            logger.warn(e.getMessage());
        }

    }
}
