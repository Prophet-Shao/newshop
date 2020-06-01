package com.ss.springbootNewshop.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.tomcat.util.descriptor.web.FilterMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: ShiroConfig
 * @User: 邵帅
 * @Date: 2020/4/218:06
 * Version 1.0
 * Description: TODO
 **/
@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加shiro内置过滤器
        /**
         * 可以实现权限相关的拦截器
         * anon: 无需认证(登录)即可访问
         * authc: 必须认证才可以访问
         * user: 如果使用rememberMe的功能才可以访问
         * perms: 该资源必须的到资源权限才可以访问
         * role: 该资源必须得到角色权限才可以访问
         */
        Map <String,String> filterMap = new LinkedHashMap<String, String>();

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        /*filterMap.put("/login","anon");
        filterMap.put("/*","authc");*/

        //修改跳转登录
        shiroFilterFactoryBean.setLoginUrl("login");
        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联 Realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }


    /**
     * 创建Realm
     */
    @Bean(name= "userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
