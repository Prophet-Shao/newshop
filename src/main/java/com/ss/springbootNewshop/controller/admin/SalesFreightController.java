package com.ss.springbootNewshop.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.ss.springbootNewshop.Consts.Consts;
import com.ss.springbootNewshop.bean.SalesFreight;
import com.ss.springbootNewshop.bean.SalesFreightCompany;
import com.ss.springbootNewshop.bean.SalesOrder;
import com.ss.springbootNewshop.bean.crmUser;
import com.ss.springbootNewshop.service.SalesFreightCompanyService;
import com.ss.springbootNewshop.service.SalesFreightService;
import com.ss.springbootNewshop.service.SalesOrderService;
import com.ss.springbootNewshop.service.crmUserService;
import org.apache.naming.factory.ResourceLinkFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: SalesFreightController
 * @User: 邵帅
 * @Date: 2020/2/422:30
 * Version 1.0
 * Description: TODO
 **/
@RestController
public class SalesFreightController {

    private static final Logger logger = LoggerFactory.getLogger(SalesFreightController.class);

    @Autowired
    private SalesFreightService salesFreightService;

    @Autowired
    private SalesOrderService salesOrderService;

    @Autowired
    private SalesFreightCompanyService salesFreightCompanyService;

    @Autowired
    private crmUserService crmUserService;


