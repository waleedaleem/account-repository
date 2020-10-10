package com.walid.repositories;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.walid.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    Set<Transaction> findByAccountAccountNumberOrderByValueDate(long accountNumber);
}
