package com.ss.springbootNewshop.mapper;

import com.ss.springbootNewshop.bean.crmUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface crmUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(crmUser record);

    int insertSelective(crmUser record);

    crmUser selectByPrimaryKey(Long userId);

    crmUser selectByUserName(String userName);

    crmUser selectByCrmUser(crmUser crmUser);

    List<crmUser> queryUserInfo();

    int updateUser(crmUser crmUser);
}