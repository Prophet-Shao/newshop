package com.ss.springbootNewshop.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.ss.springbootNewshop.bean.crmUser;

import com.ss.springbootNewshop.service.crmUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * @ClassName: RegisterController
 * @User: 邵帅
 * @Date: 2019/12/2622:43
 * Version 1.0
 * Description: TODO
 **/
@RestController
public class RegisterController {

    @Autowired
    private crmUserService crmUserService;

    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @RequestMapping(value = "/register")
    public ModelAndView userRegister(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/register");
        return  modelAndView;
    }

    /**
     * 处理表达提交内容
     * 用户注册 默认普通用户注册
     * @return
     */
    @GetMapping(value = "/doRegister")
    public String doUserRegister(crmUser crmUser){
        String registerInfo = "";
        System.out.println("用户名"+crmUser.getUserName());
        System.out.println("密码"+crmUser.getPassword());
        System.out.println("手机号"+crmUser.getPhone());
        System.out.println("地址"+crmUser.getAddress());
        return "/login";
    }

    /**
     * 处理表达提交内容
     * 用户注册 默认普通用户注册
     * ajax请求测试
     * @return
     */
    @PostMapping(value = "/doRegister")
    public JSONObject setRegister( crmUser crmUser){
        JSONObject result = new JSONObject();
        String insertFlag = "";
        System.out.println("用户名"+crmUser.getUserName());
        System.out.println("密码"+crmUser.getPassword());
        System.out.println("密码"+crmUser.getPhone());
        result.put("success",false);
        result.put("error","");
        result.put("data",crmUser);

        try {
            if ( null!= crmUser){
                crmUser.setUserTypeId((long) 2);
                insertFlag = crmUserService.insertCrmUser(crmUser);
                System.out.println(insertFlag);

                if (insertFlag.equals("1")){
                    result.put("success",true);
                }
                else {
                    result.put("success",false);
                    result.put("error","用户为空 插入用户失败 事件回滚");
                }
            }else{
                result.put("error","用户为空 插入用户失败");
            }
        }catch (Exception e){
            logger.warn("注册新用户失败");
            e.printStackTrace();
        }
        System.out.println(result);
        return result;

    }


}
