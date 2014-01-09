package me.arganzheng.project.reading.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

/**
 * 方便在Velocity中操作HTTP的Request对象。
 * 
 * @author arganzheng
 * @date 2013-12-14
 */
public class HttpServletRequestTool {

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
