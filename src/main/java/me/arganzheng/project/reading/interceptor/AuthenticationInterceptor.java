package me.arganzheng.project.reading.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.arganzheng.project.reading.model.User;
import me.arganzheng.project.reading.service.UserService;
import me.arganzheng.project.reading.util.CookieUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private User user;

	@Autowired
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String userId = CookieUtils
				.getCookieValue(request, CookieUtils.USER_ID);

		user = userService.getUser(userId);

		return true;
	}
}
