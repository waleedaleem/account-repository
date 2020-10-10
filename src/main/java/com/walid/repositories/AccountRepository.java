package com.walid.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.walid.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
