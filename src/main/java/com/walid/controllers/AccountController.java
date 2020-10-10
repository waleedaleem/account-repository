package com.walid.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.walid.model.Account;
import com.walid.services.AccountService;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    private AccountService accountService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String listAccounts(Model model) {
        logger.debug("Fetching all accounts");
        Iterable<Account> accounts = accountService.listAllAccounts();
        model.addAttribute("accounts", accounts);
        logger.debug("Fetched all accounts");
        return "accounts";
    }

    @GetMapping("/{accountNumber}")
    public String listAccountTransactions(@PathVariable long accountNumber, Model model) {
        logger.debug("Listing transactions of account Id \"{}\"", accountNumber);
        model.addAttribute("transactions", accountService.listAccountTransactions(accountNumber));
        logger.debug("Listed transactions of account Id \"{}\"", accountNumber);
        return "accountTransactions";
    }
}
