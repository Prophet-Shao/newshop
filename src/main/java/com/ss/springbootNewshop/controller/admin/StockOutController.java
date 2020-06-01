package com.ss.springbootNewshop.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.ss.springbootNewshop.Consts.Consts;
import com.ss.springbootNewshop.bean.StockOut;
import com.ss.springbootNewshop.bean.StockOutDetail;
import com.ss.springbootNewshop.service.StockOutDetialService;
import com.ss.springbootNewshop.service.StockOutService;
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
 * @ClassName: StockOutController
 * @User: 邵帅
 * @Date: 2020/3/217:49
 * Version 1.0
 * Description: 出库
 **/

@RestController
public class StockOutController {

    private static final Logger logger = LoggerFactory.getLogger(StockOutController.class);

    @Autowired
    private StockOutService stockOutService;

    @Autowired
    private StockOutDetialService stockOutDetialService;

    @Autowired
    private ConstService constService;

    /**
     * 进入出库单管理配置页面
     * @return
     */
    @RequestMapping("/stockOut/Index")
    public ModelAndView getStockOutIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("StockOut");
        return modelAndView;
    }

    @RequestMapping("/stockOut/save")
    public ModelAndView getStockOutSaveIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("StockOutSave");
        return modelAndView;
    }


    /**
     * 加载出库单信息
     * @param isStockOut
     * @return
     */
    @GetMapping(value = "/stockOut/loadStockOut",produces = "application/json;charset=UTF-8")
    public String getStockOutList(String isStockOut){
        JSONObject result = new JSONObject();
        result.put("success",false);
        result.put("data","");
        try {
            if (null!=isStockOut && isStockOut.equals("isStockOut")){
                List<StockOut> StockOutList = stockOutService.queryStockOutList();
                result.put("success",true);
                result.put("data",StockOutList);
                logger.info("加载出库单数据成功");
            }else {
                result.put("success",false);
                result.put("error","加载所有出库单信息出错");
            }

        }catch (Exception e){
            logger.warn("Get请求 查找出库单数据出错");
            e.printStackTrace();
        }
        return result.toJSONString();
    }

    /**
     * 获取所有数据
     * @param message
     * @return
     */
    @PostMapping(value = "/stockOut/loadStockOut")
    public JSONObject getStockOutList(@RequestParam Map<String,String> message){
        String isStockOut = message.get("isStockOut");
        JSONObject result = new JSONObject();
        result.put("success",false);
        try {
            if (isStockOut.equals("isStockOut")){
                //查询所有出库单数据
                List<StockOut> StockOutList = stockOutService.queryStockOutList();
                result.put("success",true);
                result.put("data",StockOutList);
            }else {
                result.put("data","{[]}");
                result.put("success",false);
                result.put("error","查询出库单数据失败");
            }
        }catch (Exception e){
            logger.warn("查找出库单数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新单个数据
     * @return
     */
    @PostMapping(value = "/stockOut/updateStockOut")
    public JSONObject updateStockOutInfo(StockOut stockOut){
        JSONObject result = new JSONObject();
        result.put("success",false);
        int updateFlag = 0 ;
        try {
            if (null != stockOut && null!= stockOut.getStockInoutId()){
                updateFlag = stockOutService.updateByPrimaryKey(stockOut);
                if (updateFlag == 1){
                    result.put("success",true);
                    StockOut newStockOut = new StockOut();
                    newStockOut = stockOutService.selectByPrimaryKey(stockOut.getStockInoutId());
                    result.put("data",newStockOut);
                    logger.info("更新出库单信息成功, 出库单信息:" + stockOut.getInvoiceCode());
                }
            }else {
                result.put("error","出库单信息缺失 更新出库单信息失败");
            }
        } catch (Exception e){
            logger.warn("更新出库单数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 插入单个数据
     * 新增出库单 暂定只有一级分类
     * 通过InvoiceCode 和出库单 关联
     * @return
     */
    @PostMapping(value = "/stockOut/insertStockOut")
    public JSONObject insertStockOut(@RequestParam Map<String, String>  message){
        JSONObject result = new JSONObject();
        JSONObject param = new JSONObject();
        String isStockOutInsert = message.get("isStockOutInsert");
        int insertFlag = -1;
        result.put("success",false);
        try {
            if (null!= isStockOutInsert && "isStockOutInsert".equals(message.get("isStockOutInsert")) ){
                //接收数据中的实体队列
                //JSONArray jsonArray = result.getJSONArray("Company");
                /*for (int i = 0; i< jsonArray.size(); i++){
                        JSONObject crmPayTypeData = jsonArray.getJSONObject(i);
                }*/
                StockOut stockOut = new StockOut();
                stockOut.setInvoiceCode(constService.getRandenCode(Consts.StockOutPrefix));
                //出库类型  写死 1 直接出库
                stockOut.setMoveTypeId(Consts.StockOut);
                if (null!= message.get("stockhouseCode")){
                    stockOut.setStockhouseCode(message.get("stockhouseCode"));
                }
                stockOut.setCreateDate(new Date());
                stockOut.setCreateBy(Long.valueOf(1)); //创建人
                stockOut.setModifiedDate(new Date());
                stockOut.setModifiedBy(Long.valueOf(1)); // 修改人
                //初始化出库单 进度 未出库 0
                stockOut.setProcessStatus(Consts.StandNum.toString());
                //判断总数量总价格
                if (null!= message.get("totalMoney") && null!= message.get("totalQty")){
                    stockOut.setTotalMoney(new BigDecimal(message.get("totalMoney")));
                    stockOut.setTotalQty(new BigDecimal(message.get("totalQty")));
                }
                if(null!= message.get("memo") ){
                    stockOut.setMemo(message.get("memo"));
                }
                //判断插入是否成功
                insertFlag = stockOutService.insert(stockOut);
                result.put("data",insertFlag);
                if (insertFlag == 1 ){
                    StockOut newStockOut = new StockOut();
                    newStockOut = stockOutService.selectByInvoiceCode(stockOut.getInvoiceCode());
                    result.put("success",true);
                    result.put("stockOut",newStockOut);//存入插入的大订单
                    logger.info("新增出库单数据成功"+stockOut.getInvoiceCode());
                }else {
                    result.put("error", "新增出库单失败");
                }
            }
        } catch (Exception e){
            logger.warn("新增出库单数据出错");
            e.printStackTrace();
            result.put("error", "新增出库单数据出错");
            return  result;
        }
        return result;
    }

    /**
     * 插入出库子单
     * 通过InvoiceCode 和出库单 关联
     * @return
     */
    @PostMapping(value = "/stockOut/insertStockOutDetail")
    public JSONObject insertStockOutDetail(@RequestParam Map<String, String>  message){
        JSONObject result = new JSONObject();
        JSONObject param = new JSONObject();
        result.put("success",false);
        String invoiceCode = "";
        String isStockOutInsertDetail = message.get("isStockOutInsertDetail");
        int updateFlag = -1;
        result.put("success",false);
        List<StockOutDetail> stockOutDetailList = new ArrayList<StockOutDetail>();
        try {
            if (null!= isStockOutInsertDetail && "isStockOutInsertDetail".equals(message.get("isStockOutInsertDetail"))
                    &&null!= message.get("invoiceCode") &&null!= message.get("stockOutDetailMsg")){
                invoiceCode =message.get("invoiceCode"); //读取总单单号
                //校验原来的单子在不在 在的话就删掉
                stockOutDetailList = stockOutDetialService.selectByInvoiceCode(invoiceCode);
                if (stockOutDetailList.size()>0){
                    for(int i = 0; i<stockOutDetailList.size(); i++){
                        stockOutDetialService.deleteByPrimaryKey(stockOutDetailList.get(i).getReturnStocksDetailCode());
                    }
                }
                //接收出库总单  更新信息
                StockOut stockOut = new StockOut();
                stockOut.setStockInoutId(stockOutService.selectByInvoiceCode(message.get("invoiceCode")).getStockInoutId());
                stockOut.setInvoiceCode(invoiceCode);
                stockOut.setStockhouseCode(message.get("stockhouseCode"));
                stockOut.setProcessStatus(message.get("processStatus"));
                stockOut.setModifiedDate(new Date());
                stockOut.setModifiedBy(Long.valueOf(1)); // 修改人
                //初始化出库单 进度 未出库 0
                //stockIn.setProcessStatus(message.get("stockhouseCode"));
                //判断总数量总价格
                stockOut.setTotalMoney(new BigDecimal(message.get("totalMoney")));
                stockOut.setTotalQty(new BigDecimal(message.get("totalQty")));
                stockOut.setMemo(message.get("memo"));
                //判断更新是否成功
                updateFlag = stockOutService.updateByPrimaryKeySelective(stockOut);
                result.put("data",updateFlag);
                String stockOutdetailList = message.get("stockOutDetailMsg");
                String detailDataList[] = stockOutdetailList.split(";");

                for (int i = 0; i<detailDataList.length; i++){
                    //商品编号 单位 类别 单价 数量
                    String detailData[] = detailDataList[i].split(",");
                    StockOutDetail stockOutDetail = new StockOutDetail();
                    stockOutDetail.setInvoiceCode(stockOut.getInvoiceCode());
                    stockOutDetail.setProductsCode(detailData[0]);//商品编号
                    stockOutDetail.setUnitId(Long.valueOf(detailData[1]));//商品分类
                    stockOutDetail.setProductsModel(detailData[2]);//商品单位
                    stockOutDetail.setPrice(new BigDecimal(detailData[3]));//单价
                    stockOutDetail.setQuantity(new BigDecimal(detailData[4]));//数量
                    stockOutDetail.setTypeId(Consts.StockOut);//写死出库类型 1 直接出库
                    //设置该子单价钱  设置小数点2位 四舍五入
                    stockOutDetail.setMoney((stockOutDetail.getPrice().multiply(stockOutDetail.getQuantity())).setScale(2,BigDecimal.ROUND_HALF_UP));
                    stockOutDetialService.insert(stockOutDetail);
                }

                if (updateFlag == 1 ){
                    StockOut newStockOut = new StockOut();
                    newStockOut = stockOutService.selectByInvoiceCode(stockOut.getInvoiceCode());

                    result.put("success",true);
                    result.put("stockOut",newStockOut);//存入插入的大订单
                    logger.info("新增出库单子单数据成功"+stockOut.getInvoiceCode());
                }else {
                    result.put("error", "新增出库单子单失败");
                }

                /*  循环遍历插入出库子单  */

            }
        } catch (Exception e){
            logger.warn("新增出库单数据出错");
            e.printStackTrace();
            result.put("error", "新增出库单数据出错");
            return  result;
        }
        return result;
    }


    /**
     * 查找单个数据
     * 传入ID
     * 传入出库单名称
     * @return JSONObject
     */
    @PostMapping(value = "/stockOut/selectStockOut")
    public JSONObject selectByStockOutInvoiceCode(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        result.put("success",false);
        result.put("data","{}");
        String invoiceCode = "";
        String processStatus = "";
        String createdDate = "";
        String modifiedDate = "";
        List<StockOut> stockOutList = new ArrayList<StockOut>();
        List<StockOutDetail> stockOutDetailList = new ArrayList<StockOutDetail>();
        //设置时间格式化
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
        try {
            StockOut stockOut = new StockOut();
            //订单号 条件判断
            if (null!=message.get("invoiceCode") && message.get("invoiceCode")!=""){
                invoiceCode = message.get("invoiceCode");
                stockOut.setInvoiceCode(invoiceCode);
                stockOutDetailList = stockOutDetialService.selectByInvoiceCode(invoiceCode);
            }
            //出库状态 条件判断
            if(null!= message.get("processStatus") && message.get("processStatus") !="" ){
                processStatus = message.get("processStatus");
                stockOut.setProcessStatus(processStatus);
            }
            //起始时间 条件判断
            if(null!= message.get("createdDate") && message.get("createdDate") !="" ){
                createdDate = message.get("createdDate");
                stockOut.setCreateDate(format.parse(createdDate));
            }
            //终止时间 条件判断
            if( null!=message.get("modifiedDate") && message.get("modifiedDate") !=""){
                modifiedDate = message.get("modifiedDate");
                stockOut.setModifiedDate(format.parse(modifiedDate));
            }
            stockOutList = stockOutService.selectByStockOut(stockOut);

            //若有子单存在 则遍历查询加入
            if (stockOutDetailList.size()>0){
                result.put("stockOutDetailData",stockOutDetailList);
            }

            if(stockOutList.size()>0){
                result.put("data",stockOutList);
                result.put("success",true);
                logger.info("查找单个出库单数数据成功");
            } else {
                logger.info("查找数据失败");
                result.put("error","查找数据失败");
            }
        } catch (Exception e){
            result.put("error","查找数据失败");
            logger.warn("查找单个出库单数数据出错");
            e.printStackTrace();
            return result;
        }
        return result;
    }


    /**
     * 删除单个出库单
     * 传入ID ID
     * @return JSONObject
     */
    @PostMapping(value = "/stockOut/deleteStockOut")
    public JSONObject deleteStockOut(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        String isDeleteStockOut= message.get("isDeleteStockOut");
        String invoiceCode = message.get("invoiceCode");
        int deleteFlag = 0;
        result.put("success",false);
        try {
            //判空条件
            if(null!=message && "isDeleteStockOut".equals(isDeleteStockOut)){
                StockOut stockOut = new StockOut();     //查找到该出库单
                stockOut = stockOutService.selectByInvoiceCode(invoiceCode);
                //伪删除处理
                stockOut.setProcessStatus(String.valueOf(Consts.DeleteNum));
                deleteFlag = stockOutService.updateByPrimaryKeySelective(stockOut);

                /*ProductsUnit unit = new ProductsUnit();
                unit = categoryService.selectByPrimaryKey(categoryId);*/
                if (deleteFlag == 1 ){
                    result.put("success",true);
                    //result.put("data",salesFreightService.selectByPrimaryKey(freightId));
                    logger.info("删除单个数据成功");
                }else {
                    result.put("error","删除出库单数失败");
                }
                result.put("data",deleteFlag);
            } else {
                result.put("error","传入出库单数数据无效请检查");
                logger.warn("传入出库单数据无效请检查, 删除失败");
            }
        } catch (Exception e){
            logger.warn("删除单个出库单数数据出错");
            e.printStackTrace();
        }
        return result;
    }

}
