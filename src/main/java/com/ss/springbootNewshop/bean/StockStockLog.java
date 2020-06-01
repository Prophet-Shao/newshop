package com.ss.springbootNewshop.bean;

import java.math.BigDecimal;
import java.util.Date;

public class StockStockLog {
    private Long stockLogId;

    private String stockhouseCode;

    private String productsCode;

    private BigDecimal initQuantity;

    private BigDecimal changeIn;

    private BigDecimal changeOut;

    private Date changeTime;

    private String changeType;

    private String changeOrgCode;

    private String description;

    private Long accountSetId;

    public Long getStockLogId() {
        return stockLogId;
    }

    public void setStockLogId(Long stockLogId) {
        this.stockLogId = stockLogId;
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

    public BigDecimal getInitQuantity() {
        return initQuantity;
    }

    public void setInitQuantity(BigDecimal initQuantity) {
        this.initQuantity = initQuantity;
    }

    public BigDecimal getChangeIn() {
        return changeIn;
    }

    public void setChangeIn(BigDecimal changeIn) {
        this.changeIn = changeIn;
    }

    public BigDecimal getChangeOut() {
        return changeOut;
    }

    public void setChangeOut(BigDecimal changeOut) {
        this.changeOut = changeOut;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType == null ? null : changeType.trim();
    }

    public String getChangeOrgCode() {
        return changeOrgCode;
    }

    public void setChangeOrgCode(String changeOrgCode) {
        this.changeOrgCode = changeOrgCode == null ? null : changeOrgCode.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getAccountSetId() {
        return accountSetId;
    }

    public void setAccountSetId(Long accountSetId) {
        this.accountSetId = accountSetId;
    }

    @Override
    public String toString() {
        return "StockStockLog{" +
                "stockLogId=" + stockLogId +
                ", stockhouseCode='" + stockhouseCode + '\'' +
                ", productsCode='" + productsCode + '\'' +
                ", initQuantity=" + initQuantity +
                ", changeIn=" + changeIn +
                ", changeOut=" + changeOut +
                ", changeTime=" + changeTime +
                ", changeType='" + changeType + '\'' +
                ", changeOrgCode='" + changeOrgCode + '\'' +
                ", description='" + description + '\'' +
                ", accountSetId=" + accountSetId +
                '}';
    }
}