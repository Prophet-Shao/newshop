package com.ss.springbootNewshop.bean;

public class StockStockHouse {
    private Long stockhouseId;

    private String stockhouseCode;

    private String stockhouseName;

    private String letter;

    private String filterMaterialType;

    private Long empId;

    private String stockTel;

    private String address;

    private Long areaId;

    private Long defaultPriceType;

    private String memo;

    private String ext1;

    private String ext2;

    private String ext3;

    private Long accountSetId;

    public Long getStockhouseId() {
        return stockhouseId;
    }

    public void setStockhouseId(Long stockhouseId) {
        this.stockhouseId = stockhouseId;
    }

    public String getStockhouseCode() {
        return stockhouseCode;
    }

    public void setStockhouseCode(String stockhouseCode) {
        this.stockhouseCode = stockhouseCode == null ? null : stockhouseCode.trim();
    }

    public String getStockhouseName() {
        return stockhouseName;
    }

    public void setStockhouseName(String stockhouseName) {
        this.stockhouseName = stockhouseName == null ? null : stockhouseName.trim();
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter == null ? null : letter.trim();
    }

    public String getFilterMaterialType() {
        return filterMaterialType;
    }

    public void setFilterMaterialType(String filterMaterialType) {
        this.filterMaterialType = filterMaterialType == null ? null : filterMaterialType.trim();
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getStockTel() {
        return stockTel;
    }

    public void setStockTel(String stockTel) {
        this.stockTel = stockTel == null ? null : stockTel.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getDefaultPriceType() {
        return defaultPriceType;
    }

    public void setDefaultPriceType(Long defaultPriceType) {
        this.defaultPriceType = defaultPriceType;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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

    public Long getAccountSetId() {
        return accountSetId;
    }

    public void setAccountSetId(Long accountSetId) {
        this.accountSetId = accountSetId;
    }

    @Override
    public String toString() {
        return "StockStockHouse{" +
                "stockhouseId=" + stockhouseId +
                ", stockhouseCode='" + stockhouseCode + '\'' +
                ", stockhouseName='" + stockhouseName + '\'' +
                ", letter='" + letter + '\'' +
                ", filterMaterialType='" + filterMaterialType + '\'' +
                ", empId=" + empId +
                ", stockTel='" + stockTel + '\'' +
                ", address='" + address + '\'' +
                ", areaId=" + areaId +
                ", defaultPriceType=" + defaultPriceType +
                ", memo='" + memo + '\'' +
                ", ext1='" + ext1 + '\'' +
                ", ext2='" + ext2 + '\'' +
                ", ext3='" + ext3 + '\'' +
                ", accountSetId=" + accountSetId +
                '}';
    }
}