DROP TABLE IF EXISTS transaction;
DROP TABLE IF EXISTS account;

CREATE TABLE account
(
    account_number BIGINT PRIMARY KEY NOT NULL,
    account_name   VARCHAR2           NOT NULL,
    account_type   VARCHAR2           NOT NULL,
    balance        DECIMAL(19, 2)     NOT NULL,
    balance_date   DATE               NOT NULL,
    currency       VARCHAR2           NOT NULL,
    version        BIGINT
);

CREATE TABLE transaction
(
    id               IDENTITY PRIMARY KEY NOT NULL,
    currency         VARCHAR2             NOT NULL,
    credit_amount    DECIMAL(19, 2)       NOT NULL,
    debit_amount     DECIMAL(19, 2)       NOT NULL,
    transaction_type VARCHAR2             NOT NULL,
    value_date       DATE                 NOT NULL,
    narrative        CLOB,
    version          BIGINT,
    account_number   BIGINT               NOT NULL,
    foreign key (account_number) references account (account_number)
);

INSERT INTO account (account_number, account_name, account_type, balance, balance_date, currency,
                     version)
VALUES (001, 'acct001', 'SAVINGS', 101.99, '2020-10-01', 'AUD', 0),
       (002, 'acct002', 'CURRENT', 102.99, '2020-10-02', 'USD', 0),
       (003, 'acct003', 'SAVINGS', 103.99, '2020-10-03', 'SGD', 0);

INSERT INTO transaction (account_number, currency, credit_amount, debit_amount, transaction_type,
                         value_date, narrative, version)
VALUES (001, 'AUD', 1.99, 0.00, 'CREDIT', '2020-10-01', 'A couple of $ deposit', 0),
       (001, 'AUD', 0.00, 1.99, 'DEBIT', '2020-10-02', 'Reverse a previous couple of $ deposit', 0),
       (002, 'USD', 2.99, 0.00, 'CREDIT', '2020-10-05', 'a credit txn', 0),
       (003, 'SGD', 3.99, 0.00, 'CREDIT', '2020-10-10', 'a debit txn', 0);