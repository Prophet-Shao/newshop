package com.ss.springbootNewshop.bean;

public class StockStockHouseRight {
    private Long stockPurviewId;

    private Long deptId;

    private String stockhouseCode;

    private String description;

    private Long accountSetId;

    public Long getStockPurviewId() {
        return stockPurviewId;
    }

    public void setStockPurviewId(Long stockPurviewId) {
        this.stockPurviewId = stockPurviewId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getStockhouseCode() {
        return stockhouseCode;
    }

    public void setStockhouseCode(String stockhouseCode) {
        this.stockhouseCode = stockhouseCode == null ? null : stockhouseCode.trim();
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
        return "StockStockHouseRight{" +
                "stockPurviewId=" + stockPurviewId +
                ", deptId=" + deptId +
                ", stockhouseCode='" + stockhouseCode + '\'' +
                ", description='" + description + '\'' +
                ", accountSetId=" + accountSetId +
                '}';
    }
}