package com.ss.springbootNewshop.bean;

import java.math.BigDecimal;
import java.util.Date;

public class EcomUserBasket {
    private Long customersBasketId;

    private Long portalUserId;

    private Long shopProdId;

    private String productsCode;

    private String productsModel;

    private Integer basketQuantity;

    private Date dateAdded;

    private BigDecimal finalPrice;

    private String ext1;

    private String ext2;

    private String ext3;

    private String shopCode;

    private Long accountSetId;

    private String userName;

    private String productName;

    private String productDesc;

    private Integer categoryId;

    private String categoryName;

    private Long unitId;

    private BigDecimal cost;

    private BigDecimal price;

    private BigDecimal salesPrice;

    private BigDecimal agentPrice;

    private String mainPic;

    private String leftPic;

    private String memo;

    private String memo2;

    private String memo3;

    private String symbol;

    public Long getCustomersBasketId() {
        return customersBasketId;
    }

    public void setCustomersBasketId(Long customersBasketId) {
        this.customersBasketId = customersBasketId;
    }

    public Long getPortalUserId() {
        return portalUserId;
    }

    public void setPortalUserId(Long portalUserId) {
        this.portalUserId = portalUserId;
    }

    public Long getShopProdId() {
        return shopProdId;
    }

    public void setShopProdId(Long shopProdId) {
        this.shopProdId = shopProdId;
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

    public Integer getBasketQuantity() {
        return basketQuantity;
    }

    public void setBasketQuantity(Integer basketQuantity) {
        this.basketQuantity = basketQuantity;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
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

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode == null ? null : shopCode.trim();
    }

    public Long getAccountSetId() {
        return accountSetId;
    }

    public void setAccountSetId(Long accountSetId) {
        this.accountSetId = accountSetId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public BigDecimal getAgentPrice() {
        return agentPrice;
    }

    public void setAgentPrice(BigDecimal agentPrice) {
        this.agentPrice = agentPrice;
    }

    public String getMainPic() {
        return mainPic;
    }

    public void setMainPic(String mainPic) {
        this.mainPic = mainPic;
    }

    public String getLeftPic() {
        return leftPic;
    }

    public void setLeftPic(String leftPic) {
        this.leftPic = leftPic;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMemo2() {
        return memo2;
    }

    public void setMemo2(String memo2) {
        this.memo2 = memo2;
    }

    public String getMemo3() {
        return memo3;
    }

    public void setMemo3(String memo3) {
        this.memo3 = memo3;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "EcomUserBasket{" +
                "customersBasketId=" + customersBasketId +
                ", portalUserId=" + portalUserId +
                ", shopProdId=" + shopProdId +
                ", productsCode='" + productsCode + '\'' +
                ", productsModel='" + productsModel + '\'' +
                ", basketQuantity=" + basketQuantity +
                ", dateAdded=" + dateAdded +
                ", finalPrice=" + finalPrice +
                ", ext1='" + ext1 + '\'' +
                ", ext2='" + ext2 + '\'' +
                ", ext3='" + ext3 + '\'' +
                ", shopCode='" + shopCode + '\'' +
                ", accountSetId=" + accountSetId +
                ", userName='" + userName + '\'' +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", categoryId=" + categoryId +
                ", unitId=" + unitId +
                ", cost=" + cost +
                ", price=" + price +
                ", salesPrice=" + salesPrice +
                ", agentPrice=" + agentPrice +
                ", mainPic='" + mainPic + '\'' +
                ", leftPic='" + leftPic + '\'' +
                ", memo='" + memo + '\'' +
                ", memo2='" + memo2 + '\'' +
                ", memo3='" + memo3 + '\'' +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}