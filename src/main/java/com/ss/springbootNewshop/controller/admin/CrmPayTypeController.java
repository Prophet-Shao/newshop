package com.ss.springbootNewshop.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ss.springbootNewshop.bean.CrmPayType;
import com.ss.springbootNewshop.bean.crmUser;
import com.ss.springbootNewshop.service.CrmPayTypeService;
import com.ss.springbootNewshop.service.crmUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: CrmPayTypeController
 * @User: 邵帅
 * @Date: 2020/1/3115:31
 * Version 1.0
 * Description: TODO
 **/
@RestController
public class CrmPayTypeController {
    private static final Logger logger = LoggerFactory.getLogger(CrmPayTypeController.class);

    @Autowired
    private crmUserService crmUserService;

    @Autowired
    private  CrmPayTypeService crmPayTypeService;
    /**
     * 进入支付类型配置页面
     * @return
     */
        @RequestMapping("/payType/Index")
    public ModelAndView getUserInfoIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("payTypeList");
        return modelAndView;
    }

    /**
     * 加载支付类型信息
     * @param isPayType
     * @return
     */
    @GetMapping(value = "/payType/loadPayType",produces = "application/json;charset=UTF-8")
    public String getUserInfoList(String isPayType){
        Map<String,Object> userInfoList = new HashMap();
        JSONObject result = new JSONObject();
        result.put("success",false);
        try {
            if (isPayType.equals("isPayType")){
                userInfoList = crmUserService.selectCrmUserList();
                result.put("success",true);
            }else {
                result.put("success",false);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        result.put("data",userInfoList);
        return result.toJSONString();
    }

    /**
     * 获取所有用户数据
     * @param message
     * @return
     */
    @PostMapping(value = "/payType/loadPayType")
    public JSONObject getUserInfoList(@RequestParam Map<String,String> message){
        String isPayType = message.get("isPayType");
        JSONObject result = new JSONObject();
        result.put("success",false);
        try {
            if (isPayType.equals("isPayType")){
                //查询所有支付类型数据
                List<CrmPayType> list = crmPayTypeService.queryPayTypeInfo();
                result.put("data",list);
                result.put("success",true);
            }else {
                result.put("data","{[]}");
                result.put("success",false);
                result.put("error","查询支付类型数据失败");
            }
        }catch (Exception e){
            logger.warn("查找支付类型数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新单个数据
     * @return
     */
    @PostMapping(value = "/payType/updatePayType")
    public JSONObject updateUserInfo(CrmPayType crmPayType){
        JSONObject result = new JSONObject();
        result.put("success",false);
        int updateFlag = 0 ;
        try {
            if (null != crmPayType && null!= crmPayType.getPayCode()){
                updateFlag = crmPayTypeService.updateByPrimaryKeySelective(crmPayType);
                if (updateFlag == 1){
                    result.put("success",true);
                    CrmPayType newType = new CrmPayType();
                    newType = crmPayTypeService.selectByPrimaryKey(crmPayType.getPayCode());
                    result.put("data",newType);
                    logger.info("更新支付类型成功, 支付类型ID:" + crmPayType.getPayCode());
                }
            }else {
                result.put("error","支付类型信息缺失 更新支付类型信息失败");
            }
        } catch (Exception e){
            logger.warn("更新支付类型数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     *
     * @return
     */
    @PostMapping(value = "/payType/insertPayType")
    public JSONObject insertPayType(@RequestParam Map<String, String>  message){

        JSONObject result = new JSONObject();
        JSONObject param = new JSONObject();
        String isPayTypeInsert = message.get("isPayTypeInsert");//message.get("isPayTypeInsert")
        int insertFlag = -1;
        result.put("success",false);
        try {
            if (null!= isPayTypeInsert && null != message.get("data")){
                //接收数据中的实体队列
                JSONArray jsonArray = param.getJSONArray("data");
                /*for (int i = 0; i< jsonArray.size(); i++){
                        JSONObject crmPayTypeData = jsonArray.getJSONObject(i);
                }*/
                CrmPayType crmPayType = new CrmPayType();
                    crmPayType.setPayName( message.get("data"));
                    crmPayType.setCrmPartnerId(Long.valueOf(message.get("partnerId")));
                insertFlag = crmPayTypeService.insert(crmPayType);
                result.put("data",insertFlag);
                if (insertFlag == 1 ){
                    result.put("success",true);
                }else {
                    result.put("error", "插入支付类型失败");
                }
            }
        } catch (Exception e){
            logger.warn("插入用户数据出错");
            e.printStackTrace();
            result.put("error", "插入用户数据出错");
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
    @PostMapping(value = "/payType/selectPayTypeName")
    public JSONObject selectByUserName(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        String userName = "微信支付";
        try {
            userName = "微信支付";
            result.put("data",crmUserService.selectByUserName(userName));
            //result.put("data",crmUserService.selectCrmUserById((long) 4));
            logger.warn("查找单个支付类型数数据成功");
        } catch (Exception e){
            logger.warn("查找单个支付类型数数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除单个支付类型
     * 传入ID userName
     * @return JSONObject
     */
    @PostMapping(value = "/payType/deletePayType")
    public JSONObject deleteUser(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        String isDeletePayType = message.get("isDeletePayType");
        long payCode = Long.valueOf(message.get("payCode"));
        int deleteFlag = 0;
        result.put("success",false);
        try {
            if(null!=message && "isDeletePayType".equals(isDeletePayType)){
                deleteFlag =crmPayTypeService.deleteByPrimaryKey(payCode);
                if (deleteFlag == 1 ){
                    result.put("success",true);
                    //result.put("data",crmPayTypeService.sel)
                    logger.info("删除单个支付类型数据成功");
                }else {
                    result.put("error","删除支付类型数失败");
                }
                result.put("data",deleteFlag);
            } else {
                result.put("error","传入支付类型数数据无效请检查");
                logger.warn("传入支付类型数数据无效请检查, 删除失败");
            }

        } catch (Exception e){
            logger.warn("查找单个支付类型数数据出错");
            e.printStackTrace();
        }
        return result;
    }
}
