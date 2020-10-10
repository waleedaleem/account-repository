package com.walid.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.Past;

@Entity
public class Account implements Serializable {

    private static final long serialVersionUID = -158308464356906721L;

    @Version
    private long version;

    @Id
    private long accountNumber;
    private String accountName;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Past
    private LocalDate balanceDate;
    private Currency currency;
    private BigDecimal balance;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getVersion() {
        return version;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public LocalDate getBalanceDate() {
        return balanceDate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    enum AccountType {
        SAVINGS, CURRENT
    }
}
