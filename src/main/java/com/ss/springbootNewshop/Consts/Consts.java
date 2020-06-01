package com.ss.springbootNewshop.Consts;

import sun.swing.plaf.synth.DefaultSynthStyle;

import java.lang.management.LockInfo;

/**
 * @ClassName: Consts
 * @User: 邵帅
 * @Date: 2020/2/2211:10
 * Version 1.0
 * Description: 常量类
 **/

public class Consts {

    // 0 未配送 1 配送中 2 配送成功 3 配送失败 4 取消配送 5 伪删除
    /* 状态控制*/
    /**
     * 未开始
     * 订单状态 库存出入库状态 配送状态 未支付
     */
    public static final String StandCode= "init";

    public static final Long StandNum = Long.valueOf(0);
    /**
     * 进行中
     * 订单状态 库存出入库状态 配送状态  已支付
     */
    public static final String InitCode= "init";

    public static final Long InitNum = Long.valueOf(1);

    /**
     * 已完成
     * 订单状态 库存出入库状态 配送状态 已完成
     */
    public static final String CompleteCode= "Complete";

    public static final Long CompleteNum = Long.valueOf(2);

    /**
     * 失败
     * 订单状态 库存出入库状态 配送状态  支付失败
     */
    public static final String FalseCode= "False";

    public static final Long FalseNum = Long.valueOf(3);

    /**
     * 取消
     * 订单状态 库存出入库状态 配送状态 支付 订单取消
     */
    public static final String CancelCode= "Cancel";

    public static final Long CancelNum = Long.valueOf(4);

    /**
     * 伪删除
     * 订单状态 库存出入库状态 配送状态
     */
    public static final String DeleteCode= "Delete";

    public static final Long DeleteNum = Long.valueOf(5);

    /* 状态控制*/

    /* 库存出入库类型*/
    /**
     * StockInPurchase   采购入库
     * StockInLast       余料入库
     * StockInAllocation 调货入库
     */
    public static final Long StockInPurchase = Long.valueOf(5);
    public static final Long StockInLast = Long.valueOf(6);
    public static final Long StockInAllocation = Long.valueOf(7);

    /**
     * StockOut 直接出库
     * StockOutAllocation 调货出库
     */
    public static final Long StockOut = Long.valueOf(1);
    public static final Long StockOutAllocation = Long.valueOf(2);

    /* 流水号前缀*/
    public static final String StockInPrefix = "IN_";
    public static final String StockOutPrefix = "OU_";

    public static final String SalesOrderPrefix = "SO_";
    public static final String SalesReturnsPrefix = "TH_";

    public static final String StockStockPrefix = "SS_";
    public static final String StockStockHousePrefix = "WH_";

    public static final String ProductsPrefix = "Pro_";

    public static final String UnknownPrefix = "UnKnow_";
}
