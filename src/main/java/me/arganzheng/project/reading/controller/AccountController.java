package me.arganzheng.project.reading.controller;

import javax.validation.Valid;

import me.arganzheng.project.reading.form.UserRegistrationForm;
import me.arganzheng.project.reading.model.User;
import me.arganzheng.project.reading.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService accountService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUp() {
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signUp(@ModelAttribute("userRegistrationForm")
    @Valid
    UserRegistrationForm userRegistrationForm, BindingResult result) {
        if (result.hasErrors()) {
            return "signup";
        }

        User account = populateUser(userRegistrationForm);
        accountService.addUser(account);
        return "redirect:signup_success";
    }

    private User populateUser(UserRegistrationForm userRegistrationForm) {
        User account = new User();
        account.setUsername(userRegistrationForm.getUsername());
        account.setEmail(userRegistrationForm.getEmail());
        account.setPassword(userRegistrationForm.getPassword());
        return account;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model) {
        return "login";
    }
}
