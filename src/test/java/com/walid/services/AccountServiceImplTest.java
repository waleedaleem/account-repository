package com.walid.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountServiceImplTest {

    @Autowired
    AccountService accountService;

    @Test
    void test_listAllAccounts() {
        assertTrue(accountService.listAllAccounts().iterator().hasNext());
    }

    @Test
    void test_listAccountTransactions() {
        assertEquals(2, accountService.listAccountTransactions(1).size());
    }
}
