package com.ss.springbootNewshop.controller.admin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ss.springbootNewshop.bean.SalesFreightCompany;
import com.ss.springbootNewshop.service.SalesFreightCompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: SalesFreightCompanyController
 * @User: 邵帅
 * @Date: 2020/2/320:19
 * Version 1.0
 * Description: 配送员管理   可用作物流公司配置
 **/

@RestController
public class SalesFreightCompanyController {
    private static final Logger logger = LoggerFactory.getLogger(SalesFreightCompanyController.class);

    @Autowired
    private SalesFreightCompanyService salesFreightCompanyService;

    /**
     * 进入配送员管理配置页面
     * @return
     */
    @RequestMapping("/salesFreightCompany/Index")
    public ModelAndView getUserInfoIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("SalesFreightCompany");
        return modelAndView;
    }

    /**
     * 加载配送员信息
     * @param isSalesFreightCompany
     * @return
     */
    @GetMapping(value = "/salesFreightCompany/loadPayType",produces = "application/json;charset=UTF-8")
    public String getSalesFreightCompanyList(String isSalesFreightCompany){
        JSONObject result = new JSONObject();
        result.put("success",false);
        result.put("data","");
        try {
            if (isSalesFreightCompany.equals("isSalesFreightCompany")){
                List<SalesFreightCompany>  salesFreightCompanyList = salesFreightCompanyService.querySalesFreightCompany();
                result.put("success",true);
                result.put("data",salesFreightCompanyList);
                logger.info("加载数据成功");
            }else {
                result.put("success",false);
                result.put("error","加载所有配送员信息出错");
            }

        }catch (Exception e){
            logger.warn("Get请求 查找配送员数据出错");
            e.printStackTrace();
        }
        return result.toJSONString();
    }

    /**
     * 获取所有数据
     * @param message
     * @return
     */
    @PostMapping(value = "/salesFreightCompany/loadCompany")
    public JSONObject getCompanyInfoList(@RequestParam Map<String,String> message){
        String isCompany = message.get("isCompany");
        JSONObject result = new JSONObject();
        result.put("success",false);
        try {
            if (isCompany.equals("isCompany")){
                //查询所有支付类型数据
                List<SalesFreightCompany>  salesFreightCompanyList = salesFreightCompanyService.querySalesFreightCompany();
                result.put("success",true);
                result.put("data",salesFreightCompanyList);
            }else {
                result.put("data","{[]}");
                result.put("success",false);
                result.put("error","查询配送员数据失败");
            }
        }catch (Exception e){
            logger.warn("查找配送员数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新单个数据
     * @return
     */
    @PostMapping(value = "/salesFreightCompany/updateCompany")
    public JSONObject updateUserInfo(SalesFreightCompany salesFreightCompany){
        JSONObject result = new JSONObject();
        result.put("success",false);
        int updateFlag = 0 ;
        try {
            if (null != salesFreightCompany && null!= salesFreightCompany.getFreightId()){
                updateFlag = salesFreightCompanyService.updateByPrimaryKeySelective(salesFreightCompany);
                if (updateFlag == 1){
                    result.put("success",true);
                    SalesFreightCompany newCompany = new SalesFreightCompany();
                    newCompany = salesFreightCompanyService.selectByPrimaryKey(salesFreightCompany.getFreightId());
                    result.put("data",newCompany);
                    logger.info("更新配送员信息成功, 配送员信息:" + salesFreightCompany.getFreightCompany());
                }
            }else {
                result.put("error","配送员信息缺失 更新配送员信息失败");
            }
        } catch (Exception e){
            logger.warn("更新配送员数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 插入单个数据
     * @return
     */
    @PostMapping(value = "/salesFreightCompany/insertCompany")
    public JSONObject insertCompany(@RequestParam Map<String, String>  message){

        JSONObject result = new JSONObject();
        JSONObject param = new JSONObject();
        String isCompanyInsert = message.get("isCompanyInsert");
        int insertFlag = -1;
        result.put("success",false);
        try {
            if (null!= isCompanyInsert && null != message.get("Company")){
                //接收数据中的实体队列
                //JSONArray jsonArray = result.getJSONArray("Company");
                /*for (int i = 0; i< jsonArray.size(); i++){
                        JSONObject crmPayTypeData = jsonArray.getJSONObject(i);
                }*/
                SalesFreightCompany salesFreightCompany = new SalesFreightCompany();
                    salesFreightCompany.setFreightCompany(message.get("Company"));
                    salesFreightCompany.setFreightPhone(message.get("Phone"));
                    salesFreightCompany.setFreightAddress(message.get("Address"));
                    salesFreightCompany.setAccountSetId(Long.valueOf(message.get("partnerId")));
                insertFlag = salesFreightCompanyService.insert(salesFreightCompany);
                result.put("data",insertFlag);
                if (insertFlag == 1 ){
                    result.put("success",true);
                }else {
                    result.put("error", "新增配送员失败");
                }
            }
        } catch (Exception e){
            logger.warn("新增配送员数据出错");
            e.printStackTrace();
            result.put("error", "新增配送员数据出错");
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
    @PostMapping(value = "/salesFreightCompany/selectPayTypeName")
    public JSONObject selectByCompanyName(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        String CompanyName = "微信支付";
        try {
            CompanyName = message.get("CompanyName");
            CompanyName = "圆通快递";
            result.put("data",salesFreightCompanyService.selectByCompany(CompanyName));
            //result.put("data",crmUserService.selectCrmUserById((long) 4));
            logger.warn("查找单个配送员数数据成功");
        } catch (Exception e){
            logger.warn("查找单个配送员数数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除单个支付类型
     * 传入ID userName
     * @return JSONObject
     */
    @PostMapping(value = "/salesFreightCompany/deleteCompany")
    public JSONObject deleteUser(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        String isDeleteCompany = message.get("isDeleteCompany");
        long freightId = Long.valueOf(message.get("freightId"));
        int deleteFlag = 0;
        result.put("success",false);
        try {
            if(null!=message && "isDeleteCompany".equals(isDeleteCompany)){
                deleteFlag =salesFreightCompanyService.deleteByPrimaryKey(freightId);
                if (deleteFlag == 1 ){
                    result.put("success",true);
                    //result.put("data",crmPayTypeService.sel)
                    logger.info("删除单个配送员数据成功");
                }else {
                    result.put("error","删除配送员数失败");
                }
                result.put("data",deleteFlag);
            } else {
                result.put("error","传入配送员数数据无效请检查");
                logger.warn("传入配送员数据无效请检查, 删除失败");
            }

        } catch (Exception e){
            logger.warn("删除单个配送员数数据出错");
            e.printStackTrace();
        }
        return result;
    }

}
