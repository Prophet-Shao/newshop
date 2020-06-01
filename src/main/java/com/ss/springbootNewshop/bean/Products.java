package com.ss.springbootNewshop.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Products {
    private Integer id;

    private Integer productId;

    private String productName;

    private String productDesc;

    private Integer categoryId;

    private String categoryName;

    private Date createdTime;

    private Long unitId;

    private String symbol;

    private BigDecimal quantity;

    private String color;

    private Long size;

    private BigDecimal cost;

    private BigDecimal price;

    private BigDecimal salesPrice;

    private BigDecimal agentPrice;

    private String mainPic;

    private String leftPic;

    private String memo;

    private String memo2;

    private String memo3;

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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc == null ? null : productDesc.trim();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
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
        this.mainPic = mainPic == null ? null : mainPic.trim();
    }

    public String getLeftPic() {
        return leftPic;
    }

    public void setLeftPic(String leftPic) {
        this.leftPic = leftPic == null ? null : leftPic.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getMemo2() {
        return memo2;
    }

    public void setMemo2(String memo2) {
        this.memo2 = memo2 == null ? null : memo2.trim();
    }

    public String getMemo3() {
        return memo3;
    }

    public void setMemo3(String memo3) {
        this.memo3 = memo3 == null ? null : memo3.trim();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", createdTime=" + createdTime +
                ", unitId=" + unitId +
                ", symbol='" + symbol + '\'' +
                ", quantity=" + quantity +
                ", color='" + color + '\'' +
                ", size=" + size +
                ", cost=" + cost +
                ", price=" + price +
                ", salesPrice=" + salesPrice +
                ", agentPrice=" + agentPrice +
                ", mainPic='" + mainPic + '\'' +
                ", leftPic='" + leftPic + '\'' +
                ", memo='" + memo + '\'' +
                ", memo2='" + memo2 + '\'' +
                ", memo3='" + memo3 + '\'' +
                '}';
    }
}