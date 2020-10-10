package com.walid.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walid.model.Account;
import com.walid.model.Transaction;
import com.walid.repositories.AccountRepository;
import com.walid.repositories.TransactionRepository;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository,
                                     TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Iterable<Account> listAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Set<Transaction> listAccountTransactions(long accountNumber) {
        return transactionRepository.findByAccountAccountNumberOrderByValueDate(accountNumber);
    }
}
