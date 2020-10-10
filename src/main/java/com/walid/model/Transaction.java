package com.walid.model;

import static java.math.BigDecimal.ZERO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Transaction implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(Transaction.class);

    private static final long serialVersionUID = -158308464356906721L;

    @Version
    private long version;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "account_number")
    private Account account;

    @Past(message = "Transaction date should be in the past")
    private LocalDate valueDate;
    private Currency currency;

    @Positive
    private BigDecimal debitAmount;

    @Positive
    private BigDecimal creditAmount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Lob
    private String narrative;

    public Transaction() {
        creditAmount = ZERO;
        debitAmount = ZERO;
        transactionType = TransactionType.CREDIT;
    }

    public long getVersion() {
        return version;
    }

    public long getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public LocalDate getValueDate() {
        return valueDate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
        if (debitAmount != null) {
            transactionType = TransactionType.DEBIT;
        }
        ensureOnlyOneAmountSet();
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
        if (creditAmount != null) {
            transactionType = TransactionType.CREDIT;
        }
        ensureOnlyOneAmountSet();
    }

    /**
     * Ensures either debitAmount or creditAmount is set, but not both. <br/>
     * throws {@link IllegalArgumentException}
     */
    void ensureOnlyOneAmountSet() {
        if (ZERO.compareTo(creditAmount) != 0 && ZERO.compareTo(debitAmount) != 0) {
            String msg = "Transaction's credit and debit amounts can not be set at the same time";
            RuntimeException e = new IllegalArgumentException(msg);
            logger.warn(msg, e);
            throw e;
        }
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public String getNarrative() {
        return narrative;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Transaction that = (Transaction) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Transaction{id=" + id + ", account=" + account.getAccountName() + ", valueDate="
                + valueDate + ", currency=" + currency + ", debitAmount=" + debitAmount
                + ", creditAmount=" + creditAmount + ", transactionType=" + transactionType
                + ", narrative='" + narrative + "'}";
    }

    enum TransactionType {
        DEBIT, CREDIT
    }
}