    /**
     * 进入配送员管理配置页面
     * @return
     */
    @RequestMapping("/salesFreight/Index")
    public ModelAndView getUserInfoIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("SalesFreight");
        return modelAndView;
    }

    /**
     * 获取所有数据
     * @param message
     * @return
     */
    @PostMapping(value = "/salesFreight/loadFreight")
    public JSONObject getSalesFreightList(@RequestParam Map<String,String> message){
        String isFreight = message.get("isFreight");
        JSONObject result = new JSONObject();
        result.put("success",false);
        try {
            if (isFreight.equals("isFreight")){
                //查询所有支付类型数据
                List<SalesFreight>  salesFreightList= salesFreightService.querySalesFreight();
                result.put("success",true);
                result.put("data",salesFreightList);
            }else {
                result.put("data","{[]}");
                result.put("success",false);
                result.put("error","查询配送单数据失败");
            }
        }catch (Exception e){
            logger.warn("查找配送单数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新单个数据
     * @return
     */
    @PostMapping(value = "/salesFreight/updateFreight")
    public JSONObject updateFreightInfo(SalesFreight salesFreight){
        JSONObject result = new JSONObject();
        result.put("success",false);
        int updateFlag = 0 ;
        try {
            if (null != salesFreight && null!= salesFreight.getSalesFreightId()){
                updateFlag = salesFreightService.updateByPrimaryKeySelective(salesFreight);
                if (updateFlag == 1){
                    result.put("success",true);
                    SalesFreight newFreight = new SalesFreight();
                    newFreight = salesFreightService.selectByPrimaryKey(salesFreight.getSalesFreightId());
                    result.put("data",newFreight);
                    logger.info("更新配送单信息成功, 配送单信息:" + salesFreight.getSalesFreightId());
                }
            }else {
                result.put("error","配送单信息缺失 更新配送单信息失败");
            }
        } catch (Exception e){
            logger.warn("更新配送单数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 插入单个数据
     * 新增配送单  配送单可由管理员根据销售订单添加
     * 也可根据用户下单时 分配最近的配送员进行配送
     * 配送状态 0 未配送 1 配送中 2 配送成功 3 配送失败 4 取消配送 5 伪删除
     * @return
     */
    @PostMapping(value = "/salesFreight/insertFreight")
    public JSONObject insertCompany(@RequestParam Map<String, String>  message){
        JSONObject result = new JSONObject();
        JSONObject param = new JSONObject();
        int insertFlag = -1;
        result.put("success",false);
        try {
            if (null!= message.get("isFreightInsert") && "isFreightInsert".equals(message.get("isFreightInsert"))){
                SalesFreight salesFreight = new SalesFreight();
                if(null != message.get("invoiceCode")){
                    SalesOrder salesOrder = new SalesOrder();
                    salesOrder = salesOrderService.selectByInvoiceCode(message.get("invoiceCode"));
                    crmUser crmUser = new crmUser();
                    crmUser = crmUserService.selectCrmUserById(salesOrder.getCreatedBy());
                    salesFreight.setOrderAddress(crmUser.getAddress());
                    if( null !=salesOrder.getIsFullDeliver() && 1== salesOrder.getIsFullDeliver() && null != salesFreightService.selectByInvoiceCode(message.get("invoiceCode")) ){
                          result.put("error","该订单已完成配送,无需配送第二次");
                          return  result;
                    }else if(Long.valueOf(salesOrder.getProcessStatus()) ==0 ){
                        result.put("error","该订单还未支付, 待客户支付完成再进行配送");
                        return  result;
                    }
                    else{
                        SalesFreightCompany  salesFreightCompany = new SalesFreightCompany();
                        salesFreightCompany = salesFreightCompanyService.selectByCompany(message.get("freightName"));
                        //配送员名字
                        salesFreight.setFreightName(salesFreightCompany.getFreightCompany());
                        //配送员ID
                        salesFreight.setFreightId(salesFreightCompany.getFreightId());
                        //电话
                        salesFreight.setFreightNumber(Long.valueOf(salesFreightCompany.getFreightPhone()));
                        //设置配送员需要配送的客户
                        salesFreight.setContactId(salesOrder.getCreatedBy());
                        //设置 关联订单Code
                        salesFreight.setSalesOrderCode(salesOrder.getInvoiceCode());
                        //设置配送状态为  未配送
                        salesFreight.setFreightState("0");

                        insertFlag = salesFreightService.insert(salesFreight);


                        //设置订单状态为完成
                        salesOrder.setProcessStatus(Consts.CompleteNum.toString());
                        //设置订单配送员ID
                        salesOrder.setIsFullDeliverName(Math.toIntExact(salesFreightCompany.getFreightId()));
                        salesOrderService.updateByPrimaryKeySelective(salesOrder);
                        result.put("salesOrder",salesOrder);
                    }

                }else {
                    salesFreight.setFreightName(message.get("freightName"));
                    salesFreight.setFreightId(Long.valueOf(message.get("freightId")) );
                    salesFreight.setFreightNumber(Long.valueOf(message.get("Phone")));
                    salesFreight.setContactId(Long.valueOf(message.get("contactId")) );
                    salesFreight.setSalesOrderCode(message.get("salesOrderCode"));
                    salesFreight.setFreightState("0");
                    insertFlag = salesFreightService.insert(salesFreight);
                }

                result.put("data",insertFlag);
                if (insertFlag == 1 ){
                    result.put("success",true);
                    result.put("salesFreight",salesFreight);
                }else {
                    result.put("error", "新增配送单失败");
                }
            }
        } catch (Exception e){
            logger.warn("新增配送单数据出错");
            e.printStackTrace();
            result.put("error", "新增配送单数据出错");
            return  result;
        }
        return result;
    }

    /**
     * 查找单个数据
     * 传入ID payCode
     * 传入支付类型名称
     * @return JSONObject
     */
    @PostMapping(value = "/salesFreight/selectFreightName")
    public JSONObject selectByCompanyName(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        String freightName = "";
        try {
            freightName = message.get("freightName");
            freightName = "华软小哥";
            result.put("data",salesFreightService.selectByFreightName(freightName));
            //result.put("data",crmUserService.selectCrmUserById((long) 4));
            logger.warn("查找单个配送单数数据成功");
        } catch (Exception e){
            logger.warn("查找单个配送单数数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除单个支付类型
     * 传入ID userName
     * @return JSONObject
     */
    @PostMapping(value = "/salesFreight/deleteFreight")
    public JSONObject deleteUser(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        String isDeleteFreight = message.get("isDeleteFreight");
        long freightId = Long.valueOf(message.get("freightId"));
        int deleteFlag = 0;
        result.put("success",false);
        try {
            if(null!=message && "isDeleteFreight".equals(isDeleteFreight)){
                //deleteFlag =salesFreightService.deleteByPrimaryKey(freightId);
                //伪删除处理
                SalesFreight salesFreight = new SalesFreight();
                    salesFreight = salesFreightService.selectByPrimaryKey(freightId);
                    salesFreight.setFreightState("5");          //状态5 伪删除
                    deleteFlag =salesFreightService.updateByPrimaryKey(salesFreight);
                if (deleteFlag == 1 ){
                    result.put("success",true);
                    result.put("data",salesFreightService.selectByPrimaryKey(freightId));
                    logger.info("删除单个配送单数据成功");
                }else {
                    result.put("error","删除配送单数失败");
                }
                result.put("data",deleteFlag);
            } else {
                result.put("error","传入配送单数数据无效请检查");
                logger.warn("传入配送单数据无效请检查, 删除失败");
            }

        } catch (Exception e){
            logger.warn("删除单个配送员数数据出错");
            e.printStackTrace();
        }
        return result;
    }
}
