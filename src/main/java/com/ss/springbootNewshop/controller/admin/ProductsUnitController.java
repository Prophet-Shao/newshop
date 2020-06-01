package com.ss.springbootNewshop.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.ss.springbootNewshop.bean.ProductsUnit;
import com.ss.springbootNewshop.service.ProductsUnitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ProductsUnitController
 * @User: 邵帅
 * @Date: 2020/2/817:09
 * Version 1.0
 * Description: TODO
 **/
@RestController
public class ProductsUnitController {
     private static final Logger logger = LoggerFactory.getLogger(ProductsUnitController.class);

     @Autowired
     private ProductsUnitService productsUnitService;


    /**
     * 进入商品单位管理配置页面
     * @return
     */
    @RequestMapping("/productsUnit/Index")
    public ModelAndView getUnitIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ProductsUnit");
        return modelAndView;
    }

    /**
     * 加载商品单位信息
     * @param isUnit
     * @return
     */
    @GetMapping(value = "/productsUnit/loadUnit",produces = "application/json;charset=UTF-8")
    public String getUnitList(String isUnit){
        JSONObject result = new JSONObject();
        result.put("success",false);
        result.put("data","");
        try {
            if (isUnit.equals("isUnit")){
                List<ProductsUnit> unitList = productsUnitService.queryUnitInfo();
                result.put("success",true);
                result.put("data",unitList);
                logger.info("加载商品单位数据成功");
            }else {
                result.put("success",false);
                result.put("error","加载所有商品单位信息出错");
            }

        }catch (Exception e){
            logger.warn("Get请求 查找商品单位数据出错");
            e.printStackTrace();
        }
        return result.toJSONString();
    }

    /**
     * 获取所有数据
     * @param message
     * @return
     */
    @PostMapping(value = "/productsUnit/loadUnit")
    public JSONObject getUnitList(@RequestParam Map<String,String> message){
        String isUnit = message.get("isUnit");
        JSONObject result = new JSONObject();
        result.put("success",false);
        try {
            if (isUnit.equals("isUnit")){
                //查询所有商品单位数据
                List<ProductsUnit> unitList = productsUnitService.queryUnitInfo();
                result.put("success",true);
                result.put("data",unitList);
            }else {
                result.put("data","{[]}");
                result.put("success",false);
                result.put("error","查询商品单位数据失败");
            }
        }catch (Exception e){
            logger.warn("查找商品单位数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新单个数据
     * @return
     */
    @PostMapping(value = "/productsUnit/updateUnit")
    public JSONObject updateUnitInfo(ProductsUnit unit){
        JSONObject result = new JSONObject();
        result.put("success",false);
        int updateFlag = 0 ;
        try {
            if (null != unit && null!= unit.getUnitId()){

                updateFlag = productsUnitService.updateByPrimaryKeySelective(unit);
                if (updateFlag == 1){
                    result.put("success",true);
                    ProductsUnit newUnit = new ProductsUnit();
                    newUnit = productsUnitService.selectByPrimaryKey(unit.getUnitId());
                    result.put("data",newUnit);
                    logger.info("更新商品单位信息成功, 商品单位信息:" + newUnit.getSymbol());
                }
            }else {
                result.put("error","商品单位信息缺失 更新商品单位信息失败");
            }
        } catch (Exception e){
            logger.warn("更新商品单位数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 插入单个数据
     * 新增商品单位 暂定只有一级分类
     * 通过catagoryId 和商品 关联
     * @return
     */
    @PostMapping(value = "/productsUnit/insertUnit")
    public JSONObject insertUnit(@RequestParam Map<String, String>  message){

        JSONObject result = new JSONObject();
        JSONObject param = new JSONObject();
        String isUnitInsert = message.get("isUnitInsert");
        int insertFlag = -1;
        result.put("success",false);
        try {
            if (null!= isUnitInsert && null != message.get("symbol")){
                //接收数据中的实体队列
                //JSONArray jsonArray = result.getJSONArray("Company");
                /*for (int i = 0; i< jsonArray.size(); i++){
                        JSONObject crmPayTypeData = jsonArray.getJSONObject(i);
                }*/
                ProductsUnit unit  = new ProductsUnit();
                unit.setSymbol(message.get("symbol"));
                unit.setDescription(message.get("description"));
                unit.setAccountSetId(Long.valueOf(message.get("accountSetId")) );
                unit.setMemo(message.get("memo"));
                insertFlag = productsUnitService.insert(unit);
                result.put("data",insertFlag);
                if (insertFlag == 1 ){
                    result.put("success",true);
                    logger.warn("新增商品单位数据成功"+unit.getSymbol());
                }else {
                    result.put("error", "新增商品单位失败");
                }
            }
        } catch (Exception e){
            logger.warn("新增商品单位数据出错");
            e.printStackTrace();
            result.put("error", "新增商品单位数据出错");
            return  result;
        }
        return result;
    }

    /**
     * 查找单个数据
     * 传入ID
     * 传入商品单位名称
     * @return JSONObject
     */
    @PostMapping(value = "/productsUnit/selectUnitName")
    public JSONObject selectByUnitName(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        String symbol = "";
        try {
            symbol = message.get("unitName");
            symbol = "克";
            result.put("data",productsUnitService.selectByUnitName(symbol));
            //result.put("data",crmUserService.selectCrmUserById((long) 4));
            logger.warn("查找单个商品单位数数据成功");
        } catch (Exception e){
            logger.warn("查找单个商品单位数数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除单个商品单位
     * 传入ID ID
     * @return JSONObject
     */
    @PostMapping(value = "/productsUnit/deleteUnit")
    public JSONObject deleteUnit(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        String isDeleteUnit= message.get("isDeleteUnit");
        long unitId = Long.valueOf(message.get("unitId"));
        int deleteFlag = 0;
        result.put("success",false);
        try {
            if(null!=message && "isDeleteUnit".equals(isDeleteUnit)){
                deleteFlag =productsUnitService.deleteByPrimaryKey(unitId);
                //伪删除处理
                /*ProductsUnit unit = new ProductsUnit();
                unit = categoryService.selectByPrimaryKey(categoryId);*/
                if (deleteFlag == 1 ){
                    result.put("success",true);
                    //result.put("data",salesFreightService.selectByPrimaryKey(freightId));
                    logger.info("删除单个数据成功");
                }else {
                    result.put("error","删除商品单位数失败");
                }
                result.put("data",deleteFlag);
            } else {
                result.put("error","传入商品单位数数据无效请检查");
                logger.warn("传入商品单位数据无效请检查, 删除失败");
            }

        } catch (Exception e){
            logger.warn("删除单个商品单位数数据出错");
            e.printStackTrace();
        }
        return result;
    }
}
