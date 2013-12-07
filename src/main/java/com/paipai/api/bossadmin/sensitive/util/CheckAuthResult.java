package com.paipai.api.bossadmin.sensitive.util;

public class CheckAuthResult extends AuthResult {

    private String authApplyUrl;
    private String operationName;

    public String getAuthApplyUrl() {
        return authApplyUrl;
    }

    public void setAuthApplyUrl(String authApplyUrl) {
        this.authApplyUrl = authApplyUrl;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    @Override
    public String toString() {
        return "CheckAuthResult [authApplyUrl=" + authApplyUrl + ", operationName=" + operationName + "]";
    }

}
