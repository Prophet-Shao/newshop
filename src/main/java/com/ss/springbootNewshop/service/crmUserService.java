package com.ss.springbootNewshop.service;

import com.ss.springbootNewshop.bean.crmUser;

import java.util.List;
import java.util.Map;

public interface crmUserService  {

    crmUser selectCrmUserById (Long userId);

    Map<String,Object> selectCrmUserList () throws Exception;

    String insertCrmUser(crmUser user);

    List<crmUser> queryUserInfo() throws Exception;

    crmUser selectByUserName(String userName) throws Exception;

    crmUser selectByCrmUser(crmUser crmUser) throws Exception;

    int deleteUserById(Long userId);

    int updateUser(crmUser crmUser);
}
