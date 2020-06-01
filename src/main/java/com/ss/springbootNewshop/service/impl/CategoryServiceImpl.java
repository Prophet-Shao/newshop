package com.ss.springbootNewshop.service.impl;

import com.ss.springbootNewshop.bean.Category;
import com.ss.springbootNewshop.mapper.CategoryMapper;
import com.ss.springbootNewshop.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: CategoryServiceImpl
 * @User: 邵帅
 * @Date: 2020/2/618:26
 * Version 1.0
 * Description: TODO
 **/

@Service
public class CategoryServiceImpl  implements CategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryMapper categoryMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public int insert(Category record) {
        return categoryMapper.insert(record);
    }

    @Transactional
    @Override
    public int insertSelective(Category record) {
        return categoryMapper.insertSelective(record);
    }

    @Override
    public Category selectByPrimaryKey(Long id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public Category selectByCategoryName(String categoryName) {
        return selectByCategoryName(categoryName);
    }

    @Transactional
    @Override
    public int updateByPrimaryKeySelective(Category record) {
        return categoryMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(Category record) {
        return categoryMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Category> queryCategoryInfo() {
        return categoryMapper.queryCategoryInfo();
    }
}
