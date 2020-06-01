package com.ss.springbootNewshop.controller.user;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: HelloContrller
 * @User: 邵帅
 * @Date: 2019/12/148:57
 * Version 1.0
 * Description: TODO
 **/

@Controller
public class HelloController {

    @RequestMapping("/Hello")
    public ModelAndView Hello(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("show.html");
        return modelAndView;
    }



    @RequestMapping(value = "/show")
    public String show(){
        return "show";
    }

}
