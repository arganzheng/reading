package me.arganzheng.project.reading.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.arganzheng.project.reading.exception.UserNotLoggedInException;
import me.arganzheng.project.reading.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private User user;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		if (user == null) {
			throw new UserNotLoggedInException();
		}

		return true;
	}
}
