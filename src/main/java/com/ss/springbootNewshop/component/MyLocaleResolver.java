package com.ss.springbootNewshop.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @ClassName: MyLocaleResolver
 * @User: 邵帅
 * @Date: 2019/12/1514:59
 * Version 1.0
 * Description: 国际化验证
 **/

public class MyLocaleResolver implements LocaleResolver {



    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取路径中的参数名称, 页面路径中的参数名为 l
        String l = request.getParameter("l");
        //获取用户所在区域的语言
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(l)) {
            String[] split = l.split("_");
            //参数1为区域，参数2为语言
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
