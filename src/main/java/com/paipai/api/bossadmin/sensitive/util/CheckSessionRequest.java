package com.paipai.api.bossadmin.sensitive.util;

import java.rmi.RemoteException;

import com.paipai.api.bossadmin.sensitive.Request;
import com.paipai.api.bossadmin.sensitive.Result;

/**
 * checkSessionRequest
 * 
 * @author arganzheng
 * @date 2012-10-16
 */
public class CheckSessionRequest extends AuthRequest {

    private String ticket;

    @Override
    public AuthResult execute() {
        Request req = new Request();

        req.setSystem_id(getSystemId());
        req.setUser_url(getUserUrl());
        req.setUser_ip(getUserIp());
        req.setLocal_session_id(getLocalSessionId());
        req.setUser_name(getUserName());
        req.setAuth_cm_com_session_key(getSessionKey());

        req.setAuth_cm_com_ticket(ticket);
        try {
            Result result = authPortType.checkSession(req);
            if (result == null) {
                return null;
            }

            CheckSessionResult checkSessionResult = new CheckSessionResult();

            checkSessionResult.setStatus(result.getStatus());
            checkSessionResult.setStatusInfo(result.getStatus_info());
            checkSessionResult.setLoginUrl(result.getLogin_url());

            checkSessionResult.setUserName(result.getUser_name());
            checkSessionResult.setSessionKey(result.getAuth_cm_com_session_key());

            return checkSessionResult;
        } catch (RemoteException e) {
            logger.error("checkSession failed!", e);
            return null;
        }
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "CheckSessionRequest [ticket=" + ticket + "]";
    }

}
