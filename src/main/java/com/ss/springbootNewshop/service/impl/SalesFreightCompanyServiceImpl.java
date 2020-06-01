package com.ss.springbootNewshop.service.impl;

import com.ss.springbootNewshop.bean.SalesFreightCompany;
import com.ss.springbootNewshop.mapper.SalesFreightCompanyMapper;
import com.ss.springbootNewshop.service.SalesFreightCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: SalesFreightCompanyServiceImpl
 * @User: 邵帅
 * @Date: 2020/2/317:54
 * Version 1.0
 * Description: TODO
 **/

@Service
public class SalesFreightCompanyServiceImpl implements SalesFreightCompanyService {

    @Autowired
    private SalesFreightCompanyMapper salesFreightCompanyMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long freightId) {
        return salesFreightCompanyMapper.deleteByPrimaryKey(freightId);
    }

    @Transactional
    @Override
    public int insert(SalesFreightCompany record) {
        return salesFreightCompanyMapper.insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(SalesFreightCompany record) {
        return salesFreightCompanyMapper.insertSelective(record);
    }

    @Override
    public SalesFreightCompany selectByPrimaryKey(Long freightId) {
        return salesFreightCompanyMapper.selectByPrimaryKey(freightId);
    }

    @Override
    public SalesFreightCompany selectByCompany(String freightCompany) {
        return salesFreightCompanyMapper.selectByCompany(freightCompany);
    }

    @Override
    public List<SalesFreightCompany> querySalesFreightCompany() {
        return salesFreightCompanyMapper.querySalesFreightCompany();
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(SalesFreightCompany record) {
        return salesFreightCompanyMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(SalesFreightCompany record) {
        return salesFreightCompanyMapper.updateByPrimaryKey(record);
    }



}
