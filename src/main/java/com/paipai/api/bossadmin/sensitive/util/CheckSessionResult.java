package com.paipai.api.bossadmin.sensitive.util;

public class CheckSessionResult extends AuthResult {

    private String sessionKey;

    private String userName;

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "CheckSessionResult [sessionKey=" + sessionKey + ", userName=" + userName + "]";
    }

}
