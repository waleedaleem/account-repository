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

    private final Logger logger = LoggerFactory.getLogger(getClass());

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

    @GetMapping("/{accountId}")
    public String listAccountTransactions(@PathVariable long accountId, Model model) {
        logger.debug("Listing transactions of account \"{}\"", accountId);
        model.addAttribute("product", accountService.listAccountTransactions(accountId));
        logger.debug("Listed transactions of account \"{}\"", accountId);
        return "accountTransactions";
    }
}
