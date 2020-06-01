package com.ss.springbootNewshop.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.ss.springbootNewshop.bean.EcomShop;
import com.ss.springbootNewshop.service.EcomShopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: EcomShopController
 * @User: 邵帅
 * @Date: 2020/2/1612:44
 * Version 1.0
 * Description: 店铺管理
 **/

@RestController
public class EcomShopController {

    private static final Logger logger = LoggerFactory.getLogger(EcomShopController.class);

    @Autowired
    private EcomShopService ecomShopService;

    /**
     * 进入商品管理配置页面
     * @return
     */
    @RequestMapping("/ecomShop/Index")
    public ModelAndView getEcomShopIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("EcomShop");
        return modelAndView;
    }

    @RequestMapping("/ecomShop/save")
    public ModelAndView getEcomShopSaveIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("EcomShopSave");
        return modelAndView;
    }


    /**
     * 加载店铺信息
     * @param isEcomShop
     * @return
     */
    @GetMapping(value = "/ecomShop/loadEcomShop",produces = "application/json;charset=UTF-8")
    public String getProductsList(String isEcomShop){
        JSONObject result = new JSONObject();
        result.put("success",false);
        result.put("data","");
        try {
            if (isEcomShop.equals("isEcomShop")){
                List<EcomShop> ecomShopList = ecomShopService.queryEcomShop();
                result.put("success",true);
                result.put("data",ecomShopList);
                logger.info("加载店铺数据成功");
            }else {
                result.put("success",false);
                result.put("error","加载所有店铺信息出错");
            }

        }catch (Exception e){
            logger.warn("Get请求 查找店铺数据出错");
            e.printStackTrace();
        }
        return result.toJSONString();
    }

    /**
     * 获取所有数据
     * @param message
     * @return
     */
    @PostMapping(value = "/ecomShop/loadEcomShop")
    public JSONObject getProductsList(@RequestParam Map<String,String> message){
        String isEcomShop = message.get("isEcomShop");
        JSONObject result = new JSONObject();
        result.put("success",false);
        try {
            if (isEcomShop.equals("isEcomShop")){
                //查询所有店铺数据
                List<EcomShop> ecomShopList = ecomShopService.queryEcomShop();
                result.put("success",true);
                result.put("data",ecomShopList);
                logger.info("加载店铺数据成功");
            }else {
                result.put("data","{[]}");
                result.put("success",false);
                result.put("error","查询店铺数据失败");
            }
        }catch (Exception e){
            logger.warn("查找店铺数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新单个数据
     * @return
     */
    @PostMapping(value = "/ecomShop/updateEcomShop")
    public JSONObject updateProductsInfo(EcomShop ecomShop){
        JSONObject result = new JSONObject();
        result.put("success",false);
        int updateFlag = 0 ;
        try {
            if (null != ecomShop && null!= ecomShop.getShopId()){
                updateFlag = ecomShopService.updateByPrimaryKeySelective(ecomShop);
                if (updateFlag == 1){
                    result.put("success",true);
                    EcomShop newEcomShop= new EcomShop();
                    newEcomShop = ecomShopService.selectByPrimaryKey(ecomShop.getShopId());
                    result.put("data",newEcomShop);
                    logger.info("更新店铺信息成功, 店铺信息:" + newEcomShop.getShopName());
                }
            }else {
                result.put("error","店铺信息缺失 更新店铺信息失败");
            }
        } catch (Exception e){
            logger.warn("更新店铺数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 插入单个数据
     * 新增店铺   联系人 联系电话 地址 坐标
     * @return
     */
    @PostMapping(value = "/ecomShop/insertEcomShop")
    public JSONObject insertProducts(@RequestParam Map<String, String> message){
        JSONObject result = new JSONObject();
        JSONObject param = new JSONObject();
        String isEcomShopInsert = message.get("isEcomShopInsert");
        int insertFlag = -1;
        result.put("success",false);
        try {
            if (null!= isEcomShopInsert && null != message.get("shopName")){
                //接收数据中的实体队列
                //JSONArray jsonArray = result.getJSONArray("Company");
                /*for (int i = 0; i< jsonArray.size(); i++){
                        JSONObject crmPayTypeData = jsonArray.getJSONObject(i);
                }*/

                EcomShop ecomShop  = new EcomShop();
                ecomShop.setShopName(message.get("shopName"));                   //店铺名称
                ecomShop.setShopCode(message.get("shopCode"));
                ecomShop.setContactCompany(message.get("contactCompany"));
                ecomShop.setContactPhone(message.get("contactPhone"));
                ecomShop.setCityCode(message.get("cityCode"));
                ecomShop.setProvinceCode(message.get("provinceCode"));
                ecomShop.setGpsX(message.get("gpsX"));
                ecomShop.setGpsY(message.get("gpsY"));
                ecomShop.setWarehouseCode(message.get("warehouseCode"));
                ecomShop.setShopLogo(message.get("mainImg"));                    //主图片
                ecomShop.setMemo(message.get("memo"));                           //店铺备注
                insertFlag = ecomShopService.insertSelective(ecomShop);
                result.put("data",insertFlag);
                if (insertFlag == 1 ){
                    result.put("success",true);
                    logger.info("新增店铺数据成功"+ecomShop.getShopName());
                }else {
                    result.put("error", "新增店铺失败");
                }
            }
        } catch (Exception e){
            logger.warn("新增店铺数据出错");
            e.printStackTrace();
            result.put("error", "新增店铺数据出错");
            return  result;
        }
        return result;
    }

    /**
     * 查找单个数据
     * 传入ID
     * 传入店铺名称
     * @return JSONObject
     */
    @PostMapping(value = "/ecomShop/selectEcomShop")
    public JSONObject selectByProducts(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        result.put("success",false);
        result.put("data","{}");
        List<EcomShop> ecomShopList = new ArrayList<EcomShop>();
        try {
            EcomShop ecomShop = new EcomShop();
            if (null!=message.get("shopName") && message.get("shopName")!=""){
                ecomShop = ecomShopService.selectByShopName(message.get("shopName"));
            }
            if (null!=message.get("ecomShopID") && Long.valueOf(message.get("ecomShopID"))>0){
                ecomShop = ecomShopService.selectByPrimaryKey(Long.valueOf(message.get("ecomShopID")));
            }
            //ecomShopList = ecomShopService.sele(products);
            if(null!=ecomShop.getShopName()){
                result.put("data",ecomShop);
                result.put("success",true);
                logger.info("查找单个店铺数数据成功");
            } else {
                logger.info("查找数据失败");
                result.put("error","查找数据失败");
            }
        } catch (Exception e){
            result.put("error","查找数据失败");
            logger.warn("查找单个店铺数数据出错");
            e.printStackTrace();
            return result;
        }
        return result;
    }

    /**
     * 查找单个数据
     * 传入ID
     * 传入店铺名称
     * @return JSONObject
     */
    @PostMapping(value = "/ecomShop/selectEcomShopById")
    public JSONObject selectByProductsId(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        result.put("success",false);
        result.put("data","{}");
        Long shopId = Long.valueOf(message.get("shopId"));
        List<EcomShop> EcomShopList = new ArrayList<EcomShop>();
        try {
            if (null!=shopId && shopId>0 ){
                EcomShop ecomShop = new EcomShop();
                ecomShop = ecomShopService.selectByPrimaryKey(shopId);
                EcomShopList.add(ecomShop);
                if(EcomShopList.size()>0){
                    result.put("data",EcomShopList);
                    result.put("success",true);
                    logger.info("根据主键查找单个店铺数数据成功");
                }
            }else {
                logger.info("查找数据失败");
                result.put("error","查找数据失败");
            }
        } catch (Exception e){
            result.put("error","查找数据失败");
            logger.warn("查找单个店铺数数据出错");
            e.printStackTrace();
            return result;
        }
        return result;
    }


    /**
     * 删除单个店铺
     * 传入ID ID
     * @return JSONObject
     */
    @PostMapping(value = "/ecomShop/deleteEcomShop")
    public JSONObject deleteUnit(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        String isDeleteEcomShop= message.get("isDeleteEcomShop");
        Long shopId = Long.valueOf(message.get("shopId"));
        int deleteFlag = 0;
        result.put("success",false);
        try {
            if(null!=message && "isDeleteEcomShop".equals(isDeleteEcomShop)){
                deleteFlag =ecomShopService.deleteByPrimaryKey(shopId);
                //伪删除处理
                /*ProductsUnit unit = new ProductsUnit();
                unit = categoryService.selectByPrimaryKey(categoryId);*/
                if (deleteFlag == 1 ){
                    result.put("success",true);
                    //result.put("data",salesFreightService.selectByPrimaryKey(freightId));
                    logger.info("删除单个数据成功");
                }else {
                    result.put("error","删除店铺数失败");
                }
                result.put("data",deleteFlag);
            } else {
                result.put("error","传入店铺数数据无效请检查");
                logger.warn("传入店铺数据无效请检查, 删除失败");
            }
        } catch (Exception e){
            logger.warn("删除单个店铺数数据出错");
            e.printStackTrace();
        }
        return result;
    }
}
