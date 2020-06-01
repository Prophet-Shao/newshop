package com.ss.springbootNewshop.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.ss.springbootNewshop.Consts.Consts;
import com.ss.springbootNewshop.bean.SalesOrder;
import com.ss.springbootNewshop.bean.SalesOrderDetail;
import com.ss.springbootNewshop.bean.UserOrderInfo;
import com.ss.springbootNewshop.bean.crmUser;
import com.ss.springbootNewshop.service.EcomUserBasketService;
import com.ss.springbootNewshop.service.SalesOrderDetailService;
import com.ss.springbootNewshop.service.SalesOrderService;
import com.ss.springbootNewshop.service.crmUserService;
import com.ss.springbootNewshop.utils.ConstService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName: SalesOrderController
 * @User: 邵帅
 * @Date: 2020/3/1610:15
 * Version 1.0
 * Description: 订单
 **/
@RestController
public class SalesOrderController {
    private static final Logger logger = LoggerFactory.getLogger(SalesOrderController.class);

    @Autowired
    private crmUserService crmUserService;

    @Autowired
    private SalesOrderService salesOrderService;

    @Autowired
    private SalesOrderDetailService salesOrderDetailService;

    @Autowired
    private ConstService constService;

    @Autowired
    private EcomUserBasketService ecomUserBasketService;

