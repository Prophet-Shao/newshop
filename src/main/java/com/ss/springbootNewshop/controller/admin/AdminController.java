package com.ss.springbootNewshop.controller.admin;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: AdminController
 * @User: 邵帅
 * @Date: 2019/12/1921:44
 * Version 1.0
 * Description: TODO
 **/
@Controller("/admin")
@Api(tags = "系统登录验证Api")
public class AdminController {

    /**
     * 无参数登录后台
     * @return
     */
    @RequestMapping("/Index")
    public ModelAndView adminIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * 表单提交请求
     * 进入后台管理界面
     * @return
     */
    @PostMapping("/Login")
    public ModelAndView adminLogin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Admin");
        return modelAndView;
    }

    @RequestMapping(value = "/adminLogin",method = RequestMethod.GET)
    public ModelAndView adminLogin1(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Admin");
        return modelAndView;
    }



}

