package com.paipai.api.bossadmin.sensitive.util;

import java.rmi.RemoteException;

import com.paipai.api.bossadmin.sensitive.Request;
import com.paipai.api.bossadmin.sensitive.Result;

/**
 * CheckAuthRequest
 * 
 * @author arganzheng
 * @date 2012-10-16
 */
public class CheckAuthRequest extends AuthRequest {

    private Integer operationId;

    @Override
    public AuthResult execute() {
        Request req = new Request();

        req.setSystem_id(getSystemId());
        req.setUser_url(getUserUrl());
        req.setUser_ip(getUserIp());
        req.setLocal_session_id(getLocalSessionId());
        req.setUser_name(getUserName());
        req.setAuth_cm_com_session_key(getSessionKey());

        req.setOperation_id(operationId);

        try {
            Result result = authPortType.checkAuth(req);
            if (result == null) {
                return null;
            }

            CheckAuthResult checkAuthResult = new CheckAuthResult();

            checkAuthResult.setStatus(result.getStatus());
            checkAuthResult.setStatusInfo(result.getStatus_info());
            checkAuthResult.setLoginUrl(result.getLogin_url());

            checkAuthResult.setAuthApplyUrl(result.getAuth_apply_url());
            checkAuthResult.setOperationName(result.getOperation_name());

            return checkAuthResult;
        } catch (RemoteException e) {
            logger.error("checkAuth failed!", e);
            return null;
        }
    }

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    @Override
    public String toString() {
        return "CheckAuthRequest [operationId=" + operationId + "]";
    }
}
