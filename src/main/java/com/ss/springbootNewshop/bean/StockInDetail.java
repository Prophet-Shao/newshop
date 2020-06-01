package com.ss.springbootNewshop.bean;

import java.math.BigDecimal;

public class StockInDetail {
    private Long stocksDetailCode;

    private Long number;

    private String invoiceCode;

    private String productsCode;

    private String productsModel;

    private String color;

    private String size;

    private Long unitId;

    private BigDecimal quantity;

    private BigDecimal price;

    private BigDecimal money;

    private String ext1;

    private String ext2;

    private String ext3;

    private String memo;

    private Long typeId;

    private Integer id;

    private Integer categoryId;

    private String categoryName;

    private BigDecimal salesPrice;

    private String productName;

    private String symbol;

    public Long getStocksDetailCode() {
        return stocksDetailCode;
    }

    public void setStocksDetailCode(Long stocksDetailCode) {
        this.stocksDetailCode = stocksDetailCode;
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

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
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

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

    @Override
    public String toString() {
        return "StockInDetail{" +
                "stocksDetailCode=" + stocksDetailCode +
                ", number=" + number +
                ", invoiceCode='" + invoiceCode + '\'' +
                ", productsCode='" + productsCode + '\'' +
                ", productsModel='" + productsModel + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", unitId=" + unitId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", money=" + money +
                ", ext1='" + ext1 + '\'' +
                ", ext2='" + ext2 + '\'' +
                ", ext3='" + ext3 + '\'' +
                ", memo='" + memo + '\'' +
                ", typeId=" + typeId +
                ", id=" + id +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", salesPrice=" + salesPrice +
                ", productName='" + productName + '\'' +
                '}';
    }
}