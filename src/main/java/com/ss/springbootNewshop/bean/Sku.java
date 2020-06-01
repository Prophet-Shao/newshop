package com.ss.springbootNewshop.bean;

import java.math.BigDecimal;

public class Sku {
    private Integer id;

    private Integer productId;

    private String skuName;

    private String skuCode;

    private BigDecimal skuPrice;

    private String skuStock;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName == null ? null : skuName.trim();
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode == null ? null : skuCode.trim();
    }

    public BigDecimal getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(BigDecimal skuPrice) {
        this.skuPrice = skuPrice;
    }

    public String getSkuStock() {
        return skuStock;
    }

    public void setSkuStock(String skuStock) {
        this.skuStock = skuStock == null ? null : skuStock.trim();
    }
}