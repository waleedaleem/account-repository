package com.walid.services;

import java.util.List;

import com.walid.model.Account;

public interface AccountService {

    Iterable<Account> listAllAccounts();

    List<Object> listAccountTransactions(long id);
}
