package com.ss.springbootNewshop.utils;

import com.ss.springbootNewshop.Consts.Consts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: ConstServiceImpl
 * @User: 邵帅
 * @Date: 2020/2/2321:44
 * Version 1.0
 * Description: 公共方法
 **/
@Service
public class ConstServiceImpl implements ConstService {

    private static final Logger logger = LoggerFactory.getLogger(ConstServiceImpl.class);

    @Override
    public String getRandenCode(String prefix) {
        String randenCode = "";
        try {
            if (Consts.StockInPrefix.equals(prefix)){
                randenCode = Consts.StockInPrefix+System.currentTimeMillis();
            }else if (Consts.StockOutPrefix.equals(prefix)){
                randenCode = Consts.StockOutPrefix+System.currentTimeMillis();
            }else if (Consts.SalesOrderPrefix.equals(prefix)){
                randenCode = Consts.SalesOrderPrefix+System.currentTimeMillis();
            }else if (Consts.SalesReturnsPrefix.equals(prefix)){
                randenCode = Consts.SalesReturnsPrefix+System.currentTimeMillis();
            }else if (Consts.StockStockPrefix.equals(prefix)){
                randenCode = Consts.StockStockPrefix+System.currentTimeMillis();
            }else if (Consts.StockStockPrefix.equals(prefix)){
                randenCode = Consts.StockStockPrefix+System.currentTimeMillis();
            }else if(Consts.ProductsPrefix.equals(prefix)){
                randenCode = Consts.ProductsPrefix+System.currentTimeMillis();
            }else {
                randenCode = Consts.UnknownPrefix + System.currentTimeMillis();
            }

        }catch (Exception e){
            e.printStackTrace();
            logger.warn(e.getMessage());
        }
        return randenCode;
    }
}
