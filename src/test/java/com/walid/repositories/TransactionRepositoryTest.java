package com.walid.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    void test_repository_loaded() {
        assertEquals(2, transactionRepository.findByAccountAccountNumberOrderByValueDate(1).size());
    }

    @Test
    void test_repository_filter() {
        assertTrue(
                transactionRepository.findByAccountAccountNumberOrderByValueDate(
                        Long.MIN_VALUE).isEmpty());
    }
}
