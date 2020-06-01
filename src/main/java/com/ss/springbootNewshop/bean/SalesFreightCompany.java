package com.ss.springbootNewshop.bean;

public class SalesFreightCompany {
    private Long freightId;

    private String freightCompany;

    private String freightPhone;

    private String freightAddress;

    private String freightApi;

    private String memo;

    private String memo2;

    private Long accountSetId;

    public Long getFreightId() {
        return freightId;
    }

    public void setFreightId(Long freightId) {
        this.freightId = freightId;
    }

    public String getFreightCompany() {
        return freightCompany;
    }

    public void setFreightCompany(String freightCompany) {
        this.freightCompany = freightCompany == null ? null : freightCompany.trim();
    }

    public String getFreightPhone() {
        return freightPhone;
    }

    public void setFreightPhone(String freightPhone) {
        this.freightPhone = freightPhone == null ? null : freightPhone.trim();
    }

    public String getFreightAddress() {
        return freightAddress;
    }

    public void setFreightAddress(String freightAddress) {
        this.freightAddress = freightAddress == null ? null : freightAddress.trim();
    }

    public String getFreightApi() {
        return freightApi;
    }

    public void setFreightApi(String freightApi) {
        this.freightApi = freightApi == null ? null : freightApi.trim();
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

    public Long getAccountSetId() {
        return accountSetId;
    }

    public void setAccountSetId(Long accountSetId) {
        this.accountSetId = accountSetId;
    }

    @Override
    public String toString() {
        return "SalesFreightCompany{" +
                "freightId=" + freightId +
                ", freightCompany='" + freightCompany + '\'' +
                ", freightPhone='" + freightPhone + '\'' +
                ", freightAddress='" + freightAddress + '\'' +
                ", freightApi='" + freightApi + '\'' +
                ", memo='" + memo + '\'' +
                ", memo2='" + memo2 + '\'' +
                ", accountSetId=" + accountSetId +
                '}';
    }
}