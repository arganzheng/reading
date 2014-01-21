package me.arganzheng.project.reading.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.arganzheng.project.reading.constants.Constants;
import me.arganzheng.project.reading.model.User;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

public class LoginUtils {

    private static final Logger logger    = Logger.getLogger(LoginUtils.class);

    private static final String DELIMITER = ":";

    public static void loginSuccess(HttpServletRequest request, HttpServletResponse response, User user,
                                    String secretKey) {

        String username = user.getUsername();
        String password = user.getPassword();

        // If unable to find a username and password, just abort as TokenBasedRememberMeServices is
        // unable to construct a valid token in this case.
        if (!StringUtils.hasLength(username) || !StringUtils.hasLength(password)) {
            return;
        }

        int tokenLifetime = Constants.TWO_WEEKS_S;
        long expiryTime = System.currentTimeMillis();
        // SEC-949
        expiryTime += 1000L * (tokenLifetime < 0 ? Constants.TWO_WEEKS_S : tokenLifetime);

        String signatureValue = makeTokenSignature(expiryTime, username, password, secretKey);

        setCookie(new String[] { username, Long.toString(expiryTime), signatureValue }, tokenLifetime, request,
                  response);

        if (logger.isDebugEnabled()) {
            logger.debug("Added ticke cookie for user '" + username + "', expiry: '" + new Date(expiryTime) + "'");
        }
    }

    public static void loginFail(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("Interactive login attempt was unsuccessful.");
        cancelCookie(request, response);
    }

    public static String makeTokenSignature(long tokenExpiryTime, String username, String password, String secretKey) {
        String data = username + ":" + tokenExpiryTime + ":" + password + ":" + secretKey;
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No MD5 algorithm available!");
        }

        return new String(Hex.encode(digest.digest(data.getBytes())));
    }

    /**
     * Sets a "cancel cookie" (with maxAge = 0) on the response to disable persistent logins.
     */
    public static void cancelCookie(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("Cancelling cookie");
        Cookie cookie = new Cookie(Constants.TOKEN_COOKIES, null);
        cookie.setMaxAge(0);
        cookie.setPath(getCookiePath(request));

        response.addCookie(cookie);
    }

    /**
     * Sets the cookie on the response. By default a secure cookie will be used if the connection is secure. You can set
     * the {@code useSecureCookie} property to {@code false} to override this. If you set it to {@code true}, the cookie
     * will always be flagged as secure. If Servlet 3.0 is used, the cookie will be marked as HttpOnly.
     * 
     * @param tokens the tokens which will be encoded to make the cookie value.
     * @param maxAge the value passed to {@link Cookie#setMaxAge(int)}
     * @param request the request
     * @param response the response to add the cookie to.
     */
    public static void setCookie(String[] tokens, int maxAge, HttpServletRequest request, HttpServletResponse response) {
        String cookieValue = encodeCookie(tokens);
        Cookie cookie = new Cookie(Constants.TOKEN_COOKIES, cookieValue);
        cookie.setMaxAge(maxAge);
        cookie.setPath(getCookiePath(request));
        cookie.setSecure(request.isSecure());

        response.addCookie(cookie);
    }

    /**
     * Inverse operation of decodeCookie.
     * 
     * @param cookieTokens the tokens to be encoded.
     * @return base64 encoding of the tokens concatenated with the ":" delimiter.
     */
    public static String encodeCookie(String[] cookieTokens) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cookieTokens.length; i++) {
            sb.append(cookieTokens[i]);

            if (i < cookieTokens.length - 1) {
                sb.append(DELIMITER);
            }
        }

        String value = sb.toString();

        sb = new StringBuilder(new String(Base64.encode(value.getBytes())));

        while (sb.charAt(sb.length() - 1) == '=') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    public static String getCookiePath(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        return contextPath.length() > 0 ? contextPath : "/";
    }

    public static void logout(HttpServletRequest request, HttpServletResponse response) {
        LoginUtils.cancelCookie(request, response);
    }
}
