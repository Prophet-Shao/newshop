package com.ss.springbootNewshop.bean;

public class ProductsAttribute {
    private Integer id;

    private Integer productId;

    private Integer attributeId;

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

    public Integer getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    @Override
    public String toString() {
        return "ProductsAttribute{" +
                "id=" + id +
                ", productId=" + productId +
                ", attributeId=" + attributeId +
                '}';
    }
}