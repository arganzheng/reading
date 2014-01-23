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
    String returnUrl, HttpServletRequest request, HttpServletResponse response, Model model) {
        try {
            userService.addUser(user);
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            model.addAttribute("username", user.getUsername());
            user = null;
            return "signup";
        }

        User authUser = userService.getByUsername(user.getUsername());

        // Simple Hash-Based Token Approach @see
        // http://docs.spring.io/spring-security/site/docs/3.0.x/reference/remember-me.html
        LoginUtils.loginSuccess(request, response, authUser, secretKey);

        String url = StringUtils.isBlank(returnUrl) ? HttpServletRequestTool.getRequestURLForRedirect(request, "/") : returnUrl;
        return "redirect:" + url;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        LoginUtils.cancelCookie(request, response);
        return "redirect:" + HttpServletRequestTool.getRequestURLForRedirect(request, "/");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam
    String username, @RequestParam
    String password, @RequestParam(value = "returnUrl", required = false)
    String returnUrl, HttpServletRequest request, HttpServletResponse response, Model model) {
        User authUser = userService.verifyPassword(username, password);
        // Simple Hash-Based Token Approach @see
        // http://docs.spring.io/spring-security/site/docs/3.0.x/reference/remember-me.html
        if (authUser == null) {
            LoginUtils.loginFail(request, response);
            model.addAttribute("username", username);
            model.addAttribute("failed", true);
            return "login";
        } else {
            LoginUtils.loginSuccess(request, response, authUser, secretKey);

            String url = StringUtils.isBlank(returnUrl) ? HttpServletRequestTool.getRequestURLForRedirect(request, "/") : returnUrl;
            return "redirect:" + url;
        }
    }

}
