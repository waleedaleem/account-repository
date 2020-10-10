package com.walid.services;

import java.util.Set;

import com.walid.model.Account;
import com.walid.model.Transaction;

public interface AccountService {

    Iterable<Account> listAllAccounts();

    Set<Transaction> listAccountTransactions(long accountNumber);
}
