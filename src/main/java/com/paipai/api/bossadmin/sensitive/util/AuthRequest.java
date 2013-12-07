package com.paipai.api.bossadmin.sensitive.util;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Logger;

import com.paipai.api.bossadmin.sensitive.Auth_PortType;
import com.paipai.api.bossadmin.sensitive.Auth_ServiceLocator;

/**
 * 敏感系统请求对象基类
 * 
 * @author arganzheng
 * @date 2012-10-16
 */
public abstract class AuthRequest {

    protected Logger        logger       = Logger.getLogger(getClass());

    protected Auth_PortType authPortType = null;

    {
        Auth_ServiceLocator authLocator = new Auth_ServiceLocator();
        try {
            authPortType = authLocator.getauthSOAP();
        } catch (ServiceException e) {
            logger.error("getAuthSAOP failed!");
            throw new RuntimeException();
        }
    }

    private Integer         systemId;

    private String          userName;

    private String          sessionKey;

    private String          userUrl;

    private String          userIp;

    private String          localSessionId;

    public abstract AuthResult execute();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String user_name) {
        this.userName = user_name;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer system_id) {
        this.systemId = system_id;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String useUrl) {
        this.userUrl = useUrl;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getLocalSessionId() {
        return localSessionId;
    }

    public void setLocalSessionId(String localSessionId) {
        this.localSessionId = localSessionId;
    }

    @Override
    public String toString() {
        return "AuthRequest [authPortType=" + authPortType + ", systemId=" + systemId + ", userName=" + userName
               + ", sessionKey=" + sessionKey + ", userUrl=" + userUrl + ", userIp=" + userIp + ", localSessionId="
               + localSessionId + "]";
    }

}
