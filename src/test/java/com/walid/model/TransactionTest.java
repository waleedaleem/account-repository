package com.walid.model;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class TransactionTest {

    private static final Logger logger = LoggerFactory.getLogger(TransactionTest.class);

    @Test
    void test_ensureOnlyOneAmountSet_one_set() {
        Transaction transaction = new Transaction();
        transaction.setCreditAmount(BigDecimal.TEN);
        transaction.setDebitAmount(null);
        logger.debug("All good");
    }

    @Test
    void test_ensureOnlyOneAmountSet_both_set() {
        Transaction transaction = new Transaction();
        transaction.setCreditAmount(BigDecimal.TEN);
        Exception exception = assertThrows(
                RuntimeException.class, () -> transaction.setDebitAmount(BigDecimal.TEN));
        assertNotNull(exception);
    }
}
