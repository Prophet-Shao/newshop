package com.ss.springbootNewshop.bean;

import java.math.BigDecimal;

public class SalesOrderDetail {
    private Long salesOrderDetail;

    private Long number;

    private String invoiceCode;

    private String productsCode;

    private String productsModel;

    private Long categoryId;

    private Long unitId;

    private BigDecimal quantity;

    private BigDecimal price;

    private BigDecimal dicountPrice;

    private BigDecimal money;

    private BigDecimal cost;

    private BigDecimal costTotal;

    private BigDecimal finishedQty;

    private String currentStatus;

    private Integer discount;

    private String memo;

    private String refInvoice;

    private Integer isUserConfirmed;

    private Integer id;

    private String categoryName;

    private String mainPic;

    private String productDesc;

    private BigDecimal salesPrice;

    private String productName;

    private String symbol;

    public Long getSalesOrderDetail() {
        return salesOrderDetail;
    }

    public void setSalesOrderDetail(Long salesOrderDetail) {
        this.salesOrderDetail = salesOrderDetail;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
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

    public BigDecimal getDicountPrice() {
        return dicountPrice;
    }

    public void setDicountPrice(BigDecimal dicountPrice) {
        this.dicountPrice = dicountPrice;
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

    public BigDecimal getFinishedQty() {
        return finishedQty;
    }

    public void setFinishedQty(BigDecimal finishedQty) {
        this.finishedQty = finishedQty;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus == null ? null : currentStatus.trim();
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getRefInvoice() {
        return refInvoice;
    }

    public void setRefInvoice(String refInvoice) {
        this.refInvoice = refInvoice == null ? null : refInvoice.trim();
    }

    public Integer getIsUserConfirmed() {
        return isUserConfirmed;
    }

    public void setIsUserConfirmed(Integer isUserConfirmed) {
        this.isUserConfirmed = isUserConfirmed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


    public String getMainPic() {
        return mainPic;
    }

    public void setMainPic(String mainPic) {
        this.mainPic = mainPic;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    @Override
    public String toString() {
        return "SalesOrderDetail{" +
                "salesOrderDetail=" + salesOrderDetail +
                ", number=" + number +
                ", invoiceCode='" + invoiceCode + '\'' +
                ", productsCode='" + productsCode + '\'' +
                ", productsModel='" + productsModel + '\'' +
                ", categoryId=" + categoryId +
                ", unitId=" + unitId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", dicountPrice=" + dicountPrice +
                ", money=" + money +
                ", cost=" + cost +
                ", costTotal=" + costTotal +
                ", finishedQty=" + finishedQty +
                ", currentStatus='" + currentStatus + '\'' +
                ", discount=" + discount +
                ", memo='" + memo + '\'' +
                ", refInvoice='" + refInvoice + '\'' +
                ", isUserConfirmed=" + isUserConfirmed +
                ", id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", mainPic='" + mainPic + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", salesPrice=" + salesPrice +
                ", productName='" + productName + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}