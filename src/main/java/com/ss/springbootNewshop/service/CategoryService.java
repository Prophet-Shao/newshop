package com.ss.springbootNewshop.service;

import com.ss.springbootNewshop.bean.Category;

import java.util.List;

public interface CategoryService {

    int deleteByPrimaryKey(Long id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Long id);

    Category selectByCategoryName(String categoryName);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    List<Category> queryCategoryInfo();
}
