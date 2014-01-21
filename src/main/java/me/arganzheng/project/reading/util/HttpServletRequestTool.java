package me.arganzheng.project.reading.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpUtils;

import org.apache.commons.lang.StringUtils;

/**
 * 方便在Velocity中操作HTTP的Request对象。
 * 
 * @author arganzheng
 * @date 2013-12-14
 */
public class HttpServletRequestTool {

    public static String urlFor(HttpServletRequest request, String path) {
        String contextPath = request.getContextPath();
        path = normalizePath(path);
        return contextPath + path;
    }

    public static String getLoginUrl(HttpServletRequest request) {
        return HttpServletRequestTool.getRequestURLForRedirect(request, "/user/login");
    }

    public static String getCurrentURLForRedirect(HttpServletRequest req) {
        return HttpUtils.getRequestURL(req).toString();
    }

    public static String getRequestURLForRedirect(HttpServletRequest req, String urlPath) {
        StringBuffer url = new StringBuffer();
        String scheme = req.getScheme();
        int port = req.getServerPort();

        url.append(scheme); // http, https
        url.append("://");
        url.append(req.getServerName());
        if ((scheme.equals("http") && port != 80) || (scheme.equals("https") && port != 443)) {
            url.append(':');
            url.append(req.getServerPort());
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
