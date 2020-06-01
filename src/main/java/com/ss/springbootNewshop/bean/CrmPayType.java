package com.ss.springbootNewshop.bean;

public class CrmPayType {
    private Long payCode;

    private String payName;

    private String typeId;

    private String bak1;

    private String memo;

    private Long crmPartnerId;

    public Long getPayCode() {
        return payCode;
    }

    public void setPayCode(Long payCode) {
        this.payCode = payCode;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName == null ? null : payName.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getBak1() {
        return bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1 == null ? null : bak1.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Long getCrmPartnerId() {
        return crmPartnerId;
    }

    public void setCrmPartnerId(Long crmPartnerId) {
        this.crmPartnerId = crmPartnerId;
    }

    @Override
    public String toString() {
        return "CrmPayType{" +
                "payCode=" + payCode +
                ", payName='" + payName + '\'' +
                ", typeId='" + typeId + '\'' +
                ", bak1='" + bak1 + '\'' +
                ", memo='" + memo + '\'' +
                ", crmPartnerId=" + crmPartnerId +
                '}';
    }
}