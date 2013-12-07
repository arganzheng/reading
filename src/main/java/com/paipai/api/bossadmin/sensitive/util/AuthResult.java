package com.paipai.api.bossadmin.sensitive.util;

public class AuthResult {

    private Integer status;

    private String  statusInfo;

    private String  loginUrl;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    @Override
    public String toString() {
        return "AuthResult [status=" + status + ", statusInfo=" + statusInfo + ", loginUrl=" + loginUrl + "]";
    }

}
