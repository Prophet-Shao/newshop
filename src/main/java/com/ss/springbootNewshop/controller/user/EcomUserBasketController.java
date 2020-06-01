package com.ss.springbootNewshop.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.ss.springbootNewshop.bean.EcomUserBasket;
import com.ss.springbootNewshop.bean.crmUser;
import com.ss.springbootNewshop.service.EcomUserBasketService;
import com.ss.springbootNewshop.service.crmUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: EcomUserBasketController
 * @User: 邵帅
 * @Date: 2020/3/921:38
 * Version 1.0
 * Description: 购物车界面
 **/

@RestController
public class EcomUserBasketController {
    private static final Logger logger = LoggerFactory.getLogger(EcomUserBasketController.class);

    @Autowired
    private EcomUserBasketService ecomUserBasketService;

    @Autowired
    private crmUserService crmUserService;

    @RequestMapping("/ecomUserBasket/Index")
    public ModelAndView getEcomUserBasketIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("EcomUserBasket");
        return modelAndView;
    }

    @PostMapping(value = "/ecomUserBasket/getUserBasket")
    public JSONObject getUserBasketList(@RequestParam Map<String,String> message, HttpServletRequest request, HttpServletResponse response){
        String isBasketLoad = "";
        JSONObject result = new JSONObject();
        result.put("success",false);
        try {
            crmUser crmUser = new crmUser();
            if (null!= message.get("isBasketLoad") && message.get("isBasketLoad").equals("isBasketLoad")
                && null != request.getSession().getAttribute("userName")){
                String userName = (String) request.getSession().getAttribute("userName");
                //查询所有购物车数据
                crmUser newUser = new crmUser();
                newUser= crmUserService.selectByUserName(userName);

                List<EcomUserBasket> ecomUserBasketList = ecomUserBasketService.selectByUserName(userName);
                if (null!= newUser.getUserName() && newUser.getUserName().equals(userName) ){
                    request.getSession().setAttribute("userName",crmUser.getUserName());
                    result.put("success",true);
                    result.put("data",ecomUserBasketList);
                    result.put("user",newUser);
                    logger.info(userName+"用户购物车数据查找成功 ");
                    request.getSession().setAttribute("userName",userName);
                }else {
                    result.put("data","{[]}");
                    result.put("success",false);
                    result.put("error","用戶未登录,请先登录");
                    logger.warn("用戶未登录,请先登录");
                }
            }else {
                result.put("data","{[]}");
                result.put("success",false);
                result.put("error","非用户查询 请确认请求");
                logger.warn("非用户查询 请确认请求");
            }
        }catch (Exception e){
            logger.warn("查找用户数据出错, 商城登录出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 插入 购物车单个  用户添加 购物车  productsCode productName salesPrice Number
     * 方式： 1 用户未加入过该商品,
     *       2 用户有该商品 , 改变其原来的数量和价格
     * @param message
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/ecomUserBasket/insertBasket")
    public JSONObject insertEcomUserBasket(@RequestParam Map<String, String>  message, HttpServletRequest request, HttpServletResponse response){
        JSONObject result = new JSONObject();
        result.put("success",false);
        int insertFlag = -1;
        int updateFlag = -1;
        result.put("success",false);
        List<EcomUserBasket> oldBasketList = new ArrayList<EcomUserBasket>();
        try {
            if (null!= message.get("isBasketInsert") && "isBasketInsert".equals(message.get("isBasketInsert"))
                    &&null!= message.get("productsCode") ){
                /* null != request.getSession().getAttribute("userName")*/
                //Long userId = (Long) (request.getSession().getAttribute("userId"));
                EcomUserBasket ecomUserBasket = new EcomUserBasket();
                Long userId = Long.valueOf (message.get("userId"));
                ecomUserBasket.setPortalUserId(userId);
                ecomUserBasket.setProductsCode(message.get("productsCode"));                        //商品编号
                oldBasketList = ecomUserBasketService.selectByBasket(ecomUserBasket);
                /* 校验购物车是否存在该商品*/
                if(oldBasketList.size()>0){//有  修改购物车商品的信息  数量 价格
                     ecomUserBasket = oldBasketList.get(0);
                     ecomUserBasket.setDateAdded(new Date());                                           //修改日期
                     //原来的数量 加上新增的
                     ecomUserBasket.setBasketQuantity(Integer.valueOf(message.get("basketQuantity"))+ecomUserBasket.getBasketQuantity());
                     //原来的价格 加上新增的
                     ecomUserBasket.setFinalPrice(ecomUserBasket.getFinalPrice().add(new BigDecimal(message.get("finalPrice"))).setScale(2,BigDecimal.ROUND_HALF_UP));
                     ecomUserBasket.setShopCode(message.get("shopCode"));    //多门店重新校验一次
                     updateFlag = ecomUserBasketService.updateByPrimaryKeySelective(ecomUserBasket);
                        result.put("data",updateFlag);
                        result.put("basket",ecomUserBasket);
                        if (updateFlag == 1 ){
                            result.put("success",true);
                            result.put("message","修改购物车数据成功");
                            logger.info("修改购物车数据成功");
                        }else {
                            result.put("error", "修改购物车数据失败,请确认用户是否登录和请求正确");
                        }
                }else {//无  新增该商品
                    ecomUserBasket.setProductsModel(message.get("productsUnit"));                      //商品单位
                    ecomUserBasket.setExt1(message.get("categoryId"));                                  //商品分类
                    ecomUserBasket.setBasketQuantity(Integer.valueOf(message.get("basketQuantity")));   //数量
                    ecomUserBasket.setFinalPrice(new BigDecimal(message.get("finalPrice")) );           //最终价格
                    ecomUserBasket.setDateAdded(new Date());                                            //创建日期
                    ecomUserBasket.setShopCode(message.get("shopCode"));                                //店铺代号

                    //判断插入是否成功
                    insertFlag = ecomUserBasketService.insert(ecomUserBasket);
                    result.put("data",insertFlag);
                    result.put("basket",ecomUserBasket);
                    if (insertFlag == 1 ){
                        result.put("success",true);
                        result.put("message","新增购物车数据成功");
                        logger.info("新增购物车数据成功");
                    }else {
                        result.put("error", "新增购物车数据失败,请确认用户是否登录和请求正确");
                    }
                }
            }
        } catch (Exception e){
            logger.warn("新增购物车数据出错");
            e.printStackTrace();
            result.put("error", "新增购物车数据出错,请检查插入数据完整性");
            return  result;
        }
        return result;
    }

    /**
     * 删除单个入库单
     * 传入ID ID
     * @return JSONObject
     */
    @PostMapping(value = "/ecomUserBasket/deleteBasket")
    public JSONObject deleteBasket(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        int deleteFlag = 0;
        result.put("success",false);
        try {
            //判空条件
            if(null!=message.get("isDeleteBasket") && "isDeleteBasket".equals(message.get("isDeleteBasket"))
                && null != message.get("BasketMsg")){

                String basketList = message.get("BasketMsg");
                String detailDataList[] = basketList.split(",");

                for (int i = 0; i<detailDataList.length; i++){
                    ecomUserBasketService.deleteByPrimaryKey(Long.valueOf(detailDataList[i]));
                }
                deleteFlag = 1;
                if (deleteFlag == 1 ){
                    result.put("success",true);
                    result.put("data",deleteFlag);
                    logger.info("删除单个数据成功");
                }else {
                    result.put("error","删除该用户购物车失败");
                }
                result.put("data",deleteFlag);
            } else {
                result.put("error","传入该用户购物车数据无效请检查");
                logger.warn("传入该用户购物车数据无效请检查, 删除失败");
            }
        } catch (Exception e){
            logger.warn("删除单个入库单数数据出错");
            e.printStackTrace();
        }
        return result;
    }






}
