package me.arganzheng.project.reading.service;

import me.arganzheng.project.reading.exception.UserAlreadyExistException;
import me.arganzheng.project.reading.mapper.AccountMapper;
import me.arganzheng.project.reading.model.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountMapper accountDao;

    public Integer addAccount(Account account) {
        if (accountExist(account)) {
            throw new UserAlreadyExistException();
        }

        return accountDao.insertAccount(account);
    }

    public boolean accountExist(Account account) {
        if (accountDao.selectAccountByName(account.getName()) != null) {
            return true;
        }
        return false;
    }

    public Account getAccount(String name) {
        return accountDao.selectAccountByName(name);
    }
}
