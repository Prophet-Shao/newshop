package com.ss.springbootNewshop.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.ss.springbootNewshop.bean.crmUser;
import com.ss.springbootNewshop.service.crmUserService;
import com.sun.xml.internal.ws.encoding.xml.XMLMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.ValidationEvent;
import java.util.Map;

/**
 * @ClassName: LoginController
 * @User: 邵帅
 * @Date: 2019/12/1512:26
 * Version 1.0
 * Description: TODO
 **/
@RestController
@Api(value = "登录接口" , tags = "登录接口标签" , description = "登录接口详细描述")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    public static final String FAILED = "用户名或密码错误！";

    @Autowired
    private crmUserService crmUserService;


    @ApiOperation(value = "通过ID获取单个文章表", notes = "通过id获取文章信息")
    @RequestMapping("/login")
    public ModelAndView LoginIn(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @ApiOperation(value = "后台系统用户登录接口")

    @ApiImplicitParams
    ({@ApiImplicitParam(name = "username", value = "邵帅", defaultValue = "邵帅"),
      @ApiImplicitParam(name = "passwor", value = "admin123", defaultValue = "admin123 默认最高级权限", required = true)
    })
    @PostMapping("/doLogin")
    public JSONObject doLogin(@RequestParam Map<String, String>  message,  HttpServletRequest request,
                              HttpServletResponse response) {
        JSONObject result = new JSONObject();
        result.put("success",false);
        String url;
        String userIndxUrl = "/userIndex";  //用户个人中心
        String AdminUrl = "/adminLogin";    //后台界面
        String backUrl = "/login";          //返回登录
        /** * 编写Shiro用户验证 */

        /** * 封装用户数据 */
        Subject subject = SecurityUtils.getSubject();
        try {
            crmUser crmUser = new crmUser();
            if(null != message.get("userName") && null != message.get("password")){
                crmUser.setUserName(message.get("userName"));
                crmUser.setPassword(message.get("password"));
                crmUser newUser = new crmUser();
                newUser = crmUserService.selectByCrmUser(crmUser);
                //UsernamePasswordToken token = new UsernamePasswordToken(message.get("userName"),message.get("password"));
                /** * 执行登录方法 */
                try {
                    //subject.login(token);
                    result.put("success",true);
                    result.put("data",newUser);
                    request.getSession().setAttribute("loginUser", newUser.getUserName());
                    request.getSession().setAttribute("username", newUser.getUserName());
                    request.getSession().setAttribute("password", newUser.getPassword());
                    if (newUser.getUserTypeId() == 1 ) {
                        //登录成功，session中加入登录用户名，用于在成功的首页中展示
                        //此处用重定向，会被我们定义的视图解析器解析，寻找对应dashboard.html
                        //response.sendRedirect(AdminUrl);
                        result.put("url",AdminUrl);
                    } else if(newUser.getUserTypeId() == 2 ) {
                        //登录失败,设置失败信息并返回登录页面
                        // map.put("msg", "用户名密码错误");
                        //由于此处不是重定向，所以相当于根据字符串直接去templates下找login.html
                        //所以不能写成返回"/"或者"/index.html",否则会报找不到页面
                        // response.sendRedirect(userIndxUrl);
                        result.put("url",userIndxUrl);
                        //return "redirect:errorAjax.html";
                    }else{
                        //response.sendRedirect(backUrl);
                        result.put("url",backUrl);
                    }
                    //登录成功
                } catch (UnknownAccountException e) {
                    logger.warn(e.getMessage());
                    e.printStackTrace();
                    request.setAttribute("msg","用户名不存在");
                    response.sendRedirect("newshop/login");
                    result.put("msg","用户名不存在");
                    return result;
                    //登录失败
                } catch (IncorrectCredentialsException e) {
                    logger.warn(e.getMessage());
                    e.printStackTrace();
                    request.setAttribute("msg","密码错误");
                    response.sendRedirect("newshop/login");
                    result.put("msg","密码错误");
                    return result;
                    //登录失败
                }
            }
        } catch (Exception e) {
            logger.warn("登录失败");
            e.printStackTrace();
            result.put("msg","登录失败");
            return result;
        }
        return result;
    }

    @RequestMapping(value = "/logOut")
    public String logOut(/*@RequestParam("username") String username,
                         @RequestParam("password") String password,*/
                         Map<String, Object> map, HttpSession session, HttpServletResponse response){
        try {
            if(null!= session.getAttribute("username")){
                session.removeAttribute("username");
            }
            if(null!= session.getAttribute("password")){
                session.removeAttribute("password");
            }
            response.sendRedirect("/newshop/login");
        }catch (Exception e){
            logger.warn("退出失败");
            e.printStackTrace();
        }
        return "您已经登出系统";
    }

    @GetMapping("/doLogin")
    public JSONObject getDoLogin(@RequestParam("username") String username,
                              @RequestParam("password") String password, HttpServletRequest request,
                              HttpServletResponse response) {
        JSONObject result = new JSONObject();
        result.put("success",false);
        String url;
        /** * 编写Shiro用户验证 */
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        /** * 封装用户数据 */
        Subject subject = SecurityUtils.getSubject();
        try {
            if (!StringUtils.isEmpty(username) && "admin".equals(password)) {
                //登录成功，session中加入登录用户名，用于在成功的首页中展示
                request.getSession().setAttribute("loginUser", username);
                request.getSession().setAttribute("username", username);
                //此处用重定向，会被我们定义的视图解析器解析，寻找对应dashboard.html
                url = "/newshop/userIndex";
                /** * 执行登录方法 */
                try {
                    subject.login(token );
                    result.put("success",true);
                    response.sendRedirect(url);
                    //登录成功
                } catch (UnknownAccountException e) {
                    logger.warn(e.getMessage());
                    e.printStackTrace();
                    request.setAttribute("msg","用户名不存在");
                    response.sendRedirect("newshop/login");
                    result.put("msg","用户名不存在");
                    return result;
                    //登录失败
                } catch (IncorrectCredentialsException e) {
                    logger.warn(e.getMessage());
                    e.printStackTrace();
                    request.setAttribute("msg","密码错误");
                    response.sendRedirect("newshop/login");
                    result.put("msg","密码错误");
                    return result;
                    //登录失败
                }
            } else if(!StringUtils.isEmpty(username) && "admin123".equals(password)) {
                //登录失败,设置失败信息并返回登录页面
                // map.put("msg", "用户名密码错误");
                //由于此处不是重定向，所以相当于根据字符串直接去templates下找login.html
                //所以不能写成返回"/"或者"/index.html",否则会报找不到页面
                request.getSession().setAttribute("loginUser", "后台管理员");
                request.getSession().setAttribute("username", username);
                url = "/newshop/adminLogin";
                response.sendRedirect(url);
                //return "redirect:errorAjax.html";
            }else{
                response.sendRedirect("/newshop/login");
            }
        } catch (Exception e) {
            logger.warn("登录失败");
            e.printStackTrace();

        }
        return result;
    }

}
