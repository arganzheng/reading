package me.arganzheng.project.reading.controller;

import javax.validation.Valid;

import me.arganzheng.project.reading.form.UserRegistrationForm;
import me.arganzheng.project.reading.model.Account;
import me.arganzheng.project.reading.service.AccountService;

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
    private AccountService accountService;

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

        Account account = populateUser(userRegistrationForm);
        accountService.addAccount(account);
        return "redirect:account/success";
    }

    private Account populateUser(UserRegistrationForm userRegistrationForm) {
        Account account = new Account();
        account.setName(userRegistrationForm.getUsername());
        account.setEmail(userRegistrationForm.getEmail());
        account.setPassword(userRegistrationForm.getPassword());
        return account;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(Account user) {
        return new ModelAndView("account/login");
    }
}
