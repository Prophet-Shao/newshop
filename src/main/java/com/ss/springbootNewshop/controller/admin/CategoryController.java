package com.ss.springbootNewshop.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.ss.springbootNewshop.bean.Category;
import com.ss.springbootNewshop.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: CategoryController
 * @User: 邵帅
 * @Date: 2020/2/618:39
 * Version 1.0
 * Description: TODO
 **/

@RestController
public class CategoryController {
    private static final Logger logger = LoggerFactory.getLogger(SalesFreightController.class);

    @Autowired
    private CategoryService categoryService;

    /**
     * 进入配送员管理配置页面
     * @return
     */
    @RequestMapping("/category/Index")
    public ModelAndView getCategoryIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Category");
        return modelAndView;
    }

    /**
     * 加载商品分类信息
     * @param isCategory
     * @return
     */
    @GetMapping(value = "/category/loadCategory",produces = "application/json;charset=UTF-8")
    public String getCategoryList(String isCategory){
        JSONObject result = new JSONObject();
        result.put("success",false);
        result.put("data","");
        try {
            if (isCategory.equals("isCategory")){
                List<Category> categoryList = categoryService.queryCategoryInfo();
                result.put("success",true);
                result.put("data",categoryList);
                logger.info("加载商品分类数据成功");
            }else {
                result.put("success",false);
                result.put("error","加载所有商品分类信息出错");
            }

        }catch (Exception e){
            logger.warn("Get请求 查找商品分类数据出错");
            e.printStackTrace();
        }
        return result.toJSONString();
    }

    /**
     * 获取所有数据
     * @param message
     * @return
     */
    @PostMapping(value = "/category/loadCategory")
    public JSONObject getCategoryList(@RequestParam Map<String,String> message){
        String isCategory = message.get("isCategory");
        JSONObject result = new JSONObject();
        result.put("success",false);
        try {
            if (isCategory.equals("isCategory")){
                //查询所有商品分类数据
                List<Category> categoryList = categoryService.queryCategoryInfo();
                result.put("success",true);
                result.put("data",categoryList);
            }else {
                result.put("data","{[]}");
                result.put("success",false);
                result.put("error","查询商品分类数据失败");
            }
        }catch (Exception e){
            logger.warn("查找商品分类数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新单个数据
     * @return
     */
    @PostMapping(value = "/category/updateCategory")
    public JSONObject updateCategoryInfo(Category category){
        JSONObject result = new JSONObject();
        result.put("success",false);
        int updateFlag = 0 ;
        try {
            if (null != category && null!= category.getId()){
                updateFlag = categoryService.updateByPrimaryKeySelective(category);
                if (updateFlag == 1){
                    result.put("success",true);
                    Category newCategory = new Category();
                    newCategory = categoryService.selectByPrimaryKey(category.getId());
                    result.put("data",newCategory);
                    logger.info("更新商品分类信息成功, 商品分类信息:" + category.getCategoryName());
                }
            }else {
                result.put("error","商品分类信息缺失 更新商品分类信息失败");
            }
        } catch (Exception e){
            logger.warn("更新商品分类数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 插入单个数据
     * 新增商品分类 暂定只有一级分类
     * 通过catagoryId 和商品 关联
     * @return
     */
    @PostMapping(value = "/category/insertCategory")
    public JSONObject insertCategory(@RequestParam Map<String, String>  message){

        JSONObject result = new JSONObject();
        JSONObject param = new JSONObject();
        String isCategoryInsert = message.get("isCategoryInsert");
        int insertFlag = -1;
        result.put("success",false);
        try {
            if (null!= isCategoryInsert && null != message.get("categoryName")){
                //接收数据中的实体队列
                //JSONArray jsonArray = result.getJSONArray("Company");
                /*for (int i = 0; i< jsonArray.size(); i++){
                        JSONObject crmPayTypeData = jsonArray.getJSONObject(i);
                }*/
                Category category  = new Category();
                    category.setCategoryId(Integer.valueOf(message.get("categoryId")) );
                    category.setCategoryName(message.get("categoryName"));
                    category.setPartnerId(Long.valueOf(message.get("partnerId")) );
                    category.setMemo(message.get("memo"));
                    category.setAccountSetId(Long.valueOf(message.get("accountSetId")));
                    category.setSortSum(Long.valueOf(0));   //初始化当前分类有0个商品
                //category.setSortSum(Long.valueOf(message.get("sortSum"))+1);

                insertFlag = categoryService.insert(category);
                result.put("data",insertFlag);
                if (insertFlag == 1 ){
                    result.put("success",true);
                    logger.warn("新增商品分类数据成功"+category.getCategoryName());
                }else {
                    result.put("error", "新增商品分类失败");
                }
            }
        } catch (Exception e){
            logger.warn("新增商品分类数据出错");
            e.printStackTrace();
            result.put("error", "新增商品分类数据出错");
            return  result;
        }
        return result;
    }

    /**
     * 查找单个数据
     * 传入ID
     * 传入商品分类名称
     * @return JSONObject
     */
    @PostMapping(value = "/category/selectCategoryName")
    public JSONObject selectByCompanyName(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        String categoryName = "";
        try {
            categoryName = message.get("categoryName");
            categoryName = "生活用品";
            result.put("data",categoryService.selectByCategoryName(categoryName));
            //result.put("data",crmUserService.selectCrmUserById((long) 4));
            logger.warn("查找单个商品分类数数据成功");
        } catch (Exception e){
            logger.warn("查找单个商品分类数数据出错");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除单个商品分类
     * 传入ID ID
     * @return JSONObject
     */
    @PostMapping(value = "/category/deleteCategory")
    public JSONObject deleteCategory(@RequestParam Map<String,String> message){
        JSONObject result = new JSONObject();
        String isDeleteCategory = message.get("isDeleteCategory");
        long categoryId = Long.valueOf(message.get("categoryId"));
        int deleteFlag = 0;
        result.put("success",false);
        try {
            if(null!=message && "isDeleteCategory".equals(isDeleteCategory)){
                deleteFlag =categoryService.deleteByPrimaryKey(categoryId);
                //伪删除处理
                /*Category category = new Category();
                category = categoryService.selectByPrimaryKey(categoryId);*/
                if (deleteFlag == 1 ){
                    result.put("success",true);
                    //result.put("data",salesFreightService.selectByPrimaryKey(freightId));
                    logger.info("删除单个数据成功");
                }else {
                    result.put("error","删除商品分类数失败");
                }
                result.put("data",deleteFlag);
            } else {
                result.put("error","传入商品分类数数据无效请检查");
                logger.warn("传入商品分类数据无效请检查, 删除失败");
            }

        } catch (Exception e){
            logger.warn("删除单个配送员数数据出错");
            e.printStackTrace();
        }
        return result;
    }
}
