package me.arganzheng.project.reading.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/my")
public class MyController {

    @RequestMapping(value = "/account/login", method = RequestMethod.GET)
    public String login() {
        return "index";
    }

    @RequestMapping(value = "/book/share", method = RequestMethod.GET)
    public String sharePage() {
        return "share";
    }
    
    @RequestMapping(value = "/book/share", method = RequestMethod.POST)
    public String share() {
        return "my_books";
    }
}
