package com.ss.springbootNewshop.bean;

import java.math.BigDecimal;
import java.util.Date;

public class SalesReturns {
    private Long salesReturnsId;

    private String invoiceCode;

    private Long returnsTypeId;

    private Long guestCode;

    private Date createdDate;

    private Long createdBy;

    private Date modifiedDate;

    private Long modifiedBy;

    private String stockhouseCode;

    private Long payCode;

    private Long taxRate;

    private String processStatus;

    private BigDecimal totalMoney;

    private BigDecimal totalQty;

    private BigDecimal costTotal;

    private BigDecimal totalPaid;

    private Integer isFullStockIn;

    private Integer isFullPaid;

    public Long getSalesReturnsId() {
        return salesReturnsId;
    }

    public void setSalesReturnsId(Long salesReturnsId) {
        this.salesReturnsId = salesReturnsId;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode == null ? null : invoiceCode.trim();
    }

    public Long getReturnsTypeId() {
        return returnsTypeId;
    }

    public void setReturnsTypeId(Long returnsTypeId) {
        this.returnsTypeId = returnsTypeId;
    }

    public Long getGuestCode() {
        return guestCode;
    }

    public void setGuestCode(Long guestCode) {
        this.guestCode = guestCode;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getStockhouseCode() {
        return stockhouseCode;
    }

    public void setStockhouseCode(String stockhouseCode) {
        this.stockhouseCode = stockhouseCode == null ? null : stockhouseCode.trim();
    }

    public Long getPayCode() {
        return payCode;
    }

    public void setPayCode(Long payCode) {
        this.payCode = payCode;
    }

    public Long getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Long taxRate) {
        this.taxRate = taxRate;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus == null ? null : processStatus.trim();
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(BigDecimal totalQty) {
        this.totalQty = totalQty;
    }

    public BigDecimal getCostTotal() {
        return costTotal;
    }

    public void setCostTotal(BigDecimal costTotal) {
        this.costTotal = costTotal;
    }

    public BigDecimal getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(BigDecimal totalPaid) {
        this.totalPaid = totalPaid;
    }

    public Integer getIsFullStockIn() {
        return isFullStockIn;
    }

    public void setIsFullStockIn(Integer isFullStockIn) {
        this.isFullStockIn = isFullStockIn;
    }

    public Integer getIsFullPaid() {
        return isFullPaid;
    }

    public void setIsFullPaid(Integer isFullPaid) {
        this.isFullPaid = isFullPaid;
    }

    @Override
    public String toString() {
        return "SalesReturnsService{" +
                "salesReturnsId=" + salesReturnsId +
                ", invoiceCode='" + invoiceCode + '\'' +
                ", returnsTypeId=" + returnsTypeId +
                ", guestCode=" + guestCode +
                ", createdDate=" + createdDate +
                ", createdBy=" + createdBy +
                ", modifiedDate=" + modifiedDate +
                ", modifiedBy=" + modifiedBy +
                ", stockhouseCode='" + stockhouseCode + '\'' +
                ", payCode=" + payCode +
                ", taxRate=" + taxRate +
                ", processStatus='" + processStatus + '\'' +
                ", totalMoney=" + totalMoney +
                ", totalQty=" + totalQty +
                ", costTotal=" + costTotal +
                ", totalPaid=" + totalPaid +
                ", isFullStockIn=" + isFullStockIn +
                ", isFullPaid=" + isFullPaid +
                '}';
    }
}