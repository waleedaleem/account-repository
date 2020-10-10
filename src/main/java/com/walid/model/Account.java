package com.walid.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    @Past(message = "Balance date should be in the past")
    private LocalDate balanceDate;
    private Currency currency;
    private BigDecimal balance;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account", fetch = FetchType.LAZY)
    private Set<Transaction> transactions;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Account account = (Account) o;
        return accountNumber == account.accountNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    @Override
    public String toString() {
        return "Account{accountNumber=" + accountNumber + ", accountName='" + accountName
                + "', accountType=" + accountType + ", balanceDate=" + balanceDate + ", currency="
                + currency + ", balance=" + balance + "}";
    }

    enum AccountType {
        SAVINGS, CURRENT
    }
}
