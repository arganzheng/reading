package me.arganzheng.project.reading.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpUtils;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.tools.generic.EscapeTool;

/**
 * 方便在Velocity中操作HTTP的Request对象。
 * 
 * @author arganzheng
 * @date 2013-12-14
 */
public class HttpServletRequestTool {

    public static String getLoginUrl(HttpServletRequest request) {
        EscapeTool escape = new EscapeTool();
        String url = HttpServletRequestTool.getRequestURLForRedirect(request, "/user/login");
        if (request.getMethod().equalsIgnoreCase("GET")) {
            url += "?" + "returnUrl=" + escape.url(getRequestURL(request));
        }
        return url;
    }

    /**
     * 获取当前的URL，包括queryString。
     * 
     * @param req
     * @return
     */
    public static String getRequestURL(HttpServletRequest req) {
        StringBuffer sb = HttpUtils.getRequestURL(req);
        if (StringUtils.isNotEmpty(req.getQueryString())) {
            sb.append("?").append(req.getQueryString()).toString();
        }
        return sb.toString();
    }

    public static String getRequestURLForRedirect(HttpServletRequest req, String urlPath) {
        StringBuffer url = new StringBuffer();
        String scheme = req.getScheme();
        int port = req.getServerPort();

        String contextPath = req.getContextPath();

        url.append(scheme); // http, https
        url.append("://");
        url.append(req.getServerName());
        if ((scheme.equals("http") && port != 80) || (scheme.equals("https") && port != 443)) {
            url.append(':');
            url.append(req.getServerPort());
        }
        if (StringUtils.isNotBlank(contextPath)) {
            url.append(contextPath);
        }

        url.append(urlPath);

        return url.toString();
    }

    public static String getRequestURIExcludeContextPath(HttpServletRequest request) {
        return request.getRequestURI().substring(request.getContextPath().length());
    }

    public static boolean isCurrentLink(HttpServletRequest request, String path) {
        String currentLink = getRequestURIExcludeContextPath(request);
        currentLink = normalizePath(currentLink);
        path = normalizePath(path);

        if (currentLink.equalsIgnoreCase(path)) {
            return true;
        } else {
            return false;
        }
    }

    public static String normalizePath(String path) {
        if (StringUtils.isEmpty(path)) {
            return path = "/";
        } else if (!path.equals("/") && path.endsWith("/")) {
            return StringUtils.substringBeforeLast(path, "/");
        }
        return path;
    }
}
