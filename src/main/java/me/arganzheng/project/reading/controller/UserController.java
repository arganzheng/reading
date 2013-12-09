package me.arganzheng.project.reading.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.HashMap;
import java.util.Map;

import me.arganzheng.project.reading.common.RestResponse;
import me.arganzheng.project.reading.exception.UnknownResourceException;
import me.arganzheng.project.reading.model.Account;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    private static Map<String, Account> users = new HashMap<String, Account>();

    static {
        users.put("argan", new Account("Argan Zheng", "arganzheng@gmail.com"));
        users.put("magi", new Account("Magi Forrest", "magiforrest@qq.com"));
    }

    @RequestMapping(value = "/{username}", method = GET)
    @ResponseBody
    public RestResponse<Account> getUser(@PathVariable
    String username) {
        Account user = findUser(username);
        return new RestResponse<Account>(user);
    }

    private Account findUser(String username) throws UnknownResourceException {
        if (!StringUtils.hasText(username)) {
            throw new IllegalArgumentException("Username is required.");
        }

        if (users.containsKey(username)) {
            return users.get(username);
        }

        throw new UnknownResourceException("Unable to find user with username '" + username + "'");
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<Account> addUser(@RequestBody
    Account user) {
        users.put(user.getName(), user);
        RestResponse<Account> resp = new RestResponse<Account>();
        resp.setData(user);
        return resp;
    }

    @RequestMapping(value = "{username}", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<Account> updateUser(@RequestBody
    Account user, @RequestParam("timestamp")
    String timestamp, @RequestParam("noice")
    String noice, @RequestParam("signature")
    String signature) {
        Account thisUser = findUser(user.getName());
        users.put(user.getName(), user);

        return new RestResponse<Account>(thisUser);
    }

}
