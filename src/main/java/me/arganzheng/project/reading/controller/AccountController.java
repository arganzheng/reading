package me.arganzheng.project.reading.controller;

import javax.validation.Valid;

import me.arganzheng.project.reading.form.UserRegistrationForm;
import me.arganzheng.project.reading.model.User;
import me.arganzheng.project.reading.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signUp() {
        return new ModelAndView("account/signup", "userRegistrationForm", new UserRegistrationForm());
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUp(@ModelAttribute("userRegistrationForm")
    @Valid
    UserRegistrationForm userRegistrationForm, BindingResult result) {
        if (result.hasErrors()) {
            return "account/signup";
        }

        User user = populateUser(userRegistrationForm);
        userService.addUser(user);
        return "redirect:account/success";
    }

    private User populateUser(UserRegistrationForm userRegistrationForm) {
        User user = new User();
        user.setUsername(userRegistrationForm.getUsername());
        user.setEmail(userRegistrationForm.getEmail());
        user.setPassword(userRegistrationForm.getPassword());
        return user;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(User user) {
        return new ModelAndView("account/login");
    }
}
