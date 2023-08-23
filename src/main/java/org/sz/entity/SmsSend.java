package org.sz.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
@TableName("sms_send")
public class SmsSend extends SmsSendKey {
    private String appid;

    private String mobile;

    private String message;

    private String appendid;

    private String sp;

    private String fixedSp;

    private Date gmtCreate;

    private String clientIp;

    private Byte splitCount;

    private Byte splitCountOk;

    private Byte splitCountFail;

    private Date reportTime;

    private String reportDesc;

    private String rsaMobile;

    private Byte sendStatus;

    // private Date apiTime;



    // public Date getApiTime() {
    // return apiTime;
    // }
    //
    // public void setApiTime(Date apiTime) {
    // this.apiTime = apiTime;
    // }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getAppendid() {
        return appendid;
    }

    public void setAppendid(String appendid) {
        this.appendid = appendid == null ? null : appendid.trim();
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp == null ? null : sp.trim();
    }

    public String getFixedSp() {
        return fixedSp;
    }

    public void setFixedSp(String fixedSp) {
        this.fixedSp = fixedSp == null ? null : fixedSp.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp == null ? null : clientIp.trim();
    }

    public Byte getSplitCount() {
        return splitCount;
    }

    public void setSplitCount(Byte splitCount) {
        this.splitCount = splitCount;
    }

    public Byte getSplitCountOk() {
        return splitCountOk;
    }

    public void setSplitCountOk(Byte splitCountOk) {
        this.splitCountOk = splitCountOk;
    }

    public Byte getSplitCountFail() {
        return splitCountFail;
    }

    public void setSplitCountFail(Byte splitCountFail) {
        this.splitCountFail = splitCountFail;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportDesc() {
        return reportDesc;
    }

    public void setReportDesc(String reportDesc) {
        this.reportDesc = reportDesc == null ? null : reportDesc.trim();
    }

    public String getRsaMobile() {
        return rsaMobile;
    }

    public void setRsaMobile(String rsaMobile) {
        this.rsaMobile = rsaMobile == null ? null : rsaMobile.trim();
    }

    public Byte getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(Byte sendStatus) {
        this.sendStatus = sendStatus;
    }

    @Override
    public String toString() {
        return "SmsSend{" + "appid='" + appid + '\'' + ", mobile='" + mobile + '\'' + ", message='" + message + '\''
            + ", appendid='" + appendid + '\'' + ", sp='" + sp + '\'' + ", fixedSp='" + fixedSp + '\'' + ", gmtCreate="
            + gmtCreate + ", clientIp='" + clientIp + '\'' + ", splitCount=" + splitCount + ", splitCountOk="
            + splitCountOk + ", splitCountFail=" + splitCountFail + ", reportTime=" + reportTime + ", reportDesc='"
            + reportDesc + '\'' + ", rsaMobile='" + rsaMobile + '\'' + ", sendStatus=" + sendStatus + '}';
    }
}