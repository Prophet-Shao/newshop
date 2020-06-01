package com.ss.springbootNewshop.bean;

public class SalesFreight {
    private Long salesFreightId;

    private Long contactId;

    private String salesOrderCode;

    private Long freightId;

    private String freightName;

    private Long freightNumber;

    private String freightState;

    private String freightStateEx;

    private Long accountSetId;

    private String orderAddress;

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public Long getSalesFreightId() {
        return salesFreightId;
    }

    public void setSalesFreightId(Long salesFreightId) {
        this.salesFreightId = salesFreightId;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getSalesOrderCode() {
        return salesOrderCode;
    }

    public void setSalesOrderCode(String salesOrderCode) {
        this.salesOrderCode = salesOrderCode == null ? null : salesOrderCode.trim();
    }

    public Long getFreightId() {
        return freightId;
    }

    public void setFreightId(Long freightId) {
        this.freightId = freightId;
    }

    public String getFreightName() {
        return freightName;
    }

    public void setFreightName(String freightName) {
        this.freightName = freightName == null ? null : freightName.trim();
    }

    public Long getFreightNumber() {
        return freightNumber;
    }

    public void setFreightNumber(Long freightNumber) {
        this.freightNumber = freightNumber;
    }

    public String getFreightState() {
        return freightState;
    }

    public void setFreightState(String freightState) {
        this.freightState = freightState == null ? null : freightState.trim();
    }

    public Long getAccountSetId() {
        return accountSetId;
    }

    public void setAccountSetId(Long accountSetId) {
        this.accountSetId = accountSetId;
    }

    public String getFreightStateEx() {
        return freightStateEx;
    }

    public void setFreightStateEx(String freightStateEx) {
        this.freightStateEx = freightStateEx;
    }

    @Override
    public String toString() {
        return "SalesFreight{" +
                "salesFreightId=" + salesFreightId +
                ", contactId=" + contactId +
                ", salesOrderCode='" + salesOrderCode + '\'' +
                ", freightId=" + freightId +
                ", freightName='" + freightName + '\'' +
                ", freightNumber=" + freightNumber +
                ", freightState='" + freightState + '\'' +
                ", freightStateEx='" + freightStateEx + '\'' +
                ", accountSetId=" + accountSetId +
                ", orderAddress='" + orderAddress + '\'' +
                '}';
    }
}