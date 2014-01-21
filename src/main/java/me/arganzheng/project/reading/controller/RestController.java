package me.arganzheng.project.reading.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.HashMap;
import java.util.Map;

import me.arganzheng.project.reading.common.RestResponse;
import me.arganzheng.project.reading.exception.UnknownResourceException;
import me.arganzheng.project.reading.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest")
public class RestController {

    private static Map<String, User> users = new HashMap<String, User>();

    static {
        users.put("argan", new User("Argan Zheng", "arganzheng@gmail.com"));
        users.put("magi", new User("Magi Forrest", "magiforrest@qq.com"));
    }

    @RequestMapping(value = "/{username}", method = GET)
    @ResponseBody
    public RestResponse<User> getUser(@PathVariable
    String username) {
        User user = findUser(username);
        return new RestResponse<User>(user);
    }

    private User findUser(String username) throws UnknownResourceException {
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
    public RestResponse<User> addUser(@RequestBody
    User user) {
        users.put(user.getUsername(), user);
        RestResponse<User> resp = new RestResponse<User>();
        resp.setData(user);
        return resp;
    }

    @RequestMapping(value = "{username}", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<User> updateUser(@RequestBody
    User user, @RequestParam("timestamp")
    String timestamp, @RequestParam("noice")
    String noice, @RequestParam("signature")
    String signature) {
        User thisUser = findUser(user.getUsername());
        users.put(user.getUsername(), user);

        return new RestResponse<User>(thisUser);
    }

}
