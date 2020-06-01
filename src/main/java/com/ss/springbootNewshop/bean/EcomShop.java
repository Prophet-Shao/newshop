package com.ss.springbootNewshop.bean;

import java.math.BigDecimal;

public class EcomShop {
    private Long shopId;

    private String shopCode;

    private String shopName;

    private String contactCompany;

    private String contactPhone;

    private String postCode;

    private String provinceCode;

    private String cityCode;

    private String shopLogo;

    private String gpsX;

    private String gpsY;

    private Long accountSetId;

    private Long deptId;

    private Long empId;

    private String warehouseCode;

    private Long returnRuleId;

    private String memo;

    private BigDecimal unitPrice;

    private String refrence;

    private String refrenceImg;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode == null ? null : shopCode.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getContactCompany() {
        return contactCompany;
    }

    public void setContactCompany(String contactCompany) {
        this.contactCompany = contactCompany == null ? null : contactCompany.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getShopLogo() {
        return shopLogo;
    }

    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo == null ? null : shopLogo.trim();
    }

    public String getGpsX() {
        return gpsX;
    }

    public void setGpsX(String gpsX) {
        this.gpsX = gpsX == null ? null : gpsX.trim();
    }

    public String getGpsY() {
        return gpsY;
    }

    public void setGpsY(String gpsY) {
        this.gpsY = gpsY == null ? null : gpsY.trim();
    }

    public Long getAccountSetId() {
        return accountSetId;
    }

    public void setAccountSetId(Long accountSetId) {
        this.accountSetId = accountSetId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode == null ? null : warehouseCode.trim();
    }

    public Long getReturnRuleId() {
        return returnRuleId;
    }

    public void setReturnRuleId(Long returnRuleId) {
        this.returnRuleId = returnRuleId;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getRefrence() {
        return refrence;
    }

    public void setRefrence(String refrence) {
        this.refrence = refrence == null ? null : refrence.trim();
    }

    public String getRefrenceImg() {
        return refrenceImg;
    }

    public void setRefrenceImg(String refrenceImg) {
        this.refrenceImg = refrenceImg == null ? null : refrenceImg.trim();
    }

    @Override
    public String toString() {
        return "EcomShop{" +
                "shopId=" + shopId +
                ", shopCode='" + shopCode + '\'' +
                ", shopName='" + shopName + '\'' +
                ", contactCompany='" + contactCompany + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", postCode='" + postCode + '\'' +
                ", provinceCode='" + provinceCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", shopLogo='" + shopLogo + '\'' +
                ", gpsX='" + gpsX + '\'' +
                ", gpsY='" + gpsY + '\'' +
                ", accountSetId=" + accountSetId +
                ", deptId=" + deptId +
                ", empId=" + empId +
                ", warehouseCode='" + warehouseCode + '\'' +
                ", returnRuleId=" + returnRuleId +
                ", memo='" + memo + '\'' +
                ", unitPrice=" + unitPrice +
                ", refrence='" + refrence + '\'' +
                ", refrenceImg='" + refrenceImg + '\'' +
                '}';
    }
}