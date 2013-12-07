package me.arganzheng.project.reading.common;

/**
 * 用户信息。该信息从敏感权限系统获取。用scope bean注入。这里只能拿到登录相关信息。
 * 
 * @author arganzheng
 */
public class WebUser {

    private String  username;
    private String  sessionKey;
    private String  clientIp;
    private boolean loggedIn;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
