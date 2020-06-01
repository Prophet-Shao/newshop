package com.ss.springbootNewshop.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.ss.springbootNewshop.bean.crmUser;
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
import java.util.Map;

/**
 * @ClassName: ShopLoginController
 * @User: 邵帅
 * @Date: 2020/3/522:55
 * Version 1.0
 * Description: TODO
 **/
@RestController
public class ShopLoginController {
    private static final Logger logger = LoggerFactory.getLogger(ShopLoginController.class);

    @Autowired
    private crmUserService crmUserService;

    /**
     * 进入商品管理配置页面
     * @return
     */
    @RequestMapping("/shop/Login")
    public ModelAndView getShopLogin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ShopLogin");
        return modelAndView;
    }

    @RequestMapping("/shop/Index")
    public ModelAndView getShopIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ShopIndex");
        return modelAndView;
    }

    /**
     * 用户前台登录
     * @param message
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/shop/userLogin")
    public JSONObject getProductsList(@RequestParam Map<String,String> message, HttpServletRequest request, HttpServletResponse response){
        String isUserLogin = "";
        JSONObject result = new JSONObject();
        result.put("success",false);
        try {
            crmUser crmUser = new crmUser();
            if (null!= message.get("isUserLogin") && message.get("isUserLogin").equals("isUserLogin")){
                //查询所有商品数据
                crmUser.setUserName(message.get("userName"));
                crmUser.setPassword(message.get("password"));
                crmUser newUser = new crmUser();
                newUser= crmUserService.selectByCrmUser(crmUser);
                if (null!= newUser.getUserName() && newUser.getUserName().equals(message.get("userName"))){
                    //设置用户登录名
                    request.getSession().setAttribute("userName",crmUser.getUserName());
                    request.getSession().setAttribute("userId",crmUser.getUserId());
                    result.put("success",true);
                    result.put("data",crmUser);
                    logger.info("商店用户查找成功 ");
                }else {
                    result.put("data","{[]}");
                    result.put("success",false);
                    result.put("error","用戶不存在");
                    logger.warn("用戶不存在");
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





}
