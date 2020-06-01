package com.ss.springbootNewshop.bean;

/**
 * @ClassName: UserOrderInfo
 * @User: 邵帅
 * @Date: 2020/4/58:47
 * Version 1.0
 * Description: TODO
 **/
public class UserOrderInfo {

    private Long userId;

    private String init;

    private String paid;

    private String down;

    private String failed;

    private String cancle;

    private String deleted;

    private String deliverid;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getInit() {
        return init;
    }

    public void setInit(String init) {
        this.init = init;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getDown() {
        return down;
    }

    public void setDown(String down) {
        this.down = down;
    }

    public String getFailed() {
        return failed;
    }

    public void setFailed(String failed) {
        this.failed = failed;
    }

    public String getCancle() {
        return cancle;
    }

    public void setCancle(String cancle) {
        this.cancle = cancle;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getDeliverid() {
        return deliverid;
    }

    public void setDeliverid(String deliverid) {
        this.deliverid = deliverid;
    }

    @Override
    public String toString() {
        return "UserOrderInfo{" +
                "userId=" + userId +
                ", init='" + init + '\'' +
                ", paid='" + paid + '\'' +
                ", down='" + down + '\'' +
                ", failed='" + failed + '\'' +
                ", cancle='" + cancle + '\'' +
                ", deleted='" + deleted + '\'' +
                '}';
    }
}
