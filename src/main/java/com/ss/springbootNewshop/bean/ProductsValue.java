package com.ss.springbootNewshop.bean;

public class ProductsValue {
    private Integer id;

    private Integer valueId;

    private Integer productId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ProductsValue{" +
                "id=" + id +
                ", valueId=" + valueId +
                ", productId=" + productId +
                '}';
    }
}