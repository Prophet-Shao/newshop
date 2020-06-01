package com.ss.springbootNewshop.bean;

import java.math.BigDecimal;

public class StockStock {
    private Long stockId;

    private String stockhouseCode;

    private String productsCode;

    private String productsModel;

    private String color;

    private String size;

    private Long unitId;

    private BigDecimal quantity;

    private BigDecimal stockPrice;

    private BigDecimal stockCost;

    private BigDecimal suguestPrice;

    private Long productsLower;

    private Long productsUpper;

    private String storageTime;

    private String ext1;

    private String ext2;

    private String ext3;

    private String memo;

    private Long accountSetId;

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public String getStockhouseCode() {
        return stockhouseCode;
    }

    public void setStockhouseCode(String stockhouseCode) {
        this.stockhouseCode = stockhouseCode == null ? null : stockhouseCode.trim();
    }

    public String getProductsCode() {
        return productsCode;
    }

    public void setProductsCode(String productsCode) {
        this.productsCode = productsCode == null ? null : productsCode.trim();
    }

    public String getProductsModel() {
        return productsModel;
    }

    public void setProductsModel(String productsModel) {
        this.productsModel = productsModel == null ? null : productsModel.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(BigDecimal stockPrice) {
        this.stockPrice = stockPrice;
    }

    public BigDecimal getStockCost() {
        return stockCost;
    }

    public void setStockCost(BigDecimal stockCost) {
        this.stockCost = stockCost;
    }

    public BigDecimal getSuguestPrice() {
        return suguestPrice;
    }

    public void setSuguestPrice(BigDecimal suguestPrice) {
        this.suguestPrice = suguestPrice;
    }

    public Long getProductsLower() {
        return productsLower;
    }

    public void setProductsLower(Long productsLower) {
        this.productsLower = productsLower;
    }

    public Long getProductsUpper() {
        return productsUpper;
    }

    public void setProductsUpper(Long productsUpper) {
        this.productsUpper = productsUpper;
    }

    public String getStorageTime() {
        return storageTime;
    }

    public void setStorageTime(String storageTime) {
        this.storageTime = storageTime == null ? null : storageTime.trim();
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3 == null ? null : ext3.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Long getAccountSetId() {
        return accountSetId;
    }

    public void setAccountSetId(Long accountSetId) {
        this.accountSetId = accountSetId;
    }

    @Override
    public String toString() {
        return "StockStock{" +
                "stockId=" + stockId +
                ", stockhouseCode='" + stockhouseCode + '\'' +
                ", productsCode='" + productsCode + '\'' +
                ", productsModel='" + productsModel + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", unitId=" + unitId +
                ", quantity=" + quantity +
                ", stockPrice=" + stockPrice +
                ", stockCost=" + stockCost +
                ", suguestPrice=" + suguestPrice +
                ", productsLower=" + productsLower +
                ", productsUpper=" + productsUpper +
                ", storageTime='" + storageTime + '\'' +
                ", ext1='" + ext1 + '\'' +
                ", ext2='" + ext2 + '\'' +
                ", ext3='" + ext3 + '\'' +
                ", memo='" + memo + '\'' +
                ", accountSetId=" + accountSetId +
                '}';
    }
}