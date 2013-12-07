package com.paipai.api.bossadmin.sensitive.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 敏感权限系统登录认证
 * 
 * @author arganzheng
 * @date 2012-10-16
 */
public class SimpleSensitiveAuthInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger                      = Logger.getLogger(SimpleSensitiveAuthInterceptor.class);

    // cookie name
    public static final String  AUTH_USER_NAME              = "user_name";
    public static final String  AUTH_SESSION_KEY            = "auth_cm_com_session_key";
    
    // request parameter
    public static final String  AUTH_TICKET                 = "auth_cm_com_ticket";

    // configuration
    private Integer systemId;
    private Integer operationId;
    private String sensitiveResourcesPathPrefix;

    public SimpleSensitiveAuthInterceptor() {
	}

	public SimpleSensitiveAuthInterceptor(Integer systemId, Integer operationId, String sensitiveResourcesPathPrefix) {
		super();
		this.systemId = systemId;
		this.operationId = operationId;
		this.sensitiveResourcesPathPrefix = sensitiveResourcesPathPrefix;
	}

	public Integer getSystemId() {
		return systemId;
	}
	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}
	public Integer getOperationId() {
		return operationId;
	}
	public void setOperationId(Integer operationId) {
		this.operationId = operationId;
	}
	public String getSensitiveResourcesPathPrefix() {
		return sensitiveResourcesPathPrefix;
	}
	public void setSensitiveResourcesPathPrefix(String sensitiveResourcesPathPrefix) {
		this.sensitiveResourcesPathPrefix = sensitiveResourcesPathPrefix;
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!isSensitiveResource(request, handler)){
        	return true;
        }

        CheckSessionRequest checkSessionRequest = buildCheckSessionRequest(request);

        CheckSessionResult checkSessionResult = (CheckSessionResult) checkSessionRequest.execute();

        if (checkSessionResult == null) {
            return false;
        }
        if (checkSessionResult.getStatus() >= 200 && checkSessionResult.getStatus() <= 299) {
            response.sendRedirect(checkSessionResult.getLoginUrl());
            return false;
        }

        if (checkSessionResult.getStatus() == 0) { // success
            // set username and sessionKey to Cookie
            setCookie(response, AUTH_USER_NAME, checkSessionResult.getUserName());
            setCookie(response, AUTH_SESSION_KEY, checkSessionResult.getSessionKey());

            // then checkAuth
            CheckAuthRequest checkAuthRequest = buildCheckAuthRequest(request);
            checkAuthRequest.setUserName(checkSessionResult.getUserName());
            checkAuthRequest.setSessionKey(checkSessionResult.getSessionKey());

            CheckAuthResult checkAuthResult = (CheckAuthResult) checkAuthRequest.execute();
            if (checkAuthResult == null) {
                return false;
            }
            if (checkAuthResult.getStatus() == 0) {
                return true;
            } else {
                logger.debug(checkAuthResult.toString());
                if (checkAuthResult.getStatus() >= 300 && checkAuthResult.getStatus() <= 399) {
                    // 无权限，转到权限申请页面
                    response.sendRedirect(checkAuthResult.getAuthApplyUrl());
                    return false;
                } else if (checkAuthResult.getStatus() >= 200 && checkAuthResult.getStatus() <= 299) {
                    response.sendRedirect(checkAuthResult.getLoginUrl());
                    return false;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    protected boolean isSensitiveResource(HttpServletRequest request, Object handler) {
    	if(sensitiveResourcesPathPrefix == null){
    		return true;
    	}else{
    		String path = StringUtils.join(new String[]{request.getServletPath(), request.getPathInfo()});
    		return path.startsWith(sensitiveResourcesPathPrefix);
    	}
	}

	private CheckAuthRequest buildCheckAuthRequest(HttpServletRequest request) {
        CheckAuthRequest req = new CheckAuthRequest();
        buildAuthRequest(request, req);

        req.setOperationId(operationId);

        return req;
    }

    private CheckSessionRequest buildCheckSessionRequest(HttpServletRequest request) {
        CheckSessionRequest req = new CheckSessionRequest();
        buildAuthRequest(request, req);

        String ticket = request.getParameter(AUTH_TICKET);
        if(StringUtils.isNotBlank(ticket)){
        	req.setTicket(ticket);
        	req.setUserName(null);
        	req.setSessionKey(null);
        }

        return req;
    }

    private void buildAuthRequest(HttpServletRequest request, AuthRequest authRequest) {
        authRequest.setSystemId(systemId);
        authRequest.setUserName(getCookie(request, AUTH_USER_NAME));
        authRequest.setSessionKey(getCookie(request, AUTH_SESSION_KEY));
        authRequest.setUserUrl(request.getRequestURL().toString());
        authRequest.setUserIp(getRealIp(request));
        authRequest.setLocalSessionId(request.getSession().getId());

    }

    public static String getRealIp(HttpServletRequest request) {
        String realIP = request.getHeader("X-Real-IP");

        if (realIP == null) {
            realIP = request.getRemoteAddr();
        }

        return realIP;
    }
    
    private static void setCookie(HttpServletResponse response, String cookieName, String cookieValue){
    	Cookie cookie = new Cookie(cookieName, cookieValue);
    	cookie.setPath("/");
    	response.addCookie(cookie);
    }
    
    private static String getCookie(HttpServletRequest request, String cookieName){
    	if(request.getCookies() == null){
    		return null;
    	}
    	for(Cookie cookie : request.getCookies()){
    		if(StringUtils.equals(cookie.getName(), cookieName)){
    			return cookie.getValue();
    		}
    	}
    	return null;
    }
}
