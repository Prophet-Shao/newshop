package com.ss.springbootNewshop.service.impl;

import com.ss.springbootNewshop.bean.CrmPayType;
import com.ss.springbootNewshop.mapper.CrmPayTypeMapper;
import com.ss.springbootNewshop.service.CrmPayTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: CrmPayTypeServiceImpl
 * @User: 邵帅
 * @Date: 2020/1/3115:34
 * Version 1.0
 * Description: TODO
 **/

@Service
public class CrmPayTypeServiceImpl implements CrmPayTypeService {

    @Autowired
    private CrmPayTypeMapper crmPayTypeMapper;

    @Override
    public int deleteByPrimaryKey(Long payCode) {
        return crmPayTypeMapper.deleteByPrimaryKey(payCode);
    }
    @Transactional
    @Override
    public int insert(CrmPayType record) {
        return crmPayTypeMapper.insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(CrmPayType record) {
        return crmPayTypeMapper.insertSelective(record);
    }

    @Override
    public CrmPayType selectByPrimaryKey(Long payCode) {
       return crmPayTypeMapper.selectByPrimaryKey(payCode);
    }

    @Override
    public CrmPayType selectByName(String payName) {
        return null;
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(CrmPayType record) {
        return crmPayTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(CrmPayType record) {
        return crmPayTypeMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<CrmPayType> queryPayTypeInfo() {
        return crmPayTypeMapper.queryPayTypeInfo();
    }
}
