package me.arganzheng.project.reading.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

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
        if (StringUtils.isEmpty(currentLink)) {
            currentLink = "/";
        }
        if (currentLink.equalsIgnoreCase(path)) {
            return true;
        } else {
            return false;
        }
    }
}
