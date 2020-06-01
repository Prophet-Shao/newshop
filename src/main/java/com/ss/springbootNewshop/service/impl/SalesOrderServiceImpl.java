package com.ss.springbootNewshop.service.impl;

import com.ss.springbootNewshop.bean.SalesOrder;
import com.ss.springbootNewshop.bean.UserOrderInfo;
import com.ss.springbootNewshop.bean.crmUser;
import com.ss.springbootNewshop.mapper.SalesOrderMapper;
import com.ss.springbootNewshop.service.SalesOrderService;
import com.ss.springbootNewshop.service.crmUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SalesOrderServiceImpl
 * @User: 邵帅
 * @Date: 2020/3/1514:08
 * Version 1.0
 * Description: TODO
 **/
@Service
public class SalesOrderServiceImpl implements SalesOrderService {
    private final static Logger logger = LoggerFactory.getLogger(SalesOrderServiceImpl.class);

    @Autowired
    private SalesOrderMapper salesOrderMapper;

    @Autowired
    private crmUserService crmUserService;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long salesOrderId) {
        return salesOrderMapper.deleteByPrimaryKey(salesOrderId);
    }

    @Transactional
    @Override
    public int insert(SalesOrder record) {
        return salesOrderMapper.insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(SalesOrder record) {
        return salesOrderMapper.insertSelective(record);
    }

    @Override
    public SalesOrder selectByPrimaryKey(Long salesOrderId) {
        return salesOrderMapper.selectByPrimaryKey(salesOrderId);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(SalesOrder record) {
        return salesOrderMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(SalesOrder record) {
        return salesOrderMapper.updateByPrimaryKey(record);
    }

    @Transactional
    @Override
    public int updateByInvoiceCode(SalesOrder salesOrder) {
        return salesOrderMapper.updateByInvoiceCode(salesOrder);
    }

    @Override
    public SalesOrder selectByInvoiceCode(String InvoiceCode) {
        return salesOrderMapper.selectByInvoiceCode(InvoiceCode);
    }

    @Override
    public List<SalesOrder> querySalesOrder() throws Exception{
        List<SalesOrder> salesOrderList = new ArrayList<>();
        try {
            salesOrderList = salesOrderMapper.querySalesOrder();
            if (salesOrderList.size()>0){
                for (int i = 0; i< salesOrderList.size(); i++){
                    fiilRelationFields(salesOrderList.get(i));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
        return salesOrderList;
    }

    @Override
    public List<SalesOrder> selectBySalesOrder(SalesOrder salesOrder) throws Exception{
        List<SalesOrder> salesOrderList = new ArrayList<>();
        try {
            salesOrderList = salesOrderMapper.selectBySalesOrder(salesOrder);
            if (salesOrderList.size()>0){
                for (int i = 0; i< salesOrderList.size(); i++){
                    fiilRelationFields(salesOrderList.get(i));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
        return salesOrderList;
    }

    @Override
    public List<SalesOrder> selectBySalesOrderBack(SalesOrder salesOrder) throws Exception {
        List<SalesOrder> salesOrderList = new ArrayList<>();
        try {
            salesOrderList = salesOrderMapper.selectBySalesOrderBack(salesOrder);
            if (salesOrderList.size()>0){
                for (int i = 0; i< salesOrderList.size(); i++){
                    fiilRelationFields(salesOrderList.get(i));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
        return salesOrderList;
    }

    @Override
    public int deleteByInvoiceCode(String InvoiceCode) {
        return salesOrderMapper.deleteByInvoiceCode(InvoiceCode);
    }

    /**
     * 修改用户积分
     * @param salesOrder
     */
    @Transactional
    @Override
    public void changeUserPoint(SalesOrder salesOrder)throws Exception {
        try {
            if (salesOrder.getProcessStatus() == "1" && salesOrder.getIsFullPaid() == 0){
                crmUser crmUser = new crmUser();
                crmUser = crmUserService.selectCrmUserById(salesOrder.getCreatedBy());
                crmUser.setUserPoint(
                        new BigDecimal(crmUser.getUserPoint())
                        .add(salesOrder.getTotalMoney())
                                .setScale(2,BigDecimal.ROUND_HALF_UP).toString());
                logger.info("当前用户为: "+crmUser.getUserName()+" 当前用户积分为: " +crmUser.getUserPoint());
            }
        } catch (Exception e){
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
    }

    @Override
    public UserOrderInfo selectUserOrderInfo(Long userId) {
        return salesOrderMapper.selectUserOrderInfo(userId);
    }

    //扩展属性方法
    public void fiilRelationFields(SalesOrder target) throws Exception{
        try {
            if (target.getProcessStatus() != null){
                if (target.getProcessStatus().equals("0")){
                    target.setProcessStatusName("未支付");
                } else if (target.getProcessStatus().equals("1")){
                    target.setProcessStatusName("已支付");
                } else if (target.getProcessStatus().equals("2")){
                    target.setProcessStatusName("已完成");
                } else if (target.getProcessStatus().equals("3")){
                    target.setProcessStatusName("订单失败");
                } else if (target.getProcessStatus().equals("4")){
                    target.setProcessStatusName("订单取消");
                } else if (target.getProcessStatus().equals("5")){
                    target.setProcessStatusName("已删除");
                } else if (target.getProcessStatus().equals("6")){
                    target.setProcessStatusName("已配送");
                }
                else {
                    target.setProcessStatusName("状态异常");
                }
            }

            if (target.getIsFullPaid() != null) {
                if (target.getIsFullPaid() == 1) {
                    target.setIsFullPaidName("已完结");
                } else if (target.getIsFullPaid() == 0) {
                    target.setIsFullPaidName("未完结");
                }
            }

            if (target.getPayCode() != null) {
                if (target.getPayCode() == 2) {
                    target.setPayCodeName("支付宝");
                } else if (target.getPayCode() == 3) {
                    target.setPayCodeName("微信支付");
                } else if (target.getPayCode() == 4) {
                    target.setPayCodeName("现金支付");
                } else if (target.getPayCode() == 5) {
                    target.setPayCodeName("第三方渠道");
                } else if (target.getPayCode() == 9) {
                    target.setPayCodeName("美团支付");
                } else if (target.getPayCode() == 11) {
                    target.setPayCodeName("积分支付");
                }
            }

        } catch (Exception e){
            e.printStackTrace();
            logger.warn("订单扩展属性错误"+e.getMessage());
        }
    }
}
