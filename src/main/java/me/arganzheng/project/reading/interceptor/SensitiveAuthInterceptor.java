package me.arganzheng.project.reading.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.arganzheng.project.reading.common.WebUser;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.paipai.api.bossadmin.sensitive.util.AuthRequest;
import com.paipai.api.bossadmin.sensitive.util.CheckAuthRequest;
import com.paipai.api.bossadmin.sensitive.util.CheckAuthResult;
import com.paipai.api.bossadmin.sensitive.util.CheckSessionRequest;
import com.paipai.api.bossadmin.sensitive.util.CheckSessionResult;

/**
 * 敏感权限系统登录认证
 * 
 * @author arganzheng
 * @date 2013-12-07
 */
public class SensitiveAuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private WebUser             webUser;

    private static final Logger logger                      = Logger.getLogger(SensitiveAuthInterceptor.class);

    public static final String  AUTH_USER_NAME              = "user_name";
    public static final String  AUTH_SESSION_KEY            = "auth_cm_com_session_key";
    public static final String  AUTH_TICKET                 = "auth_cm_com_ticket";
    public static final Integer AUTH_SYSTEM_ID_API_METADATA = 633;
    public static final Integer AUTH_OPERATION_ID_MANAGE    = 2;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // STEP_1: Authenticaltion
        webUser.setUsername(getUserName(request));
        webUser.setSessionKey(getSessionKey(request));

        webUser.setClientIp(getClientIp(request));
        webUser.setLoggedIn(false);

        // STEP_2: Authorization
        // 这种不需要鉴权。这里简单使用url区分，粒度比较大，对URL也有倾入性，后续可以考虑使用anotation支持到handler级别的权限控制。
        if (!request.getServletPath().startsWith("/my/")) {
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
            webUser.setUsername(checkSessionResult.getUserName());
            webUser.setSessionKey(checkSessionResult.getSessionKey());
            webUser.setClientIp(getClientIp(request));

            // set username and sessionKey to Cookie
            setCookie(response, AUTH_USER_NAME, checkSessionResult.getUserName());
            setCookie(response, AUTH_SESSION_KEY, checkSessionResult.getSessionKey());

            // then checkAuth
            CheckAuthRequest checkAuthRequest = buildCheckAuthRequest(request);

            CheckAuthResult checkAuthResult = (CheckAuthResult) checkAuthRequest.execute();
            if (checkAuthResult == null) {
                return false;
            }
            if (checkAuthResult.getStatus() == 0) {
                webUser.setLoggedIn(true);
                return true;
            } else {
                logger.debug(checkAuthResult.toString());
                if (checkAuthResult.getStatus() >= 300 && checkAuthResult.getStatus() <= 399) {
                    // 无权限，转到权限申请页面
                    response.sendRedirect(checkAuthResult.getAuthApplyUrl());
                    webUser.setLoggedIn(true);
                    return false;
                } else if (checkAuthResult.getStatus() >= 200 && checkAuthResult.getStatus() <= 299) {
                    response.sendRedirect(checkAuthResult.getLoginUrl());
                    webUser.setLoggedIn(false);
                    return false;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * put the webUser to model so that view can access it!
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // 注意：@ResponseBody时 modelAndView为空
        if (modelAndView != null && webUser != null && webUser.getUsername() != null) {
            modelAndView.addObject("user", webUser);
        }
    }

    private CheckAuthRequest buildCheckAuthRequest(HttpServletRequest request) {
        CheckAuthRequest req = new CheckAuthRequest();
        buildAuthRequest(request, req);

        req.setOperationId(AUTH_OPERATION_ID_MANAGE);

        return req;
    }

    private CheckSessionRequest buildCheckSessionRequest(HttpServletRequest request) {
        CheckSessionRequest req = new CheckSessionRequest();
        buildAuthRequest(request, req);

        String ticket = request.getParameter(AUTH_TICKET);
        if (StringUtils.isNotBlank(ticket)) {
            req.setTicket(ticket);
            req.setUserName(null);
            req.setSessionKey(null);
        }

        return req;
    }

    private void buildAuthRequest(HttpServletRequest request, AuthRequest authRequest) {
        authRequest.setSystemId(AUTH_SYSTEM_ID_API_METADATA);
        authRequest.setUserName(getUserName(request));
        authRequest.setSessionKey(getSessionKey(request));
        authRequest.setUserUrl(request.getRequestURL().toString());
        authRequest.setUserIp(getRealIp(request));
        authRequest.setLocalSessionId(request.getSession().getId());

    }

    private String getUserName(HttpServletRequest request) {
        return getCookie(request, AUTH_USER_NAME);
    }

    private String getSessionKey(HttpServletRequest request) {
        return getCookie(request, AUTH_SESSION_KEY);
    }

    public static String getRealIp(HttpServletRequest request) {
        String realIP = request.getHeader("X-Real-IP");

        if (realIP == null) {
            realIP = request.getRemoteAddr();
        }

        return realIP;
    }

    private static void setCookie(HttpServletResponse response, String cookieName, String cookieValue) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    private static String getCookie(HttpServletRequest request, String cookieName) {
        if (request.getCookies() == null) {
            return null;
        }
        for (Cookie cookie : request.getCookies()) {
            if (StringUtils.equals(cookie.getName(), cookieName)) {
                return cookie.getValue();
            }
        }
        return null;
    }

    public static String getClientIp(HttpServletRequest request) {
        String realIP = getRealIp(request);
        if (realIP == null) {
            realIP = "127.0.0.1";
        }
        return realIP;
    }

}