    /**
     * 进入订单确认页面
     * @return
     */
    @RequestMapping("/salesOrder/SalesOrderConfirm")
    public ModelAndView SalesOrderConfirm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("SalesOrderConfirm");
        return modelAndView;
    }

    /**
     * 进入用户个人订单页面
     * @return
     */
    @RequestMapping("/userInfo/userOrderDetail")
    public ModelAndView userOrderDetail(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userOrderDetail");
        return modelAndView;
    }

    /**
     * 进入订单管理配置页面
     * @return
     */
    @RequestMapping("/salesOrder/Index")
    public ModelAndView getSalesOrderIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("SalesOrder");
        return modelAndView;
    }

    /**
     * 进入后台订单编辑配置页面
     * @return
     */
    @RequestMapping("/salesOrder/save")
    public ModelAndView getSalesOrderSaveIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("SalesOrderSave");
        return modelAndView;
    }

    /**
     * 进入后台订单编辑配置页面
     * @return
     */
    @RequestMapping("/salesOrder/SalesOrderPay")
    public ModelAndView getSalesOrderPay(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("SalesOrderPay");
        return modelAndView;
    }

    /**
     * 获取所有数据
     * @param message
     * @return
     */
    @PostMapping(value = "/salesOrder/loadSalesOrder")
    public JSONObject getSalesOrderList(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        result.put("success",false);
        try {
            if (null!= message.get("isSalesOrder") && message.get("isSalesOrder").equals("isSalesOrder")){
                //查询所有订单数据
                List<SalesOrder> salesOrderList = salesOrderService.querySalesOrder();
                result.put("success",true);
                result.put("data",salesOrderList);
            }else {
                result.put("data","{[]}");
                result.put("success",false);
                result.put("error","查询订单数据失败");
            }
        }catch (Exception e){
            logger.warn("查找订单数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新单个数据
     * @return
     */
    @PostMapping(value = "/salesOrder/updateSalesOrder")
    public JSONObject updateSalesOrderInfo(SalesOrder salesOrder, HttpServletRequest request){
        JSONObject result = new JSONObject();
        result.put("success",false);
        int updateFlag = 0 ;
        try {
            //获取用户
            String userName = (String) request.getSession().getAttribute("userName");
            crmUser crmuser = crmUserService.selectByUserName(userName);
            if(null != crmuser){ request.getSession().setAttribute("userName",crmuser.getUserName()); }

            if (null != salesOrder && null!= salesOrder.getInvoiceCode()){
                salesOrder.setModifiedDate(new Date());

                if(salesOrder.getPayCode() == Long.valueOf(4)){
                    BigDecimal userPoint = new BigDecimal( crmuser.getUserPoint() ).divide(BigDecimal.valueOf(100)).setScale(2,BigDecimal.ROUND_HALF_UP);
                    BigDecimal newPoint = userPoint.subtract(salesOrder.getTotalMoney()).setScale(2,BigDecimal.ROUND_HALF_UP);
                    crmuser.setUserPoint(newPoint.multiply(BigDecimal.valueOf(100)).setScale(2,BigDecimal.ROUND_HALF_UP).toString());
                    crmUserService.updateUser(crmuser);
                }
                updateFlag = salesOrderService.updateByInvoiceCode(salesOrder);
                salesOrderService.changeUserPoint(salesOrder);          //修改用户积分
                if (updateFlag == 1){
                    result.put("success",true);
                    SalesOrder newSalesOrder= new SalesOrder();
                    newSalesOrder = salesOrderService.selectByInvoiceCode(salesOrder.getInvoiceCode());
                    result.put("data",newSalesOrder);
                    logger.info("更新订单信息成功, 订单信息:" + newSalesOrder.getInvoiceCode());
                }
            }else {
                result.put("error","订单信息缺失 更新订单信息失败");
            }
        } catch (Exception e){
            logger.warn("更新订单数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 插入单个数据
     * 新增订单 暂定只有一级分类
     * 通过InvoiceCode 和订单 关联
     * @return
     */
    @PostMapping(value = "/salesOrder/insertSalesOrder")
    @Transactional
    public JSONObject insertSalesOrder(@RequestParam Map<String, String>  message, HttpServletRequest request){
        JSONObject result = new JSONObject();
        JSONObject param = new JSONObject();
        int insertFlag = -1;
        result.put("success",false);
        List<SalesOrderDetail> detailList = new ArrayList<SalesOrderDetail>();
        try {
            String userName = (String) request.getSession().getAttribute("userName");
            crmUser crmuser = crmUserService.selectByUserName(userName);
            if(null != crmuser){ request.getSession().setAttribute("userName",crmuser.getUserName()); }
            if (null!= message.get("isSalesOrderInsert") && "isSalesOrderInsert".equals(message.get("isSalesOrderInsert")) ){
                SalesOrder salesOrder = new SalesOrder();
                salesOrder.setInvoiceCode(constService.getRandenCode(Consts.SalesOrderPrefix));
                //入库类型  写死 初始化 未支付
                salesOrder.setIsFullPaid(Integer.valueOf(Consts.StandNum.toString()));
                if (null!= message.get("stockhouseCode")){
                    salesOrder.setStockhouseCode(message.get("stockhouseCode"));
                }
                salesOrder.setCreatedDate(new Date());
                if(null != crmuser.getUserTypeId() ){
                    salesOrder.setCreatedBy(crmuser.getUserId()); //真实创建人
                    salesOrder.setModiifiedBy(crmuser.getUserId()); //真实创建人
                }else {
                    salesOrder.setCreatedBy(Long.valueOf(1)); //创建人
                    salesOrder.setModiifiedBy(Long.valueOf(1)); // 修改人
                }

                salesOrder.setModifiedDate(new Date());

                salesOrder.setShopCode("newshop");     //写死门店
                salesOrder.setPayCode(Long.valueOf(2));     //支付宝
                salesOrder.setIsFullDeliver(Math.toIntExact(Consts.StandNum)); //设置未配送
                //初始化订单 进度 未支付 0
                //判断总数量总价格
                salesOrder.setProcessStatus(Consts.StandNum.toString());
                if (null!= message.get("totalMoney") && null!= message.get("totalNumber")){
                    salesOrder.setTotalMoney(new BigDecimal(message.get("totalMoney")));
                    salesOrder.setTotalQty(new BigDecimal(message.get("totalNumber")));
                }
                if(null!= message.get("memo") ){
                    salesOrder.setMemo(message.get("memo"));
                }else {
                    salesOrder.setMemo(message.get("无"));
                }
                //判断插入是否成功
                insertFlag = salesOrderService.insert(salesOrder);
                result.put("data",insertFlag);
                if (insertFlag == 1 ){
                    SalesOrder newSalesOrder = new SalesOrder();
                    newSalesOrder = salesOrderService.selectByInvoiceCode(salesOrder.getInvoiceCode());
                    detailList = salesOrderDetailService.selectByInvoiceCode(newSalesOrder.getInvoiceCode());
                    /* 子单录入
                     * 子单校验
                     * */
                    if(detailList.size()>0){
                        for (int i = 0; i<detailList.size(); i++){
                            salesOrderDetailService.deleteByPrimaryKey(detailList.get(i).getSalesOrderDetail());
                        }
                    }
                    String gotoPayMsgList = message.get("gotoPayMsg");
                    String dataDetailList[] = gotoPayMsgList.split(";");
                    for(int i = 0; i < dataDetailList.length; i++){
                        String dataDetail[] = dataDetailList[i].split(",");
                        //删除购物车ID
                        if(Integer.valueOf(-1).equals(dataDetail[0] )){
                            logger.info("直接购物");
                        }else {
                            ecomUserBasketService.deleteByPrimaryKey(Long.valueOf(dataDetail[0]));
                        }
                        SalesOrderDetail salesOrderDetail = new SalesOrderDetail();
                        salesOrderDetail.setInvoiceCode(salesOrder.getInvoiceCode());
                        salesOrderDetail.setMemo(salesOrder.getMemo());
                        //商品Code
                        salesOrderDetail.setProductsCode(dataDetail[1]);//("#code-")
                        //商品单位
                        salesOrderDetail.setProductsModel(dataDetail[2]);//("#unit-")
                        //商品分类
                        salesOrderDetail.setCategoryId(Long.valueOf(dataDetail[3]));//("#category-")
                        //商品价格
                        salesOrderDetail.setSalesPrice(new BigDecimal(dataDetail[4]).setScale(2,BigDecimal.ROUND_HALF_UP));
                        //商品数量
                        salesOrderDetail.setQuantity(new BigDecimal(dataDetail[5]).setScale(2,BigDecimal.ROUND_HALF_UP));
                        //此子单花费
                        salesOrderDetail.setCost(salesOrderDetail.getQuantity().multiply(salesOrderDetail.getSalesPrice()).setScale(2,BigDecimal.ROUND_HALF_UP));
                        salesOrderDetailService.insert(salesOrderDetail);
                    }
                    result.put("success",true);
                    result.put("SalesOrder",newSalesOrder);//存入插入的大订单
                    result.put("invoiceCode",newSalesOrder.getInvoiceCode());
                    logger.info("新增订单数据成功"+newSalesOrder.getInvoiceCode());
                }else {
                    result.put("error", "新增主订单失败, 请重新选择购物车,并下单");
                }
            }
        } catch (Exception e){
            result.put("error", "新增订单数据出错");
            e.printStackTrace();
            logger.warn("新增订单数据出错");
            return  result;
        }
        return result;
    }


    /**
     * 查找单个数据
     * 传入ID
     * 传入订单名称
     * 返回总单  子单
     * @return JSONObject
     */
    @PostMapping(value = "/salesOrder/selectSalesOrder")
    public JSONObject selectByInvoiceCode(@RequestParam Map<String,String> message,HttpServletRequest request){
        JSONObject result = new JSONObject();
        result.put("success",false);
        result.put("data","{}");
        String invoiceCode = "";
        String processStatus = "";
        String createdDate = "";
        String modifiedDate = "";
        List<SalesOrder> salesOrderList = new ArrayList<SalesOrder>();
        List<SalesOrderDetail> salesOrderDetailList = new ArrayList<SalesOrderDetail>();
        //设置时间格式化
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
        try {
            if(null != request.getSession().getAttribute("userName")){
                crmUser crmUser = crmUserService.selectByUserName((String)request.getSession().getAttribute("userName"));
                request.getSession().setAttribute("userName",crmUser.getUserName());
                result.put("crmUser",crmUser);
            }
            SalesOrder salesOrder = new SalesOrder();
            //订单号 条件判断
            if (null!=message.get("invoiceCode") && "" != message.get("invoiceCode")){
                invoiceCode = message.get("invoiceCode");
                salesOrder.setInvoiceCode(invoiceCode);
                salesOrderDetailList = salesOrderDetailService.selectByInvoiceCode(invoiceCode);
            }
            //订单状态 条件判断
            if(null!= message.get("processStatus") && ""!= message.get("processStatus")  ){
                processStatus = message.get("processStatus");
                salesOrder.setProcessStatus(processStatus);
            }
            //起始时间 条件判断
            if(null!= message.get("createdDate") && "" != message.get("createdDate")  ){
                createdDate = message.get("createdDate");
                salesOrder.setCreatedDate(format.parse(createdDate));
            }
            //终止时间 条件判断
            if( null!=message.get("modifiedDate") && "" != message.get("modifiedDate")){
                modifiedDate = message.get("modifiedDate");
                salesOrder.setModifiedDate(format.parse(modifiedDate));
            }
            salesOrderList = salesOrderService.selectBySalesOrder(salesOrder);

            //若有子单存在 则遍历查询加入
            if (salesOrderDetailList.size()>0){
                result.put("salesOrderDetailData",salesOrderDetailList);
            }

            if(salesOrderList.size()>0){
                result.put("data",salesOrderList);
                result.put("success",true);
                logger.info("查找单个订单数数据成功");
            } else {
                logger.info("查找数据失败");
                result.put("error","查找数据失败");
            }
        } catch (Exception e){
            result.put("error","查找数据失败");
            logger.warn("查找单个订单数数据出错");
            e.printStackTrace();
            return result;
        }
        return result;
    }

    /**
     * 查找单个数据
     * 传入ID
     * 传入订单名称
     * 返回总单  子单
     * @return JSONObject
     */
    @PostMapping(value = "/salesOrder/selectSalesOrderBack")
    public JSONObject selectByInvoiceCodeBack(@RequestParam Map<String,String> message,HttpServletRequest request){
        JSONObject result = new JSONObject();
        result.put("success",false);
        result.put("data","{}");
        String invoiceCode = "";
        String processStatus = "";
        String createdDate = "";
        String modifiedDate = "";
        List<SalesOrder> salesOrderList = new ArrayList<SalesOrder>();
        List<SalesOrderDetail> salesOrderDetailList = new ArrayList<SalesOrderDetail>();
        //设置时间格式化
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
        try {
            SalesOrder salesOrder = new SalesOrder();
            //订单号 条件判断
            if (null!=message.get("invoiceCode") && "" != message.get("invoiceCode")){
                invoiceCode = message.get("invoiceCode");
                salesOrder.setInvoiceCode(invoiceCode);
            }
            //订单状态 条件判断
            if(null!= message.get("processStatus") && ""!= message.get("processStatus")  ){
                processStatus = message.get("processStatus");
                salesOrder.setProcessStatus(processStatus);
            }
            //起始时间 条件判断
            if(null!= message.get("createdDate") && "" != message.get("createdDate")  ){
                createdDate = message.get("createdDate");
                salesOrder.setCreatedDate(format.parse(createdDate));
            }
            //终止时间 条件判断
            if( null!=message.get("modifiedDate") && "" != message.get("modifiedDate")){
                modifiedDate = message.get("modifiedDate");
                salesOrder.setModifiedDate(format.parse(modifiedDate));
            }
            salesOrderList = salesOrderService.selectBySalesOrderBack(salesOrder);
            if(salesOrderList.size()>0){
                result.put("data",salesOrderList);
                result.put("success",true);
                logger.info("查找订单数数据成功");
            } else {
                logger.info("查找数据失败");
                result.put("error","查找数据失败");
            }
        } catch (Exception e){
            result.put("error","查找数据失败");
            logger.warn("查找单个订单数数据出错");
            e.printStackTrace();
            return result;
        }
        return result;
    }


    /**
     * 删除单个订单
     * 传入ID ID
     * @return JSONObject
     */
    @PostMapping(value = "/salesOrder/deleteSalesOrder")
    public JSONObject deleteSalesOrder(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        String invoiceCode ="";
        int deleteFlag = 0;
        result.put("success",false);
        try {
            //判空条件
            if(null!=message.get("isDeleteSalesOrder") && "isDeleteSalesOrder".equals(message.get("isDeleteSalesOrder"))
               && null!= message.get("invoiceCode") && ""!=message.get("invoiceCode")){
                SalesOrder salesOrder = new SalesOrder();     //查找到该订单
                invoiceCode = message.get("invoiceCode");
                salesOrder = salesOrderService.selectByInvoiceCode(invoiceCode);
                //伪删除处理
                salesOrder.setProcessStatus(String.valueOf(Consts.DeleteNum));
                deleteFlag = salesOrderService.updateByPrimaryKeySelective(salesOrder);
                if (deleteFlag == 1 ){
                    result.put("success",true);
                    logger.info("删除单个订单数据成功");
                }else {
                    result.put("error","删除订单数失败");
                }
                result.put("data",deleteFlag);
            } else {
                result.put("error","传入订单数数据无效请检查");
                logger.warn("传入订单数据无效请检查, 删除失败");
            }
        } catch (Exception e){
            logger.warn("删除单个订单数数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除单个订单
     * 传入ID ID
     * @return JSONObject
     */
    @PostMapping(value = "/salesOrder/changeUserAddress")
    public JSONObject changeUserAddress(@RequestParam Map<String,String> message,HttpServletRequest request){
        JSONObject result = new JSONObject();
        String invoiceCode ="";
        int updateFlag = 0;
        result.put("success",false);
        try {
            //判空条件
            if(null!=message.get("isChangeAddress") && "isChangeAddress".equals(message.get("isChangeAddress"))
                    && null!= message.get("invoiceCode") && ""!=message.get("invoiceCode")){
                if(null != request.getSession().getAttribute("userName")){
                    crmUser crmUser = crmUserService.selectByUserName((String)request.getSession().getAttribute("userName"));
                    request.getSession().setAttribute("userName",crmUser.getUserName());
                    crmUser.setAddress(message.get("address"));
                    crmUser.setCompany(message.get("company"));
                    crmUser.setPhone(message.get("phone"));
                    updateFlag = crmUserService.updateUser(crmUser);
                    result.put("crmUser",crmUser);
                    if (updateFlag == 1 ){
                        result.put("success",true);
                        logger.info("更新用户配送地址成功");
                    }else {
                        result.put("error","更新用户配送地址失败");
                    }
                }else {
                    result.put("error","用户未登录,请重新登录");
                }
                result.put("data",updateFlag);
            } else {
                result.put("error","非订单确认请求,请重新下单");
                logger.warn("非订单确认请求,请重新下单");
            }
        } catch (Exception e){
            logger.warn("更新用户配送地址错误请检查");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查询个人中心  用户订单数据
     * 传入ID ID
     * @return JSONObject
     */
    @PostMapping(value = "/salesOrder/loadUserOrderInfo")
    public JSONObject onUserOrderSearch(@RequestParam Map<String,String> message,HttpServletRequest request){
        JSONObject result = new JSONObject();
        result.put("success",false);
        try {
            //判空条件
            if(null!=message.get("isUserOrderSearch") && "isUserOrderSearch".equals(message.get("isUserOrderSearch"))){
                if(null != request.getSession().getAttribute("userName")){
                    crmUser crmUser = crmUserService.selectByUserName((String)request.getSession().getAttribute("userName"));
                    request.getSession().setAttribute("userName",crmUser.getUserName());
                    //UserOrderInfo  userOrderInfo = salesOrderService.selectUserOrderInfo(crmUser.getUserId());
                    UserOrderInfo  userOrderInfo = salesOrderService.selectUserOrderInfo(crmUser.getUserId());
                    result.put("crmUser",crmUser);
                    result.put("userOrderInfo",userOrderInfo);
                    if (null != userOrderInfo.getUserId()){
                        result.put("success",true);
                        logger.info("查找用户订单信息成功");
                    }else {
                        result.put("error","查找用户订单信息失败");
                    }
                }else {
                    result.put("error","用户未登录,请重新登录");
                }
            } else {
                result.put("error","非用户订单信息查询请求,请重新登录");
                logger.warn("非用户订单信息查询请求,请重新登录");
            }
        } catch (Exception e){
            result.put("error","用户订单数据查找失败");
            logger.warn("查询用户订单出错");
            e.printStackTrace();
            return result;
        }
        return result;
    }


    /**
     * 查询个人中心  点击用户订单  查询用户订单详情
     * 传入ID ID
     * @return JSONObject
     */
    @PostMapping(value = "/salesOrder/loadUserOrderDetail")
    public JSONObject onUserOrderDetailSearch(@RequestParam Map<String,String> message,HttpServletRequest request){
        JSONObject result = new JSONObject();
        result.put("success",false);
        List<SalesOrder> salesOrderList = new ArrayList<>();
        try {
            //判空条件
            if(null!=message.get("isUserOrderLoad") && "isUserOrderLoad".equals(message.get("isUserOrderLoad"))
               && null != request.getSession().getAttribute("userName")){
                crmUser crmUser = crmUserService.selectByUserName((String)request.getSession().getAttribute("userName"));
                request.getSession().setAttribute("userName",crmUser.getUserName());
                //存放用户数据
                result.put("crmUser",crmUser);
                SalesOrder salesOrder = new SalesOrder();
                salesOrder.setCreatedBy(crmUser.getUserId());
                salesOrderList = salesOrderService.selectBySalesOrder(salesOrder);
                if (salesOrderList.size()>0){
                    for (int i = 0; i<salesOrderList.size(); i++){
                        //查询对应的子单数据
                        List<SalesOrderDetail> salesOrderDetailList = new ArrayList<>();
                        salesOrderDetailList = salesOrderDetailService.selectByInvoiceCode(salesOrderList.get(i).getInvoiceCode());
                        salesOrderList.get(i).setSalesOrderDetailList(salesOrderDetailList);
                    }
                    result.put("salesOrderList",salesOrderList);
                    result.put("msg","查询用户个人订单数据成功");
                    result.put("success",true);
                    logger.info("查找"+crmUser.getUserName()+"订单详细信息成功");
                }
            } else {
                result.put("error","查询个人用户订单数据失败,请稍后重试");
                logger.warn("非用户订单信息查询请求,请重新登录");
            }
        } catch (Exception e){
            logger.warn("查询用户订单出错");
            e.printStackTrace();
        }
        return result;
    }



}
