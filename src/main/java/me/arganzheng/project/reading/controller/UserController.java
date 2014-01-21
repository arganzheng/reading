package me.arganzheng.project.reading.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.arganzheng.project.reading.model.User;
import me.arganzheng.project.reading.service.UserService;
import me.arganzheng.project.reading.util.HttpServletRequestTool;
import me.arganzheng.project.reading.util.LoginUtils;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Value(value = "secretKey")
    private String      secretKey;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUp() {
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUp(User user, @RequestParam(value = "returnUrl", required = false)
    String returnUrl, HttpServletRequest request, HttpServletResponse response) {
        userService.addUser(user);
        User authUser = userService.getByUsername(user.getUsername());

        // Simple Hash-Based Token Approach @see
        // http://docs.spring.io/spring-security/site/docs/3.0.x/reference/remember-me.html
        LoginUtils.loginSuccess(request, response, authUser, secretKey);

        String url = StringUtils.isBlank(returnUrl) ? HttpServletRequestTool.urlFor(request, "/") : returnUrl;
        return "redirect:" + url;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, @RequestParam(value = "returnUrl", required = false)
    String returnUrl, HttpServletRequest request, HttpServletResponse response, Model model) {
        User authUser = userService.verifyPassword(user.getUsername(), user.getPassword());
        // Simple Hash-Based Token Approach @see
        // http://docs.spring.io/spring-security/site/docs/3.0.x/reference/remember-me.html
        if (authUser == null) {
            LoginUtils.loginFail(request, response);
            return "redirect:" + HttpServletRequestTool.getLoginUrl(request);
        } else {
            LoginUtils.loginSuccess(request, response, authUser, secretKey);

            String url = StringUtils.isBlank(returnUrl) ? HttpServletRequestTool.urlFor(request, "/") : returnUrl;
            return "redirect:" + url;
        }
    }

}
