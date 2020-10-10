package com.walid.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walid.model.Account;
import com.walid.repositories.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Iterable<Account> listAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public List<Object> listAccountTransactions(long id) {
        return null;
    }
}
