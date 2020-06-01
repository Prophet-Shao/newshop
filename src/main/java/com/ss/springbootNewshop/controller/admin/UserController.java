package com.ss.springbootNewshop.controller.admin;


import com.alibaba.fastjson.JSONObject;
import com.ss.springbootNewshop.bean.crmUser;
import com.ss.springbootNewshop.service.crmUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: userController
 * @User: 邵帅
 * @Date: 2019/12/1517:43
 * Version 1.0
 * Description: 进入用户个人页面
 **/

@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private crmUserService crmUserService;

    /**
     * 进入用户个人首页
     * @return
     */
    @RequestMapping("/userIndex")
    public ModelAndView getUserIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userIndex");
        return modelAndView;
    }

    /**
     * 进入用户个人首页
     * @return
     */
    @RequestMapping("/userIndex/detail")
    public ModelAndView getUserDetail(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userDetailInfo");
        return modelAndView;
    }

    /**
     * 进入用户信息界面
     * @return
     */
    @RequestMapping("/userInfo/Index")
    public ModelAndView getUserInfoIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userInfoList");
        return modelAndView;
    }

    /**
     * 进入用户信息界面
     * @return
     */
    @RequestMapping("/userInfo/userPointIndex")
    public ModelAndView getUserPointCharge(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userPointCharge");
        return modelAndView;
    }

    /**
     * 加载用户信息
     * @param isUserInfo
     * @return
     */
    @GetMapping(value = "/userInfo/loadUserInfo",produces = "application/json;charset=UTF-8")
    public String getUserInfoList(String isUserInfo){
        Map<String,Object> userInfoList = new HashMap();
        JSONObject result = new JSONObject();
        result.put("success",false);
        try {
            if (isUserInfo.equals("isUserInfo")){
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
    @PostMapping(value = "/userInfo/loadAllUser")
    public JSONObject getUserInfoList(@RequestParam Map<String,String> message){
        String isSetInfo = message.get("isSetInfo");
        //System.out.println("isSetInfo:"+isSetInfo);
        Map<String,Object> userInfoList = new HashMap();
        JSONObject result = new JSONObject();
        result.put("success",false);
        try {
            if (isSetInfo.equals("isSetInfo")){
                //查询所有用户数据
                List<crmUser> list = crmUserService.queryUserInfo();
                result.put("data",list);
                result.put("success",true);
            }else {
                List<crmUser> list =null;
                result.put("data","{[]}");
                result.put("success",false);
                result.put("error","查询用户失败");
            }

        }catch (Exception e){
            logger.warn("查找用户数据出错");
            e.printStackTrace();
        }
        //logger.info(result.toJSONString());
        return result;
    }

    /**
     * 更新单个用户数据
     * @return
     */
    @PostMapping(value = "/userInfo/updateUser")
    public JSONObject updateUserInfo(crmUser crmUser){
        JSONObject result = new JSONObject();
        result.put("success",false);
        int updateFlag = 0 ;
        try {
            if (null != crmUser && null!= crmUser.getUserId()){
                updateFlag = crmUserService.updateUser(crmUser);

                if (updateFlag == 1){
                    result.put("success",true);
                    crmUser newUser = new crmUser();
                    newUser = crmUserService.selectCrmUserById(crmUser.getUserId());
                    result.put("data",newUser);
                    logger.info("更新用户成功, 用户ID:" + crmUser.getUserId());
                }
            }else {
                result.put("error","用户信息缺失 更新用户信息失败");
            }
        } catch (Exception e){
            logger.warn("更新用户数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     *
     * @return
     */
    @PostMapping(value = "/userInfo/insertUser")
    public JSONObject insertUserInfo(){
        JSONObject result = new JSONObject();
        try {
            crmUser crmUser = new crmUser();
            String insertFlag = crmUserService.insertCrmUser(crmUser);
            result.put("data",insertFlag);
        } catch (Exception e){
            logger.warn("更新用户数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查找单个用户数据
     * 传入ID userName
     * @return JSONObject
     */
    @PostMapping(value = "/userInfo/selectUserByName")
    public JSONObject selectByUserName(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        try {
            String userName = "Admin";
            result.put("data",crmUserService.selectByUserName(userName));
            //result.put("data",crmUserService.selectCrmUserById((long) 4));
            logger.warn("查找单个用户数据成功");
        } catch (Exception e){
            logger.warn("查找单个用户数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除单个用户数据
     * 传入ID userName
     * @return JSONObject
     */
    @PostMapping(value = "/userInfo/deleteUser")
    public JSONObject deleteUser(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        String isDeleteUser = message.get("isDeleteUser");
        long userId = Long.valueOf(message.get("userId"));
        int deleteFlag = 0;
        result.put("success",false);
        try {
            if(null!=message && "isDeleteUser".equals(isDeleteUser)){
                deleteFlag =crmUserService.deleteUserById(userId);
                if (deleteFlag == 1 ){
                    result.put("success",true);
                    logger.info("删除单个用户数据成功");
                }else {
                    result.put("error","删除用户失败");
                }
                result.put("data",deleteFlag);
            } else {
                result.put("error","传入用户数据无效请检查");
                logger.warn("传入用户数据无效请检查, 删除失败");
            }

        } catch (Exception e){
            logger.warn("查找单个用户数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查找单个用户数据
     * 传入ID userName
     * @return JSONObject
     */
    @PostMapping(value = "/userInfo/loadUserIndexInfo")
    public JSONObject loadUserIndexInfo(@RequestParam Map<String,String> message, HttpServletRequest request){
        JSONObject result = new JSONObject();
        result.put("success",false);
        String userName;
        crmUser  crmUser = new crmUser();
        try {
            if(null != request.getSession().getAttribute("userName")
                    && "" != request.getSession().getAttribute("userName")){
                userName = (String) request.getSession().getAttribute("userName");
                crmUser = crmUserService.selectByUserName(userName);
                if(null != crmUser && null != crmUser.getUserName()){
                    request.getSession().setAttribute("userName",crmUser.getUserName());
                    result.put("success",true);
                    result.put("data",crmUser);
                    logger.info("查找单个用户数据成功");
                }else {
                    result.put("error","未查找到该用户,请重新登录");
                }
            }else{
                result.put("error","未查找到该用户,请重新登录");
            }
        } catch (Exception e){
            result.put("error","未查找到该用户,请重新登录");
            logger.warn("查找单个用户数据出错");
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 查找单个用户数据
     * 传入ID userName
     * 修改用户积分  /  用户充值
     * @return JSONObject
     */
    @PostMapping(value = "/userInfo/PointCharge")
    public JSONObject onUserCharge(@RequestParam Map<String,String> message, HttpServletRequest request){
        JSONObject result = new JSONObject();
        result.put("success",false);
        String userName;
        int updateFlag = 0;
        crmUser  crmUser = new crmUser();
        try {
            if(null != request.getSession().getAttribute("userName")
                    && "" != request.getSession().getAttribute("userName")
                    && null!=message.get("userPoint") && 0< Long.valueOf(message.get("userPoint"))){
                userName = (String) request.getSession().getAttribute("userName");
                //获取原来的用户
                crmUser = crmUserService.selectByUserName(userName);
                if(null != crmUser && null != crmUser.getUserName()){
                    request.getSession().setAttribute("userName",crmUser.getUserName());
                    //获取原来用户积分
                    BigDecimal userPoint = new BigDecimal(message.get("userPoint"));
                    BigDecimal newPoint = userPoint.multiply(new BigDecimal(100))
                            .add(new BigDecimal(crmUser.getUserPoint())).setScale(2,BigDecimal.ROUND_HALF_UP);
                    crmUser.setUserPoint(newPoint.toString());//修改用户积分
                    updateFlag = crmUserService.updateUser(crmUser);
                    if (updateFlag == 1){
                        result.put("crmUser",crmUser);
                        result.put("msg","用户充值成功,共充值"+message.get("userPoint")+"元");
                        result.put("success",true);
                        logger.info("修改用户积分成功");
                    }
                }else {
                    result.put("error","未查找到该用户,请重新登录,用户充值积分失败");
                }
            }else{
                result.put("error","未查找到该用户,请重新登录,用户充值积分失败");
            }
        } catch (Exception e){
            result.put("error","用户未登录,请重新登录");
            logger.warn("用户为登录,请重新登录,用户充值积分失败");
            e.printStackTrace();
        }
        return result;
    }





}
