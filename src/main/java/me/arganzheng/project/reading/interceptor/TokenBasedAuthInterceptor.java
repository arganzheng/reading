package me.arganzheng.project.reading.interceptor;

import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.arganzheng.project.reading.common.WebUser;
import me.arganzheng.project.reading.constants.Constants;
import me.arganzheng.project.reading.exception.InvalidCookieException;
import me.arganzheng.project.reading.model.User;
import me.arganzheng.project.reading.service.UserService;
import me.arganzheng.project.reading.util.HttpServletRequestTool;
import me.arganzheng.project.reading.util.LoginUtils;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TokenBasedAuthInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger    = Logger.getLogger(TokenBasedAuthInterceptor.class);

    @Autowired
    private WebUser             webUser;

    @Autowired
    private UserService         userService;

    @Value(value = "secretKey")
    private String              secretKey;

    private static final String DELIMITER = ":";

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // STEP_1: Authenticaltion
        User user = authentication(request, response);
        if (user != null) {
            webUser.setLoggedIn(true);
            webUser.setUsername(user.getUsername());
        }

        // STEP_2: Authorization
        String uri = HttpServletRequestTool.getRequestURIExcludeContextPath(request);

        // 这种不需要鉴权。这里简单使用url区分，粒度比较大，对URL也有倾入性，后续可以考虑使用anotation支持到handler级别的权限控制。
        if (!uri.startsWith("/my/")) {
            return true;
        }
        // 需要登录和授权控制
        if (user == null) {
            // 无权限，转到权限申请页面
            response.sendRedirect(HttpServletRequestTool.getLoginUrl(request));
            return false;
        } else if (!user.isEnabled()) {
            throw new RuntimeException("user is disabled!");
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

    protected String extractTicketCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if ((cookies == null) || (cookies.length == 0)) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (Constants.TOKEN_COOKIES.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }

        return null;
    }

    /**
     * Decodes the cookie and splits it into a set of token strings using the ":" delimiter.
     * 
     * @param cookieValue the value obtained from the submitted cookie
     * @return the array of tokens.
     * @throws InvalidCookieException if the cookie was not base64 encoded.
     */
    protected String[] decodeCookie(String cookieValue) {
        for (int j = 0; j < cookieValue.length() % 4; j++) {
            cookieValue = cookieValue + "=";
        }

        if (!Base64.isBase64(cookieValue.getBytes())) {
            throw new RuntimeException("Cookie token was not Base64 encoded; value was '" + cookieValue + "'");
        }

        String cookieAsPlainText = new String(Base64.decodeBase64(cookieValue));

        String[] tokens = StringUtils.delimitedListToStringArray(cookieAsPlainText, DELIMITER);

        if ((tokens[0].equalsIgnoreCase("http") || tokens[0].equalsIgnoreCase("https")) && tokens[1].startsWith("//")) {
            // Assume we've accidentally split a URL (OpenID identifier)
            String[] newTokens = new String[tokens.length - 1];
            newTokens[0] = tokens[0] + ":" + tokens[1];
            System.arraycopy(tokens, 2, newTokens, 1, newTokens.length - 1);
            tokens = newTokens;
        }

        return tokens;
    }

    /**
     * Template implementation which locates the Spring Security cookie, decodes it into a delimited array of tokens and
     * submits it to subclasses for processing via the <tt>processAutoLoginCookie</tt> method.
     * <p>
     * The returned username is then used to load the UserDetails object for the user, which in turn is used to create a
     * valid authentication token.
     */
    public final User authentication(HttpServletRequest request, HttpServletResponse response) {
        String ticketCookie = extractTicketCookie(request);

        if (ticketCookie == null) {
            return null;
        }

        logger.debug("ticket cookie detected");

        if (ticketCookie.length() == 0) {
            logger.debug("Cookie was empty");
            LoginUtils.cancelCookie(request, response);
            return null;
        }

        User user = null;

        try {
            String[] cookieTokens = decodeCookie(ticketCookie);
            user = processAutoLoginCookie(cookieTokens, request, response);

            logger.debug("ticket cookie accepted");

            return user;
        } catch (RuntimeException e) {
            logger.error(e.getMessage(), e);
        }

        LoginUtils.cancelCookie(request, response);
        return null;
    }

    protected User processAutoLoginCookie(String[] cookieTokens, HttpServletRequest request,
                                          HttpServletResponse response) {

        if (cookieTokens.length != 3) {
            throw new InvalidCookieException("Cookie token did not contain 3" + " tokens, but contained '"
                                             + Arrays.asList(cookieTokens) + "'");
        }

        long tokenExpiryTime;

        try {
            tokenExpiryTime = new Long(cookieTokens[1]).longValue();
        } catch (NumberFormatException nfe) {
            throw new InvalidCookieException("Cookie token[1] did not contain a valid number (contained '"
                                             + cookieTokens[1] + "')");
        }

        if (isTokenExpired(tokenExpiryTime)) {
            throw new InvalidCookieException("Cookie token[1] has expired (expired on '" + new Date(tokenExpiryTime)
                                             + "'; current time is '" + new Date() + "')");
        }

        // Check the user exists.
        // Defer lookup until after expiry time checked, to possibly avoid expensive database call.
        User user = userService.getByUsername(cookieTokens[0]);

        // Check signature of token matches remaining details.
        // Must do this after user lookup, as we need the DAO-derived password.
        // If efficiency was a major issue, just add in a UserCache implementation,
        // but recall that this method is usually only called once per HttpSession - if the token is valid,
        // it will cause SecurityContextHolder population, whilst if invalid, will cause the cookie to be cancelled.
        String expectedTokenSignature = LoginUtils.makeTokenSignature(tokenExpiryTime, user.getUsername(),
                                                                      user.getPassword(), secretKey);

        if (!expectedTokenSignature.equals(cookieTokens[2])) {
            throw new InvalidCookieException("Cookie token[2] contained signature '" + cookieTokens[2]
                                             + "' but expected '" + expectedTokenSignature + "'");
        }

        return user;
    }

    protected boolean isTokenExpired(long tokenExpiryTime) {
        return tokenExpiryTime < System.currentTimeMillis();
    }

}
