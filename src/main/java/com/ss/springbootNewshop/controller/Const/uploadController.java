package com.ss.springbootNewshop.controller.Const;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.UUID;

/**
 * @ClassName: uploadController
 * @User: 邵帅
 * @Date: 2020/2/1222:34
 * Version 1.0
 * Description: 上传文件和下载
 **/
@RestController
@Api(tags = "上传文件API")
public class uploadController {

    private static final Logger logger = LoggerFactory.getLogger(uploadController.class);

    private static final String ProductsImagePath = "D:\\ideaIU\\workplace\\project\\springboot_newshop\\src\\main\\resources\\static\\Image\\";

    private static final String ShopLogoImagePath = "D:\\ideaIU\\workplace\\project\\springboot_newshop\\src\\main\\resources\\static\\Image\\ShopLogoImage\\";

    private static final String ShopReferenceImagePath = "D:\\ideaIU\\workplace\\project\\springboot_newshop\\src\\main\\resources\\static\\Image\\ShopReference\\";

    @PostMapping("/upload/uploadProductsImg")
    public JSONObject uploadImg(MultipartFile file, HttpSession session,
                                HttpServletRequest request){
        JSONObject result = new JSONObject();
        result.put("success",false);
        String prefix="";
        String dateStr="";
        //保存上传
        OutputStream out = null;
        InputStream fileInput=null;
        if (null!=file){
            try {
                String pathRoot=request.getSession().getServletContext().getRealPath("");
                System.out.println("当前项目所在路径："+pathRoot);

                String originalName = file.getOriginalFilename();
                System.out.println("originalName: " + originalName);

                //随机生成图片名称
                String uuid= UUID.randomUUID().toString().replaceAll("-","");
                System.out.println("文件名称："+uuid);

                //文件后缀名
                prefix=originalName.substring(originalName.lastIndexOf(".")+1);
                System.out.println("prefix: " + prefix);

                 /*BufferedOutputStream outputStream = new BufferedOutputStream(
                         new FileOutputStream(new File(file.getOriginalFilename())));
                 outputStream.write(file.getBytes());
                 outputStream.flush();
                 outputStream.close();*/

                System.out.println(ProductsImagePath+originalName);
                file.transferTo(new File(ProductsImagePath+originalName));

                result.put("src","static/Image/"+originalName);
                result.put("success",true);
            } catch (FileNotFoundException fileException){
                fileException.printStackTrace();
                logger.warn("上传文件失败");
                result.put("errorMessge",fileException.getMessage());
                return result;
            } catch (IOException e){
                e.printStackTrace();
                logger.warn("上传文件失败");
                result.put("errorMessge",e.getMessage());
                return result;
            }
        }else {
            result.put("error","上传文件失败, 文件是空的");
        }
        return result;
    }

    @PostMapping("/upload/uploadEcomShopImg")
    public JSONObject uploadEcomShop(MultipartFile file, HttpSession session,
                                HttpServletRequest request){
        JSONObject result = new JSONObject();
        result.put("success",false);
        String prefix="";
        String dateStr="";
        //保存上传
        OutputStream out = null;
        InputStream fileInput=null;
        if (null!=file){
            try {
                String pathRoot=request.getSession().getServletContext().getRealPath("");
                String originalName = file.getOriginalFilename();
                //随机生成图片名称
                String uuid= UUID.randomUUID().toString().replaceAll("-","");
                //文件后缀名
                prefix=originalName.substring(originalName.lastIndexOf(".")+1);
                file.transferTo(new File(ShopLogoImagePath+originalName));
                result.put("src","static/Image/ShopLogoImage/"+originalName);
                result.put("success",true);
            } catch (FileNotFoundException fileException){
                fileException.printStackTrace();
                logger.warn("上传文件失败");
                result.put("errorMessge",fileException.getMessage());
                return result;
            } catch (IOException e){
                e.printStackTrace();
                logger.warn("上传文件失败");
                result.put("errorMessge",e.getMessage());
                return result;
            }
        }else {
            result.put("error","上传文件失败, 文件是空的");
        }
        return result;
    }

    /**
     * 店铺凭据图片上传
     * @param file
     * @param session
     * @param request
     * @return
     */
    @PostMapping("/upload/uploadEcomShopReferenceImg")
    public JSONObject uploadEcomShopReference(MultipartFile file, HttpSession session,
                                     HttpServletRequest request){
        JSONObject result = new JSONObject();
        result.put("success",false);
        String prefix="";
        String dateStr="";
        //保存上传
        OutputStream out = null;
        InputStream fileInput=null;
        if (null!=file){
            try {
                String pathRoot=request.getSession().getServletContext().getRealPath("");
                String originalName = file.getOriginalFilename();
                //随机生成图片名称
                String uuid= UUID.randomUUID().toString().replaceAll("-","");
                //文件后缀名
                prefix=originalName.substring(originalName.lastIndexOf(".")+1);
                file.transferTo(new File(ShopReferenceImagePath+originalName));
                result.put("src","static/Image/ShopReference/"+originalName);
                result.put("success",true);
            } catch (FileNotFoundException fileException){
                fileException.printStackTrace();
                logger.warn("上传文件失败");
                result.put("errorMessge",fileException.getMessage());
                return result;
            } catch (IOException e){
                e.printStackTrace();
                logger.warn("上传文件失败");
                result.put("errorMessge",e.getMessage());
                return result;
            }
        }else {
            result.put("error","上传文件失败, 文件是空的");
        }
        return result;
    }

}

