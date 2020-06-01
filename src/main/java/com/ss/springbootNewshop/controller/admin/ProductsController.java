package com.ss.springbootNewshop.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.ss.springbootNewshop.Consts.Consts;
import com.ss.springbootNewshop.bean.Products;
import com.ss.springbootNewshop.service.ProductsService;
import com.ss.springbootNewshop.utils.ConstService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ProductsController
 * @User: 邵帅
 * @Date: 2020/2/823:51
 * Version 1.0
 * Description: TODO
 **/
@RestController
public class ProductsController {
    private static final Logger logger = LoggerFactory.getLogger(ProductsUnitController.class);

    @Autowired
    private ProductsService productsService;

    @Autowired
    private ConstService constService;

    /**
     * 进入商品管理配置页面
     * @return
     */
    @RequestMapping("/products/Index")
    public ModelAndView getProductsIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Products");
        return modelAndView;
    }

    @RequestMapping("/products/save")
    public ModelAndView getProductsSaveIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ProductsSave");
        return modelAndView;
    }

    /**
     * 加载店铺商品详细数据
     * @return
     */
    @RequestMapping("/shop/ProductsDetail")
    public ModelAndView getShopProductsDetail(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ShopProductsDetail");
        return modelAndView;
    }



    /**
     * 加载商品信息
     * @param isProducts
     * @return
     */
    @GetMapping(value = "/products/loadProducts",produces = "application/json;charset=UTF-8")
    public String getProductsList(String isProducts){
        JSONObject result = new JSONObject();
        result.put("success",false);
        result.put("data","");
        try {
            if (isProducts.equals("isProducts")){
                List<Products> ProductsList = productsService.queryProductsList();
                result.put("success",true);
                result.put("data",ProductsList);
                logger.info("加载商品数据成功");
            }else {
                result.put("success",false);
                result.put("error","加载所有商品信息出错");
            }

        }catch (Exception e){
            logger.warn("Get请求 查找商品数据出错");
            e.printStackTrace();
        }
        return result.toJSONString();
    }

    /**
     * 获取所有数据
     * @param message
     * @return
     */
    @PostMapping(value = "/products/loadProducts")
    public JSONObject getProductsList(@RequestParam Map<String,String> message){
        String isProducts = message.get("isProducts");
        JSONObject result = new JSONObject();
        result.put("success",false);
        try {
            if (isProducts.equals("isProducts")){
                //查询所有商品数据
                List<Products> productsList = productsService.queryProductsList();
                result.put("success",true);
                result.put("data",productsList);
            }else {
                result.put("data","{[]}");
                result.put("success",false);
                result.put("error","查询商品数据失败");
            }
        }catch (Exception e){
            logger.warn("查找商品数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新单个数据
     * @return
     */
    @PostMapping(value = "/products/updateProducts")
    public JSONObject updateProductsInfo(Products products){
        JSONObject result = new JSONObject();
        result.put("success",false);
        int updateFlag = 0 ;
        try {
            if (null != products && null!= products.getId()){

                updateFlag = productsService.updateByPrimaryKeySelective(products);
                if (updateFlag == 1){
                    result.put("success",true);
                    Products newProducts= new Products();
                    newProducts = productsService.selectByPrimaryKey(products.getId());
                    result.put("data",newProducts);
                    logger.info("更新商品信息成功, 商品信息:" + newProducts.getProductName());
                }
            }else {
                result.put("error","商品信息缺失 更新商品信息失败");
            }
        } catch (Exception e){
            logger.warn("更新商品数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 插入单个数据
     * 新增商品 暂定只有一级分类
     * 通过catagoryId 和商品 关联
     * @return
     */
    @PostMapping(value = "/products/insertProducts")
    public JSONObject insertProducts(@RequestParam Map<String, String>  message){

        JSONObject result = new JSONObject();
        JSONObject param = new JSONObject();
        String isProductsInsert = message.get("isProductsInsert");
        int insertFlag = -1;
        result.put("success",false);
        try {
            if (null!= isProductsInsert && null != message.get("ProductsName")){
                //接收数据中的实体队列
                //JSONArray jsonArray = result.getJSONArray("Company");
                /*for (int i = 0; i< jsonArray.size(); i++){
                        JSONObject crmPayTypeData = jsonArray.getJSONObject(i);
                }*/
                Products products  = new Products();
                    products.setProductName(message.get("ProductsName"));                   //商品名称
                    products.setProductDesc(message.get("ProductsDesc"));                   //商品描述
                    products.setColor(message.get("color"));                                //颜色
                    products.setSize(Long.valueOf(message.get("size")));                    //大小
                    products.setCost(new BigDecimal(message.get("price")));                  //进货价 cost
                    products.setPrice(new BigDecimal(message.get("price")));                //单价
                    products.setSalesPrice(new BigDecimal(message.get("salesPrice")));      //售价
                    products.setAgentPrice(new BigDecimal(message.get("agentPrice")));      //售价
                    products.setCategoryId(Integer.valueOf(message.get("ProductsCategory")));     //商品分类
                    products.setUnitId(Long.valueOf(message.get("ProductsUnit")));
                    products.setQuantity(new BigDecimal(message.get("quantity")));          //数量
                    products.setMainPic(message.get("mainImg"));                            //主图片
                    products.setLeftPic(message.get("mainImg"));                            //缩略图
                    products.setMemo(message.get("memo"));                                  //商品备注
                    products.setMemo2(constService.getRandenCode(Consts.ProductsPrefix));   //商品编号
                    products.setCreatedTime(new Date());
                insertFlag = productsService.insert(products);
                result.put("data",insertFlag);
                if (insertFlag == 1 ){
                    result.put("success",true);
                    logger.info("新增商品数据成功"+products.getProductName());
                }else {
                    result.put("error", "新增商品失败");
                }
            }
        } catch (Exception e){
            logger.warn("新增商品数据出错");
            e.printStackTrace();
            result.put("error", "新增商品数据出错");
            return  result;
        }
        return result;
    }

    /**
     * 查找单个数据
     * 传入ID
     * 传入商品名称
     * @return JSONObject
     */
    @PostMapping(value = "/products/selectProducts")
    public JSONObject selectByProducts(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        result.put("success",false);
        result.put("data","{}");
        String productsName = "";
        String categoryId = "";
        String isSpecial = "";
        List<Products> productsList = new ArrayList<Products>();
        try {
            Products products = new Products();
            //判断是否是全部商品
            if(null!= message.get("ProductsCategory") && message.get("ProductsCategory").equals("-1")){
                productsList = productsService.queryProductsList();
            }else  {
                if (null!= message.get("ProductsCategory") && message.get("ProductsCategory")!="-1"){
                    categoryId= message.get("ProductsCategory");
                    products.setCategoryId(Integer.valueOf(categoryId));
                }
                if (null!=message.get("ProductsName") && ""!=message.get("ProductsName")){
                    productsName= message.get("ProductsName");
                    products.setProductName(productsName);
                }
                if (null!=message.get("isSpecial") && ""!=message.get("isSpecial")){
                    isSpecial= message.get("isSpecial");
                    products.setMemo3("1");
                }


                productsList = productsService.selectByProducts(products);
            }
            if(productsList.size()>0){
                result.put("data",productsList);
                result.put("success",true);
                logger.info("查找单个商品数数据成功");
            } else {
                logger.info("查找数据失败");
                result.put("error","查找数据失败");
            }
        } catch (Exception e){
            result.put("error","查找数据失败");
            logger.warn("查找单个商品数数据出错");
            e.printStackTrace();
            return result;
        }
        return result;
    }

    /**
     * 查找单个数据
     * 传入ID
     * 传入商品名称
     * @return JSONObject
     */
    @PostMapping(value = "/products/selectProductsById")
    public JSONObject selectByProductsId(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        result.put("success",false);
        result.put("data","{}");
        Integer productsId = Integer.valueOf(message.get("ProductsId"));
        List<Products> productsList = new ArrayList<Products>();
        try {
            if (null!=productsId && productsId>0 ){
                Products products = new Products();
                products = productsService.selectByPrimaryKey(productsId);
                productsList.add(products);
                if(productsList.size()>0){
                    result.put("data",productsList);
                    result.put("success",true);
                    logger.info("根据主键查找单个商品数数据成功");
                }
            }else {
                logger.info("查找数据失败");
                result.put("error","查找数据失败");
            }
        } catch (Exception e){
            result.put("error","查找数据失败");
            logger.warn("查找单个商品数数据出错");
            e.printStackTrace();
            return result;
        }
        return result;
    }


    /**
     * 查找单个数据
     * 传入ID
     * 传入商品名称
     * @return JSONObject
     */
    @PostMapping(value = "/products/selectByProductsCode")
    public JSONObject selectByProductsCode(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        result.put("success",false);
        result.put("data","{}");
        try {
            if (null!= message.get("memo2") && "" != message.get("memo2")){
                Products products = new Products();
                products = productsService.selectByProductsCode(message.get("memo2"));
                result.put("data",products);
                result.put("success",true);
                logger.info("根据主键查找单个商品数数据成功");
            }else {
                logger.info("查找数据失败");
                result.put("error","ProductsCode 输入不正确 查找数据失败");
            }
        } catch (Exception e){
            result.put("error","查找数据失败");
            logger.warn("通过查找ProductsCode 查找单个商品数数据出错");
            e.printStackTrace();
            return result;
        }
        return result;
    }

    /**
     * 删除单个商品
     * 传入ID ID
     * @return JSONObject
     */
    @PostMapping(value = "/products/deleteProducts")
    public JSONObject deleteUnit(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        String isDeleteProducts= message.get("isDeleteProducts");
        Integer productsId = Integer.valueOf(message.get("productsId"));
        int deleteFlag = 0;
        result.put("success",false);
        try {
            if(null!=message && "isDeleteProducts".equals(isDeleteProducts)){
                deleteFlag =productsService.deleteByPrimaryKey(productsId);
                //伪删除处理
                /*ProductsUnit unit = new ProductsUnit();
                unit = categoryService.selectByPrimaryKey(categoryId);*/
                if (deleteFlag == 1 ){
                    result.put("success",true);
                    //result.put("data",salesFreightService.selectByPrimaryKey(freightId));
                    logger.info("删除单个数据成功");
                }else {
                    result.put("error","删除商品数失败");
                }
                result.put("data",deleteFlag);
            } else {
                result.put("error","传入商品数数据无效请检查");
                logger.warn("传入商品数据无效请检查, 删除失败");
            }
        } catch (Exception e){
            logger.warn("删除单个商品数数据出错");
            e.printStackTrace();
        }
        return result;
    }


}
