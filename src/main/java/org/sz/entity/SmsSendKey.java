package org.sz.entity;

public class SmsSendKey {
    private String msgid;

    private String md5Mobile;

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid == null ? null : msgid.trim();
    }

    public String getMd5Mobile() {
        return md5Mobile;
    }

    public void setMd5Mobile(String md5Mobile) {
        this.md5Mobile = md5Mobile == null ? null : md5Mobile.trim();
    }

    @Override
    public String toString() {
        return "SmsSendKey{" +
                "msgid='" + msgid + '\'' +
                ", md5Mobile='" + md5Mobile + '\'' +
                '}';
    }
}