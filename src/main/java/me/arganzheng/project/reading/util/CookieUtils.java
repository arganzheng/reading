package me.arganzheng.project.reading.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

public class CookieUtils {

	public static final String LOGIN_TYPE_USER = "0";

	public static final String LOGIN_TYPE_ADMIN = "1";

	public static final String USER_ID = "uid";

	public static final String SESSION_ID = "sid";

	public static String getCookieValueByName(HttpServletRequest request,
			String name) {
		Cookie cookie = getCookieByName(request, name);
		if (cookie != null && StringUtils.isNotBlank(cookie.getValue())) {
			return cookie.getValue();
		}
		else {
			return null;
		}
	}

	public static Cookie getCookieByName(HttpServletRequest request, String name) {
		Map<String, Cookie> cookieMap = ReadCookieMap(request);
		if (cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie) cookieMap.get(name);
			return cookie;
		}
		else {
			return null;
		}
	}

	private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}

	public static void addCookie(HttpServletResponse response, Cookie cookie) {
		cookie.setValue(filterCookieValue(cookie.getValue()));
		response.addCookie(cookie);
	}

	public static String filterCookieValue(String value) {
		if (value != null) {
			value = value.replace("\r", "");
			value = value.replace("\n", "");
			value = value.replace("%0D", "");
			value = value.replace("%0A", "");
			value = value.replace("%0d", "");
			value = value.replace("%0a", "");
		}
		return value;
	}

	public static Cookie getCookie(Cookie[] cookies, String name) {
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (name.equals(c.getName())) {
					return c;
				}
			}
		}
		return null;
	}

	public static String getCookieValue(HttpServletRequest request, String name) {
		Cookie c = getCookie(request.getCookies(), name);
		return c.getValue();
	}
}
