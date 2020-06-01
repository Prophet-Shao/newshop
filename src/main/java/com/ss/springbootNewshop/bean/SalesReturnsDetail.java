package com.ss.springbootNewshop.bean;

import java.math.BigDecimal;

public class SalesReturnsDetail {
    private Long returnsDetailId;

    private Long number;

    private String invoiceCode;

    private String productsCode;

    private String productsModel;

    private String color;

    private String size;

    private Long unitId;

    private BigDecimal quantity;

    private BigDecimal price;

    private BigDecimal discountPrice;

    private BigDecimal money;

    private BigDecimal cost;

    private BigDecimal costTotal;

    private BigDecimal marginTotal;

    private Integer discount;

    private BigDecimal changeQty;

    private BigDecimal finishedQty;

    private Integer isAudit;

    private String sourceNo;

    private Long detailId;

    private Long typeId;

    private String batchNo;

    private String ext1;

    private String ext2;

    private String ext3;

    private String memo;

    private Long accountSetId;

    public Long getReturnsDetailId() {
        return returnsDetailId;
    }

    public void setReturnsDetailId(Long returnsDetailId) {
        this.returnsDetailId = returnsDetailId;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode == null ? null : invoiceCode.trim();
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getCostTotal() {
        return costTotal;
    }

    public void setCostTotal(BigDecimal costTotal) {
        this.costTotal = costTotal;
    }

    public BigDecimal getMarginTotal() {
        return marginTotal;
    }

    public void setMarginTotal(BigDecimal marginTotal) {
        this.marginTotal = marginTotal;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public BigDecimal getChangeQty() {
        return changeQty;
    }

    public void setChangeQty(BigDecimal changeQty) {
        this.changeQty = changeQty;
    }

    public BigDecimal getFinishedQty() {
        return finishedQty;
    }

    public void setFinishedQty(BigDecimal finishedQty) {
        this.finishedQty = finishedQty;
    }

    public Integer getIsAudit() {
        return isAudit;
    }

    public void setIsAudit(Integer isAudit) {
        this.isAudit = isAudit;
    }

    public String getSourceNo() {
        return sourceNo;
    }

    public void setSourceNo(String sourceNo) {
        this.sourceNo = sourceNo == null ? null : sourceNo.trim();
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
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
        return "SalesReturnsDetail{" +
                "returnsDetailId=" + returnsDetailId +
                ", number=" + number +
                ", invoiceCode='" + invoiceCode + '\'' +
                ", productsCode='" + productsCode + '\'' +
                ", productsModel='" + productsModel + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", unitId=" + unitId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", discountPrice=" + discountPrice +
                ", money=" + money +
                ", cost=" + cost +
                ", costTotal=" + costTotal +
                ", marginTotal=" + marginTotal +
                ", discount=" + discount +
                ", changeQty=" + changeQty +
                ", finishedQty=" + finishedQty +
                ", isAudit=" + isAudit +
                ", sourceNo='" + sourceNo + '\'' +
                ", detailId=" + detailId +
                ", typeId=" + typeId +
                ", batchNo='" + batchNo + '\'' +
                ", ext1='" + ext1 + '\'' +
                ", ext2='" + ext2 + '\'' +
                ", ext3='" + ext3 + '\'' +
                ", memo='" + memo + '\'' +
                ", accountSetId=" + accountSetId +
                '}';
    }
}