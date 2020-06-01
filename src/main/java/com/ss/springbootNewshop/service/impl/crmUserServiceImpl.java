package com.ss.springbootNewshop.service.impl;

import com.ss.springbootNewshop.bean.crmUser;
import com.ss.springbootNewshop.mapper.crmUserMapper;
import com.ss.springbootNewshop.service.crmUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @ClassName: crmUserServiceImpl
 * @User: 邵帅
 * @Date: 2019/12/3121:34
 * Version 1.0
 * Description: TODO
 **/

@Service
public class crmUserServiceImpl implements crmUserService {
    private static final Logger logger = LoggerFactory.getLogger(crmUserServiceImpl.class);

    @Autowired
    private crmUserMapper crmUserMapper;


    @Override
    public crmUser selectCrmUserById(Long userId) {
        Long flagId =  Long.valueOf(-1);
        crmUser crmUser = new crmUser();
        try {
            crmUser = crmUserMapper.selectByPrimaryKey(userId);
            fiilRelationFields(crmUser);
        }catch (Exception e){
            logger.warn("通过ID查找用户失败:"+userId);
            e.printStackTrace();
        }
        return crmUser;
    }

    @Transactional
    @Override
    public Map<String, Object> selectCrmUserList() throws Exception{
        Map<String,Object> userInfoMap = new HashMap<>();
        crmUser crmUser = new crmUser();  //接收实体
        Long userId = Long.valueOf(1);
        try {
            crmUser = crmUserMapper.selectByPrimaryKey(userId); // 查询对象
            fiilRelationFields(crmUser);
            userInfoMap.put(crmUser.getUserId().toString(),crmUser);
        } catch (Exception e){
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
        return userInfoMap;
    }

    @Transactional
    @Override
    public String insertCrmUser(crmUser user) {
        //crmUser crmUser = new crmUser();  //接收实体
        user.setDescription("test");
        user.setCreateDate(new Date());
        user.setModifiedDate(new Date());
        int insertflag = 0;
        insertflag= crmUserMapper.insert(user);
        String flag= ""+insertflag;
        return flag;
    }

    @Override
    public List<crmUser> queryUserInfo() throws Exception{
        List<crmUser> crmUserList = new ArrayList<crmUser>();
        try {
            crmUserList = crmUserMapper.queryUserInfo();
            if(crmUserList.size()>0){
                for (int i = 0; i<crmUserList.size(); i++){
                    fiilRelationFields(crmUserList.get(i));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
        return  crmUserList;
    }

    @Override
    public crmUser selectByUserName(String userName) throws Exception{
        crmUser crmUser = new crmUser();
        try {
           crmUser = crmUserMapper.selectByUserName(userName);
           if (null != crmUser){
               fiilRelationFields(crmUser);
           }
        } catch (Exception e){
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
        return crmUser;
    }

    @Override
    public crmUser selectByCrmUser(crmUser crmUser) throws Exception{
        crmUser newCrmUser = new crmUser();
        try {
            newCrmUser = crmUserMapper.selectByCrmUser(crmUser);
            if (null != newCrmUser){
                fiilRelationFields(newCrmUser);
            }
        } catch (Exception e){
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
        return newCrmUser;
    }

    @Transactional
    @Override
    public int deleteUserById(Long userId) {
        return crmUserMapper.deleteByPrimaryKey(userId);
    }

    @Transactional
    @Override
    public int updateUser(crmUser crmUser) { return crmUserMapper.updateUser(crmUser); }

    //扩展属性方法
    public void fiilRelationFields(crmUser target) throws Exception{
        try {
            if (target.getJobTitle() != null){
                if (target.getJobTitle().equals("0")){
                    target.setJobTitleName("普通会员");
                } else if (target.getJobTitle().equals("1")){
                    target.setJobTitleName("超级会员");
                } else if (target.getJobTitle().equals("5")){
                    target.setJobTitleName("超级会员VIP");
                }else {
                    target.setJobTitleName("普通会员");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            logger.warn("出库扩展属性错误"+e.getMessage());
        }
    }
}
