package com.ss.springbootNewshop.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.ss.springbootNewshop.Consts.Consts;
import com.ss.springbootNewshop.bean.StockIn;
import com.ss.springbootNewshop.bean.StockInDetail;
import com.ss.springbootNewshop.service.StockInDetailService;
import com.ss.springbootNewshop.service.StockInService;
import com.ss.springbootNewshop.utils.ConstService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName: StockInController
 * @User: 邵帅
 * @Date: 2020/2/230:54
 * Version 1.0
 * Description: TODO
 **/
@RestController
public class StockInController {
    private static final Logger logger = LoggerFactory.getLogger(StockInController.class);

    @Autowired
    private StockInService stockInService;

    @Autowired
    private StockInDetailService stockInDetailService;

    @Autowired
    private ConstService constService;
    /**
     * 进入入库单管理配置页面
     * @return
     */
    @RequestMapping("/stockIn/Index")
    public ModelAndView getProductsIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("StockIn");
        return modelAndView;
    }

    @RequestMapping("/stockIn/save")
    public ModelAndView getProductsSaveIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("StockInSave");
        return modelAndView;
    }


    /**
     * 加载入库单信息
     * @param isStockIn
     * @return
     */
    @GetMapping(value = "/stockIn/loadStockIn",produces = "application/json;charset=UTF-8")
    public String getProductsList(String isStockIn){
        JSONObject result = new JSONObject();
        result.put("success",false);
        result.put("data","");
        try {
            if (null!=isStockIn && isStockIn.equals("isStockIn")){
                List<StockIn> StockInList = stockInService.queryStockInList();
                result.put("success",true);
                result.put("data",StockInList);
                logger.info("加载入库单数据成功");
            }else {
                result.put("success",false);
                result.put("error","加载所有入库单信息出错");
            }

        }catch (Exception e){
            logger.warn("Get请求 查找入库单数据出错");
            e.printStackTrace();
        }
        return result.toJSONString();
    }

    /**
     * 获取所有数据
     * @param message
     * @return
     */
    @PostMapping(value = "/stockIn/loadStockIn")
    public JSONObject getProductsList(@RequestParam Map<String,String> message){
        String isStockIn = message.get("isStockIn");
        JSONObject result = new JSONObject();
        result.put("success",false);
        try {
            if (isStockIn.equals("isStockIn")){
                //查询所有入库单数据
                List<StockIn> StockInList = stockInService.queryStockInList();
                result.put("success",true);
                result.put("data",StockInList);
            }else {
                result.put("data","{[]}");
                result.put("success",false);
                result.put("error","查询入库单数据失败");
            }
        }catch (Exception e){
            logger.warn("查找入库单数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新单个数据
     * @return
     */
    @PostMapping(value = "/stockIn/updateStockIn")
    public JSONObject updateProductsInfo(StockIn stockIn){
        JSONObject result = new JSONObject();
        result.put("success",false);
        int updateFlag = 0 ;
        try {
            if (null != stockIn && null!= stockIn.getStockInoutId()){
                updateFlag = stockInService.updateByPrimaryKey(stockIn);
                if (updateFlag == 1){
                    result.put("success",true);
                    StockIn newStockIn= new StockIn();
                    newStockIn = stockInService.selectByPrimaryKey(stockIn.getStockInoutId());
                    result.put("data",newStockIn);
                    logger.info("更新入库单信息成功, 入库单信息:" + stockIn.getInvoiceCode());
                }
            }else {
                result.put("error","入库单信息缺失 更新入库单信息失败");
            }
        } catch (Exception e){
            logger.warn("更新入库单数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 插入单个数据
     * 新增入库单 暂定只有一级分类
     * 通过InvoiceCode 和入库单 关联
     * @return
     */
    @PostMapping(value = "/stockIn/insertStockIn")
    public JSONObject insertStockIn(@RequestParam Map<String, String>  message){

        JSONObject result = new JSONObject();
        JSONObject param = new JSONObject();
        String isStockInInsert = message.get("isStockInInsert");
        int insertFlag = -1;
        result.put("success",false);
        try {
            if (null!= isStockInInsert && "isStockInInsert".equals(message.get("isStockInInsert")) ){
                //接收数据中的实体队列
                //JSONArray jsonArray = result.getJSONArray("Company");
                /*for (int i = 0; i< jsonArray.size(); i++){
                        JSONObject crmPayTypeData = jsonArray.getJSONObject(i);
                }*/
                StockIn stockIn = new StockIn();
                stockIn.setInvoiceCode(constService.getRandenCode(Consts.StockInPrefix));
                //入库类型  写死 5 采购入库
                stockIn.setMoveTypeId(Consts.StockInPurchase);
                if (null!= message.get("stockhouseCode")){
                    stockIn.setStockhouseCode(message.get("stockhouseCode"));
                }else{
                    stockIn.setStockhouseCode("WH_1001");
                }
                stockIn.setCreatedDate(new Date());
                stockIn.setCreatedBy(Long.valueOf(1)); //创建人
                stockIn.setModifiedDate(new Date());
                stockIn.setModifiedBy(Long.valueOf(1)); // 修改人
                //初始化入库单 进度 未入库 0
                stockIn.setProcessStatus(Consts.StandNum.toString());
                //判断总数量总价格
                if (null!= message.get("totalCost") && null!= message.get("totalQty")){
                    stockIn.setTotalCost(new BigDecimal(message.get("totalCost")));
                    stockIn.setTotalQty(new BigDecimal(message.get("totalQty")));
                }
                if(null!= message.get("memo") ){
                    stockIn.setMemo(message.get("memo"));
                }

                //判断插入是否成功
                insertFlag = stockInService.insert(stockIn);
                result.put("data",insertFlag);
                if (insertFlag == 1 ){
                    StockIn newStockIn = new StockIn();
                    newStockIn = stockInService.selectByInvoiceCode(stockIn.getInvoiceCode());

                    /* 子单录入
                    * 子单校验
                    * */
                    result.put("success",true);
                    result.put("stockIn",newStockIn);//存入插入的大订单
                    logger.info("新增入库单数据成功"+stockIn.getInvoiceCode());
                }else {
                    result.put("error", "新增入库单失败");
                }

                /*  循环遍历插入入库子单  */

            }
        } catch (Exception e){
            logger.warn("新增入库单数据出错");
            e.printStackTrace();
            result.put("error", "新增入库单数据出错");
            return  result;
        }
        return result;
    }

    /**
     * 插入入库子单
     * 通过InvoiceCode 和入库单 关联
     * @return
     */
    @PostMapping(value = "/stockIn/insertStockInDetail")
    public JSONObject insertStockInDetail(@RequestParam Map<String, String>  message){
        JSONObject result = new JSONObject();
        JSONObject param = new JSONObject();
        result.put("success",false);
        String invoiceCode = "";
        String isStockInInsertDetail = message.get("isStockInInsertDetail");
        int updateFlag = -1;
        result.put("success",false);
        List<StockInDetail> stockInDetailList = new ArrayList<StockInDetail>();
        try {
            if (null!= isStockInInsertDetail && "isStockInInsertDetail".equals(message.get("isStockInInsertDetail"))
                    &&null!= message.get("invoiceCode") &&null!= message.get("stockInDetailMsg")){
                invoiceCode =message.get("invoiceCode"); //读取总单单号
                //校验原来的单子在不在 在的话就删掉
                stockInDetailList = stockInDetailService.selectByInvoiceCode(invoiceCode);
                if (stockInDetailList.size()>0){
                    for(int i = 0; i<stockInDetailList.size(); i++){
                       stockInDetailService.deleteByPrimaryKey(stockInDetailList.get(i).getStocksDetailCode());
                    }
                }
                //接收入库总单  更新信息
                StockIn stockIn = new StockIn();
                stockIn.setStockInoutId(stockInService.selectByInvoiceCode(message.get("invoiceCode")).getStockInoutId());
                stockIn.setInvoiceCode(invoiceCode);
                stockIn.setStockhouseCode(message.get("stockhouseCode"));
                stockIn.setProcessStatus(message.get("processStatus"));
                stockIn.setModifiedDate(new Date());
                stockIn.setModifiedBy(Long.valueOf(1)); // 修改人
                //初始化入库单 进度 未入库 0
                //stockIn.setProcessStatus(message.get("stockhouseCode"));
                //判断总数量总价格
                stockIn.setTotalCost(new BigDecimal(message.get("totalCost")));
                stockIn.setTotalQty(new BigDecimal(message.get("totalQty")));
                stockIn.setMemo(message.get("memo"));
                //判断更新是否成功
                updateFlag = stockInService.updateByPrimaryKeySelective(stockIn);
                result.put("data",updateFlag);
                String stockIndetailList = message.get("stockInDetailMsg");
                String detailDataList[] = stockIndetailList.split(";");

                for (int i = 0; i<detailDataList.length; i++){
                    //商品编号 单位 类别 单价 数量
                    String detailData[] = detailDataList[i].split(",");
                    StockInDetail stockInDetail = new StockInDetail();
                    stockInDetail.setInvoiceCode(stockIn.getInvoiceCode());
                    stockInDetail.setProductsCode(detailData[0]);//商品编号
                    stockInDetail.setUnitId(Long.valueOf(detailData[1]));//商品分类
                    stockInDetail.setProductsModel(detailData[2]);//商品单位
                    stockInDetail.setPrice(new BigDecimal(detailData[3]));//单价
                    stockInDetail.setQuantity(new BigDecimal(detailData[4]));//数量
                    stockInDetail.setTypeId(Consts.StockInPurchase);//写死入库类型 5 采购入库

                    //设置该子单价钱  设置小数点2位 四舍五入
                    stockInDetail.setMoney((stockInDetail.getPrice().multiply(stockInDetail.getQuantity())).setScale(2,BigDecimal.ROUND_HALF_UP));
                    stockInDetailService.insert(stockInDetail);
                }

                if (updateFlag == 1 ){
                    StockIn newStockIn = new StockIn();
                    newStockIn = stockInService.selectByInvoiceCode(stockIn.getInvoiceCode());

                    result.put("success",true);
                    result.put("stockIn",newStockIn);//存入插入的大订单
                    logger.info("新增入库单子单数据成功"+stockIn.getInvoiceCode());
                }else {
                    result.put("error", "新增入库单子单失败");
                }

                /*  循环遍历插入入库子单  */

            }
        } catch (Exception e){
            logger.warn("新增入库单数据出错");
            e.printStackTrace();
            result.put("error", "新增入库单数据出错");
            return  result;
        }
        return result;
    }


    /**
     * 查找单个数据
     * 传入ID
     * 传入入库单名称
     * @return JSONObject
     */
    @PostMapping(value = "/stockIn/selectStockIn")
    public JSONObject selectByStockInInvoiceCode(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        result.put("success",false);
        result.put("data","{}");
        String invoiceCode = "";
        String processStatus = "";
        String createdDate = "";
        String modifiedDate = "";
        List<StockIn> stockInList = new ArrayList<StockIn>();
        List<StockInDetail> stockInDetailList = new ArrayList<StockInDetail>();
        //设置时间格式化
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
        try {
            StockIn stockIn = new StockIn();
            //订单号 条件判断
            if (null!=message.get("invoiceCode") && message.get("invoiceCode")!=""){
                invoiceCode = message.get("invoiceCode");
                stockIn.setInvoiceCode(invoiceCode);
                stockInDetailList = stockInDetailService.selectByInvoiceCode(invoiceCode);
            }
            //入库状态 条件判断
            if(null!= message.get("processStatus") && message.get("processStatus") !="" ){
                processStatus = message.get("processStatus");
                stockIn.setProcessStatus(processStatus);
            }
            //起始时间 条件判断
            if(null!= message.get("createdDate") && message.get("createdDate") !="" ){
                createdDate = message.get("createdDate");
                stockIn.setCreatedDate(format.parse(createdDate));
            }
            //终止时间 条件判断
            if( null!=message.get("modifiedDate") && message.get("modifiedDate") !=""){
                modifiedDate = message.get("modifiedDate");
                stockIn.setModifiedDate(format.parse(modifiedDate));
            }
            stockInList = stockInService.selectByStockIn(stockIn);

            //若有子单存在 则遍历查询加入
            if (stockInDetailList.size()>0){
                result.put("stockInDetailData",stockInDetailList);
            }

            if(stockInList.size()>0){
                result.put("data",stockInList);
                result.put("success",true);
                logger.info("查找单个入库单数数据成功");
            } else {
                logger.info("查找数据失败");
                result.put("error","查找数据失败");
            }
        } catch (Exception e){
            result.put("error","查找数据失败");
            logger.warn("查找单个入库单数数据出错");
            e.printStackTrace();
            return result;
        }
        return result;
    }


    /**
     * 删除单个入库单
     * 传入ID ID
     * @return JSONObject
     */
    @PostMapping(value = "/stockIn/deleteStockIn")
    public JSONObject deleteUnit(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        String isDeleteStockIn= message.get("isDeleteStockIn");
        String invoiceCode = message.get("invoiceCode");
        int deleteFlag = 0;
        result.put("success",false);
        try {
            //判空条件
            if(null!=message && "isDeleteStockIn".equals(isDeleteStockIn)){
                StockIn stockIn = new StockIn();     //查找到该入库单
                stockIn = stockInService.selectByInvoiceCode(invoiceCode);
                //伪删除处理
                stockIn.setProcessStatus(String.valueOf(Consts.DeleteNum));
                deleteFlag = stockInService.updateByPrimaryKeySelective(stockIn);

                /*ProductsUnit unit = new ProductsUnit();
                unit = categoryService.selectByPrimaryKey(categoryId);*/
                if (deleteFlag == 1 ){
                    result.put("success",true);
                    //result.put("data",salesFreightService.selectByPrimaryKey(freightId));
                    logger.info("删除单个数据成功");
                }else {
                    result.put("error","删除入库单数失败");
                }
                result.put("data",deleteFlag);
            } else {
                result.put("error","传入入库单数数据无效请检查");
                logger.warn("传入入库单数据无效请检查, 删除失败");
            }
        } catch (Exception e){
            logger.warn("删除单个入库单数数据出错");
            e.printStackTrace();
        }
        return result;
    }

}
