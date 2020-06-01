package com.ss.springbootNewshop.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SalesOrder {
    private Long salesOrderId;

    private String invoiceCode;

    private Long salesTypeId;

    private Long payCode;

    private String payCodeName;

    private Date createdDate;

    private Date modifiedDate;

    private Long createdBy;

    private Long modiifiedBy;

    private String stockhouseCode;

    private String processStatus;

    private String processStatusName;

    private String memo;

    private Long accountSetId;

    private BigDecimal totalMoney;

    private BigDecimal discountTotal;

    private BigDecimal totalPaid;

    private BigDecimal marginTotal;

    private BigDecimal totalCost;

    private BigDecimal totalQty;

    private BigDecimal totalFinishedQty;

    private BigDecimal freight;

    private BigDecimal receivableMoney;

    private Date fullPayTime;

    private Integer isFullPaid;

    private String isFullPaidName;

    private Integer isFullDeliver;

    private Integer isFullDeliverName;

    private Integer isInvoiceDone;

    private String shopCode;

    private Long freightId;

    private BigDecimal returnMoney;

    private BigDecimal returnPoint;

    private Integer orderType;

    private Date finishTime;

    private String userName;

    private String company;

    private String phone;

    private String address;

    private String userPoint;

    private List<SalesOrderDetail> salesOrderDetailList;

    public Long getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(Long salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode == null ? null : invoiceCode.trim();
    }

    public Long getSalesTypeId() {
        return salesTypeId;
    }

    public void setSalesTypeId(Long salesTypeId) {
        this.salesTypeId = salesTypeId;
    }

    public Long getPayCode() {
        return payCode;
    }

    public void setPayCode(Long payCode) {
        this.payCode = payCode;
    }

    public String getPayCodeName() {
        return payCodeName;
    }

    public void setPayCodeName(String payCodeName) {
        this.payCodeName = payCodeName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getModiifiedBy() {
        return modiifiedBy;
    }

    public void setModiifiedBy(Long modiifiedBy) {
        this.modiifiedBy = modiifiedBy;
    }

    public String getStockhouseCode() {
        return stockhouseCode;
    }

    public void setStockhouseCode(String stockhouseCode) {
        this.stockhouseCode = stockhouseCode == null ? null : stockhouseCode.trim();
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus == null ? null : processStatus.trim();
    }

    public String getProcessStatusName() {
        return processStatusName;
    }

    public void setProcessStatusName(String processStatusName) {
        this.processStatusName = processStatusName;
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

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getDiscountTotal() {
        return discountTotal;
    }

    public void setDiscountTotal(BigDecimal discountTotal) {
        this.discountTotal = discountTotal;
    }

    public BigDecimal getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(BigDecimal totalPaid) {
        this.totalPaid = totalPaid;
    }

    public BigDecimal getMarginTotal() {
        return marginTotal;
    }

    public void setMarginTotal(BigDecimal marginTotal) {
        this.marginTotal = marginTotal;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(BigDecimal totalQty) {
        this.totalQty = totalQty;
    }

    public BigDecimal getTotalFinishedQty() {
        return totalFinishedQty;
    }

    public void setTotalFinishedQty(BigDecimal totalFinishedQty) {
        this.totalFinishedQty = totalFinishedQty;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public BigDecimal getReceivableMoney() {
        return receivableMoney;
    }

    public void setReceivableMoney(BigDecimal receivableMoney) {
        this.receivableMoney = receivableMoney;
    }

    public Date getFullPayTime() {
        return fullPayTime;
    }

    public void setFullPayTime(Date fullPayTime) {
        this.fullPayTime = fullPayTime;
    }

    public Integer getIsFullPaid() {
        return isFullPaid;
    }

    public void setIsFullPaid(Integer isFullPaid) {
        this.isFullPaid = isFullPaid;
    }

    public Integer getIsFullDeliver() {
        return isFullDeliver;
    }

    public String getIsFullPaidName() {
        return isFullPaidName;
    }

    public void setIsFullPaidName(String isFullPaidName) {
        this.isFullPaidName = isFullPaidName;
    }

    public void setIsFullDeliver(Integer isFullDeliver) {
        this.isFullDeliver = isFullDeliver;
    }


    public Integer getIsFullDeliverName() {
        return isFullDeliverName;
    }

    public void setIsFullDeliverName(Integer isFullDeliverName) {
        this.isFullDeliverName = isFullDeliverName;
    }

    public Integer getIsInvoiceDone() {
        return isInvoiceDone;
    }

    public void setIsInvoiceDone(Integer isInvoiceDone) {
        this.isInvoiceDone = isInvoiceDone;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode == null ? null : shopCode.trim();
    }

    public Long getFreightId() {
        return freightId;
    }

    public void setFreightId(Long freightId) {
        this.freightId = freightId;
    }

    public BigDecimal getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(BigDecimal returnMoney) {
        this.returnMoney = returnMoney;
    }

    public BigDecimal getReturnPoint() {
        return returnPoint;
    }

    public void setReturnPoint(BigDecimal returnPoint) {
        this.returnPoint = returnPoint;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserPoint() {
        return userPoint;
    }

    public void setUserPoint(String userPoint) {
        this.userPoint = userPoint;
    }

    public List<SalesOrderDetail> getSalesOrderDetailList() {
        return salesOrderDetailList;
    }

    public void setSalesOrderDetailList(List<SalesOrderDetail> salesOrderDetailList) {
        this.salesOrderDetailList = salesOrderDetailList;
    }

    @Override
    public String toString() {
        return "SalesOrder{" +
                "salesOrderId=" + salesOrderId +
                ", invoiceCode='" + invoiceCode + '\'' +
                ", salesTypeId=" + salesTypeId +
                ", payCode=" + payCode +
                ", payCodeName='" + payCodeName + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", createdBy=" + createdBy +
                ", modiifiedBy=" + modiifiedBy +
                ", stockhouseCode='" + stockhouseCode + '\'' +
                ", processStatus='" + processStatus + '\'' +
                ", processStatusName='" + processStatusName + '\'' +
                ", memo='" + memo + '\'' +
                ", accountSetId=" + accountSetId +
                ", totalMoney=" + totalMoney +
                ", discountTotal=" + discountTotal +
                ", totalPaid=" + totalPaid +
                ", marginTotal=" + marginTotal +
                ", totalCost=" + totalCost +
                ", totalQty=" + totalQty +
                ", totalFinishedQty=" + totalFinishedQty +
                ", freight=" + freight +
                ", receivableMoney=" + receivableMoney +
                ", fullPayTime=" + fullPayTime +
                ", isFullPaid=" + isFullPaid +
                ", isFullPaidName='" + isFullPaidName + '\'' +
                ", isFullDeliver=" + isFullDeliver +
                ", isFullDeliverName=" + isFullDeliverName +
                ", isInvoiceDone=" + isInvoiceDone +
                ", shopCode='" + shopCode + '\'' +
                ", freightId=" + freightId +
                ", returnMoney=" + returnMoney +
                ", returnPoint=" + returnPoint +
                ", orderType=" + orderType +
                ", finishTime=" + finishTime +
                ", userName='" + userName + '\'' +
                ", company='" + company + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", userPoint='" + userPoint + '\'' +
                '}';
    }
}