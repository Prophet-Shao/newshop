package com.ss.springbootNewshop.bean;

import java.math.BigDecimal;

public class StockStockDetail {
    private Long batchStockId;

    private Long number;

    private Long stockId;

    private String batchNo;

    private String stockPosition;

    private BigDecimal batchQuantity;

    private BigDecimal batchCost;

    private BigDecimal batchPrice;

    private String description;

    private Long accountSetId;

    public Long getBatchStockId() {
        return batchStockId;
    }

    public void setBatchStockId(Long batchStockId) {
        this.batchStockId = batchStockId;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    public String getStockPosition() {
        return stockPosition;
    }

    public void setStockPosition(String stockPosition) {
        this.stockPosition = stockPosition == null ? null : stockPosition.trim();
    }

    public BigDecimal getBatchQuantity() {
        return batchQuantity;
    }

    public void setBatchQuantity(BigDecimal batchQuantity) {
        this.batchQuantity = batchQuantity;
    }

    public BigDecimal getBatchCost() {
        return batchCost;
    }

    public void setBatchCost(BigDecimal batchCost) {
        this.batchCost = batchCost;
    }

    public BigDecimal getBatchPrice() {
        return batchPrice;
    }

    public void setBatchPrice(BigDecimal batchPrice) {
        this.batchPrice = batchPrice;
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
        return "StockStockDetail{" +
                "batchStockId=" + batchStockId +
                ", number=" + number +
                ", stockId=" + stockId +
                ", batchNo='" + batchNo + '\'' +
                ", stockPosition='" + stockPosition + '\'' +
                ", batchQuantity=" + batchQuantity +
                ", batchCost=" + batchCost +
                ", batchPrice=" + batchPrice +
                ", description='" + description + '\'' +
                ", accountSetId=" + accountSetId +
                '}';
    }
}